package com.example.mairiebizerte;

import androidx.appcompat.app.AppCompatActivity;

import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.Response;
import com.android.volley.TimeoutError;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         txt=(TextView)findViewById(R.id.txt1);
         String URL_DATA ="http://10.0.2.2:8000/article/";
        StringRequest str=new StringRequest(StringRequest.Method.GET, URL_DATA, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                JSONArray array=null;
                try {
                array =new JSONArray(response);
                    JSONObject obj=array.getJSONObject(1);
                    txt.setText(obj.getString("sdfsd"));
                }catch (Exception e){
                    txt.setText(e.getMessage());
                }
                // txt.setText(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error.networkResponse == null) {
                    if (error.getClass().equals(TimeoutError.class)) {
                        // Show timeout error message
                        Toast.makeText(MainActivity.this,
                                "Oops. Timeout error!",
                                Toast.LENGTH_LONG).show();
                    }
                }
                txt.setText(error.toString());
                Toast.makeText(MainActivity.this," "+error,Toast.LENGTH_LONG).show();
            }
        });
        str.setRetryPolicy(new DefaultRetryPolicy(
                15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        Volley.newRequestQueue(this).add(str);
    }
}
