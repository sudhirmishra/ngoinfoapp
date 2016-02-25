package com.li8tech.nli8.prototype.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;
import com.li8tech.nli8.prototype.R;
import com.li8tech.nli8.prototype.VolleySingleton;
import com.li8tech.nli8.prototype.pojo.Pojo;
import com.li8tech.nli8.prototype.pojo.Pojo.Doctor;

import java.util.Arrays;
import java.util.List;

/**
 * Created by hduser on 25/2/16.
 */
public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {


    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView movieName;
        public NetworkImageView moviePoster;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            movieName = (TextView) itemView.findViewById(R.id.movieName);
            moviePoster = (NetworkImageView) itemView.findViewById(R.id.moviePoster);
        }
    }

    // Store a member variable for the contacts
    private List<Pojo.Movie> movies;

    // Pass in the contact array into the constructor
    public MovieAdapter(Pojo.Movie[] movies) {
        this.movies= Arrays.asList(movies);
    }

    // Usually involves inflating a layout from XML and returning the holder
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.movie_row, parent, false);

        // Return a new holder instance
        ViewHolder viewHolder = new ViewHolder(contactView);
        return viewHolder;
    }

    // Involves populating data into the item through holder
    @Override
    public void onBindViewHolder(MovieAdapter.ViewHolder viewHolder, int position) {
        // Get the data model based on position
        Pojo.Movie movie = movies.get(position);

        // Set item views based on the data model
        TextView textView = viewHolder.movieName;
        textView.setText(movie.name);

        NetworkImageView imageView = viewHolder.moviePoster;
        imageView.setImageUrl(movie.poster, VolleySingleton.getInstance().getImageLoader());

    }

    // Return the total count of items
    @Override
    public int getItemCount() {
        return movies.size();
    }
}