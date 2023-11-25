package com.example.artyzt.ui.calendar;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artyzt.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CalendarAdapter extends RecyclerView.Adapter<CalendarAdapter.ViewHolder> {

    private Activity activity;
    private JSONArray array;
    CalendarAdapter(Activity activity, JSONArray array) {
        this.activity = activity;
        this.array = array;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View artistRow = inflater.inflate(R.layout.artist_row, parent, false);

        CalendarAdapter.ViewHolder viewHolder = new ViewHolder(artistRow);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            JSONObject object = array.getJSONObject(position);

            holder.eventTitle.setText(object.getString("title"));

            String eventType = object.getString("type");
            if (eventType.equals("CONCERT")) {
                holder.eventType.setText("Concert");
            } else if (eventType.equals("PERFORMANCE")) {
                holder.eventType.setText("Performance");
            } else if (eventType.equals("PANEL_DISCUSSION")) {
                holder.eventType.setText("Panel Discussion");
            } else if (eventType.equals("WORKSHOP")) {
                holder.eventType.setText("Workshop");
            } else if (eventType.equals("OTHER")) {
                holder.eventType.setText("Other");
            }

            holder.eventDate.setText(object.getString("date"));
            holder.eventLocation.setText(object.getString("location"));

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int getItemCount() {
        return array.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView eventTitle;
        public TextView eventType;
        public TextView eventDate;
        public TextView eventLocation;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            eventTitle = (TextView) itemView.findViewById(R.id.artist_name);
            eventType = (TextView) itemView.findViewById(R.id.artist_exp);
            eventDate = (TextView) itemView.findViewById(R.id.artist_location);
            eventLocation = (TextView) itemView.findViewById(R.id.artist_talent);
        }
    }
}
