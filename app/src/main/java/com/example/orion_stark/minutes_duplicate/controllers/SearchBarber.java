package com.example.orion_stark.minutes_duplicate.controllers;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.models.BarberShop;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.location.LocationSettingsResult;
import com.google.android.gms.location.LocationSettingsStatusCodes;

public class SearchBarber extends AppCompatActivity implements LocationListener, GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

    private LocationManager locationManager;
    private final int REQUEST_PERMISSION_CODE = 20;
    TextView myLocation;

    GoogleApiClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_barber);
        viewInit();
        AfterViewInit();
    }

    private void viewInit() {
        this.myLocation = findViewById(R.id.myLocation);
    }

    private void AfterViewInit() {
        this.locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        requestSetting();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        this.locationManager.removeUpdates(this);
        finish();
    }

    @Override
    protected void onPause() {
        super.onPause();
        this.locationManager.removeUpdates(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        requestSetting();
    }


    // Location Listener
    @Override
    public void onLocationChanged(Location location) {
        Location barber_location = new Location("");
        this.myLocation.setText("Lat : " + location.getLatitude() + ", Lon : " + location.getLongitude());
        for ( int i = 0; i < BarberShop.barbers.size(); i++) {
            barber_location.setLatitude(Double.valueOf(BarberShop.barbers.get(i).lat));
            barber_location.setLongitude(Double.valueOf(BarberShop.barbers.get(i).lon));
            // Toast.makeText(this, "" + (location.distanceTo(barber_location) / 1000) + " km", Toast.LENGTH_SHORT).show();
            if ( location.distanceTo(barber_location) / 1000 <= 0.1 ) {
                Toast.makeText(this, "Got it", Toast.LENGTH_LONG).show();
                startActivity(new Intent( SearchBarber.this, About.class).putExtra("barber_data_about",
                        BarberShop.barbers.get(i).nama));
                break;
            }
        }
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }


    // Google Api Client
    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }

    private void requestSetting() {
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi(LocationServices.API).addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        mGoogleApiClient.connect();
        LocationRequest locationRequest = LocationRequest.create();
        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        locationRequest.setInterval(5 * 1000);
        locationRequest.setFastestInterval(3 * 1000);
        LocationSettingsRequest.Builder builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(locationRequest);
        builder.setAlwaysShow(true);
        PendingResult<LocationSettingsResult> result =
                LocationServices.SettingsApi.checkLocationSettings(mGoogleApiClient, builder.build());
        result.setResultCallback(new ResultCallback<LocationSettingsResult>() {
            @Override
            public void onResult(LocationSettingsResult result) {
                final Status status = result.getStatus();
                switch (status.getStatusCode()) {
                    case LocationSettingsStatusCodes.SUCCESS:
                        if (ActivityCompat.checkSelfPermission(SearchBarber.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(SearchBarber.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(SearchBarber.this, new String[]{
                                    Manifest.permission.ACCESS_FINE_LOCATION,
                                    Manifest.permission.INTERNET,
                                    Manifest.permission.ACCESS_NETWORK_STATE,
                                    Manifest.permission.ACCESS_COARSE_LOCATION
                            }, REQUEST_PERMISSION_CODE);
                        } else {
                            locationManager.requestLocationUpdates("gps", 0, 0, SearchBarber.this);
                            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, SearchBarber.this);
                        }
                        break;
                    case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:
                        try {
                            status.startResolutionForResult(SearchBarber.this, 0x3);
                        } catch (IntentSender.SendIntentException e) {
                            Log.d("Error", e.getMessage());
                        }
                        break;
                    case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                        break;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 0x3:
                switch (resultCode) {
                    case Activity.RESULT_OK:
                        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(SearchBarber.this, new String[]{
                                    Manifest.permission.ACCESS_FINE_LOCATION,
                                    Manifest.permission.INTERNET,
                                    Manifest.permission.ACCESS_NETWORK_STATE,
                                    Manifest.permission.ACCESS_COARSE_LOCATION
                            }, REQUEST_PERMISSION_CODE);
                        } else {
                            locationManager.requestLocationUpdates("gps", 0, 0, this);
                            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, this);
                        }
                        break;
                    case Activity.RESULT_CANCELED:
                        startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
                        break;
                }
                break;
        }
    }
}
