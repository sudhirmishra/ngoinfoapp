package com.li8tech.nli8.prototype;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.li8tech.nli8.prototype.pojo.Pojo.Doctor;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import static com.li8tech.nli8.prototype.Keys.*;

/**
 * A placeholder fragment containing a simple view.
 */
public class MedicalCenterFragment extends Fragment {

    private VolleySingleton volleySingleton;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private String medcUrl = "http://pilock.pythonanywhere.com/api/doctors/";

    public MedicalCenterFragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        volleySingleton = VolleySingleton.getInstance();
        requestQueue = volleySingleton.getRequestQueue();


        GsonRequest<Doctor[]> gsonRequest = new GsonRequest<Doctor[]>(medcUrl,Doctor[].class,new HashMap<String,String>(),createNewAdapter(),handleException(), Request.Method.GET);

        requestQueue.add(gsonRequest);
        /*JsonArrayRequest request = new JsonArrayRequest(medcUrl, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                parseJSONResponce(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }


        );

        requestQueue.add(request);*/
    }

    private Response.Listener<Doctor[]> createNewAdapter() {
        return new Response.Listener<Doctor[]> () {
            @Override
            public void onResponse(Doctor[] response) {
                //

                for (int i = 0; i < response.length; i++) {
                    Toast.makeText(MyApplication.getAppContext(),
                            "DOCTOR : " + response[i].name,
                            Toast.LENGTH_SHORT).show();
                }
            }


        };
    }

    private Response.ErrorListener handleException() {
        return new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.print(error.getStackTrace());
            }
        };
    }

    private void parseJSONResponce(JSONArray response) {

        if(response == null || response.length() == 0){

            return;
        }

        try {
            StringBuilder data = new StringBuilder();
            // Parsing json array response
            // loop through each json object
            for (int i = 0; i < response.length(); i++) {

                JSONObject doc = (JSONObject) response.get(i);

                String name = doc.getString(KEYS_DOC_NAME);
                String avail = doc.getString(KEYS_DOC_AVAIL);
                String specf = doc.getString(KEYS_DOC_SPECS);

                data.append(name +"\n"+avail+"\n"+specf+"\n\n");

                Toast.makeText(MyApplication.getAppContext(),
                        "DOCTOR : "+data.toString(),
                        Toast.LENGTH_SHORT).show();

            }

        }
        catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(MyApplication.getAppContext(),
                    "Error: " + e.getMessage(),
                    Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_medical_center, container, false);
    }
}
