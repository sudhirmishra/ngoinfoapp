package com.li8tech.nli8.prototype.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.li8tech.nli8.prototype.R;
import com.li8tech.nli8.prototype.VolleySingleton;
import com.li8tech.nli8.prototype.pojo.Pojo;

import org.w3c.dom.Text;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hduser on 25/2/16.
 */
public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {


    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView name;
        public TextView timings;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.name);
            timings = (TextView) itemView.findViewById(R.id.timings);
        }
    }

    // Store a member variable for the contacts
    private List<Pojo.Place> places;

    // Pass in the contact array into the constructor
    public PlaceAdapter(Pojo.Place[] places) {
        this.places = Arrays.asList(places);
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public PlaceAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.place_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(PlaceAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Pojo.Place place = places.get(position);

        // Set item views based on the data model
        viewHolder.name.setText(place.name);
        viewHolder.timings.setText(place.timings);
    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return places.size();
    }
}