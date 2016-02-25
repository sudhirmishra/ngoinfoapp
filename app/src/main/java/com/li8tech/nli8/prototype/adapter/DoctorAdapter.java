package com.li8tech.nli8.prototype.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.li8tech.nli8.prototype.R;
import com.li8tech.nli8.prototype.pojo.Pojo.Doctor;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hduser on 25/2/16.
 */
public class DoctorAdapter extends RecyclerView.Adapter<DoctorAdapter.ViewHolder> {


    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView doctorNameTextView;
        public TextView availabilityTextView;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            doctorNameTextView = (TextView) itemView.findViewById(R.id.doctor);
            availabilityTextView = (TextView) itemView.findViewById(R.id.availability);
        }
    }

    // Store a member variable for the contacts
    private List<Doctor> doctors;

    // Pass in the contact array into the constructor
    public DoctorAdapter(Doctor[] doctors) {
        this.doctors = Arrays.asList(doctors);
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public DoctorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.medical_center_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(DoctorAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Doctor doctor = doctors.get(position);

        // Set item views based on the data model
        TextView textView = viewHolder.doctorNameTextView;
        textView.setText(doctor.name);

        TextView textView1 = viewHolder.availabilityTextView;
        textView1.setText(doctor.availability);

    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return doctors.size();
    }
}