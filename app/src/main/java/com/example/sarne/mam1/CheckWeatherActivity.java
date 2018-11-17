package com.example.sarne.mam1;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sarne.mam1.Strategy.ActivityStrategyProvider;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.JsonHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import cz.msebera.android.httpclient.Header;

public class CheckWeatherActivity extends AppCompatActivity implements NavigationView
        .OnNavigationItemSelectedListener, LocationListener {

    private NavigationView navigationView;
    private Toolbar toolbar;
    private ActivityStrategyProvider _fragmentStrategyProvider = ActivityStrategyProvider.Create();
    private Location lastLocation;
    private LocationManager locationManager;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_weather);

        InitProperties();

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);

        Button loadButton = findViewById(R.id.loadButton);
        loadButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lastLocation!=null) {
                    RequestParams params = new RequestParams();
                    params.put("lat", String.valueOf(lastLocation.getLatitude()));
                    params.put("lon", String.valueOf(lastLocation.getLongitude()));
                    WeatherApiClient.get(params, new JsonHttpResponseHandler() {
                        @Override
                        public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                            try {
                                TextView city = findViewById(R.id.city);
                                city.setText(response.get("name").toString());

                                TextView lon = findViewById(R.id.lon);
                                lon.setText(response.getJSONObject("coord").getString
                                        ("lon"));

                                TextView lat = findViewById(R.id.lat);
                                lat.setText(response.getJSONObject("coord").getString
                                        ("lat"));

                                TextView temp = findViewById(R.id.temp);

                                double kelwin = response.getJSONObject
                                        ("main").getDouble("temp");
                                double celsius = kelwin - 273.15;
                                temp.setText(String.valueOf(celsius));

                                TextView pressure = findViewById(R.id.pressure);
                                pressure.setText(response.getJSONObject("main").getString("pressure"));

                                TextView humidity = findViewById(R.id.humidity);
                                humidity.setText(response.getJSONObject("main").getString("humidity"));

                                TextView description = findViewById(R.id.description);
                                description.setText(response.getJSONArray("weather").getJSONObject(0).getString("description"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    });
                }
            }
        });

    }

    private void InitProperties(){
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        _fragmentStrategyProvider
                .Get(String.valueOf(item.getItemId()))
                .showActivity(CheckWeatherActivity.this);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onLocationChanged(Location location) {
        lastLocation = location;
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude","disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude","enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude","status");
    }
}
