package com.li8tech.nli8.prototype.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by hduser on 25/2/16.
 */
public class Pojo {


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


    public class Category {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("desc")
        @Expose
        public String desc;

    }


    public class Contact {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("password")
        @Expose
        public String password;
        @SerializedName("last_login")
        @Expose
        public String lastLogin;
        @SerializedName("is_superuser")
        @Expose
        public Boolean isSuperuser;
        @SerializedName("username")
        @Expose
        public String username;
        @SerializedName("first_name")
        @Expose
        public String firstName;
        @SerializedName("last_name")
        @Expose
        public String lastName;
        @SerializedName("email")
        @Expose
        public String email;
        @SerializedName("is_staff")
        @Expose
        public Boolean isStaff;
        @SerializedName("is_active")
        @Expose
        public Boolean isActive;
        @SerializedName("date_joined")
        @Expose
        public String dateJoined;
    /*@SerializedName("groups")
    @Expose
    public List<Object> groups = new ArrayList<Object>();
    @SerializedName("user_permissions")
    @Expose
    public List<Object> userPermissions = new ArrayList<Object>();*/

    }

    public class Notice {

        @SerializedName("id")
        @Expose
        public Integer id;
        @SerializedName("title")
        @Expose
        public String title;
        @SerializedName("body")
        @Expose
        public String body;
        @SerializedName("category")
        @Expose
        public List<Category> category = new ArrayList<Category>();
        @SerializedName("registration")
        @Expose
        public Boolean registration;
        @SerializedName("event_date")
        @Expose
        public String eventDate;
        @SerializedName("image")
        @Expose
        public String image;
        @SerializedName("contact")
        @Expose
        public List<Contact> contact = new ArrayList<Contact>();
        @SerializedName("venue")
        @Expose
        public String venue;
        @SerializedName("deadline")
        @Expose
        public String deadline;

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

    }


}
