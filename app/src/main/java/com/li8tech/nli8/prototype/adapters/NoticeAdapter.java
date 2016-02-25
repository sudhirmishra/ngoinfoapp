package com.li8tech.nli8.prototype.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.li8tech.nli8.prototype.R;
import com.li8tech.nli8.prototype.pojo.Pojo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by FDUSER on 25-Feb-16.
 */
public class NoticeAdapter extends RecyclerView.Adapter<NoticeAdapter.MyViewHolder> {

    // Store a member variable for the contacts
    private List<Pojo.Notice> notices;
    private Context context;
    private LayoutInflater inflater;

    // Pass in the contact array into the constructor
    public NoticeAdapter(Pojo.Notice[] notices) {
        this.notices = Arrays.asList(notices);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        context = parent.getContext();
         inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.custom_row_notice, parent, false);

// Return a new holder instance
       MyViewHolder viewHolder = new MyViewHolder(contactView);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        // Get the data model based on position
        Pojo.Notice notice= notices.get(position);

        // Set item views based on the data model
        TextView textViewTitle = holder.noticeTitleTv;
        textViewTitle.setText(notice.title);

        TextView textViewDept = holder.noticeDeptTv;
        textViewDept.setText(notice.venue);

        TextView textViewDate = holder.noticeDeadlineTv;
        textViewDate.setText(notice.eventDate);

    }




    @Override
    public int getItemCount() {
        return notices.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener  {

        public TextView noticeTitleTv;
        public TextView noticeDeptTv;
        public TextView noticeDeadlineTv;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            noticeTitleTv= (TextView) itemView.findViewById(R.id.noticeTitle);
            noticeDeptTv = (TextView) itemView.findViewById(R.id.noticeSub);
            noticeDeadlineTv = (TextView) itemView.findViewById(R.id.noticeDeadline);
        }


        @Override
        public void onClick(View v) {

            Toast.makeText(context,"The Item Clicked is: "+getPosition(),Toast.LENGTH_SHORT).show();
        }
    }


}
