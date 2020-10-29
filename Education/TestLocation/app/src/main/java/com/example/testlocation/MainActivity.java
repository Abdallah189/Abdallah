package com.example.testlocation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GPSTracker gps = new GPSTracker(this);
        double latitude = gps.getLatitude();
        double longitude = gps.getLongitude();
       LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> adresses = null;
        try
        {
            adresses = geocoder.getFromLocation(latitude, longitude, 1);
        }
        catch (IOException ioException)
        {
//            Log.e("GPS", "erreur", ioException);
        } catch (IllegalArgumentException illegalArgumentException)
        {
//            Log.e("GPS", "erreur " + coordonnees, illegalArgumentException);
       }

        if (adresses == null || adresses.size()  == 0)
        {
       //     Log.e("GPS", "erreur aucune adresse !");
        } else {
            Address adresse = adresses.get(0);
            ArrayList<String> addressFragments = new ArrayList<String>();

            String strAdresse = adresse.getAddressLine(0) + ", " + adresse.getLocality();
//            Log.d("GPS", "adresse : " + strAdresse);
       tx=(TextView)findViewById(R.id.texx);
       tx.setText("latitude "+latitude+"longitude : "+longitude+" Str :"+strAdresse);

        Toast.makeText(this,"latitude "+latitude+"longitude : "+longitude+" Str :"+strAdresse,Toast.LENGTH_LONG).show();
    }
    }
}
