package com.li8tech.nli8.prototype.pojo;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by hduser on 25/2/16.
 */
public class Pojo {

    public static final String API_BASE_URL = "http://pilock.pythonanywhere.com/api/";

    public static HashMap<String, String > timeTypeMap = new HashMap<String, String>(){{
        put("07:00:00","Breakfast");
        put("12:00:00","Lunch");
        put("19:00:00","Dinner");
    }};

    /**
     * Created by hduser on 25/2/16.
     */

    public class Doctor {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("availability")
        @Expose
        public String availability;
        @SerializedName("specialization")
        @Expose
        public String specialization;

    }


    public class Hostel {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("capacity")
        @Expose
        public Integer capacity;

    }
    public class Item {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("desc")
        @Expose
        public Object desc;
        @SerializedName("image")
        @Expose
        public String image;

    }

    public class Mess {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("hostels")
        @Expose
        public List<Hostel> hostels = new ArrayList<Hostel>();

    }


    public class MessMenu {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("items")
        @Expose
        public List<Item> items = new ArrayList<Item>();
        @SerializedName("date")
        @Expose
        public String date;
        @SerializedName("time")
        @Expose
        public String time;
        @SerializedName("mess")
        @Expose
        public List<Mess> mess = new ArrayList<Mess>();

    }

    public class Movie{

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("date")
        @Expose
        public String date;
        @SerializedName("venue")
        @Expose
        public String venue;
        @SerializedName("poster")
        @Expose
        public String poster;
    }

    public class Place {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("timings")
        @Expose
        public String timings;

    }

}
