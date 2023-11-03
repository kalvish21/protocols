package com.example.artyzt.ui.home;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artyzt.R;
import com.example.artyzt.ui.userprofile.UserProfileActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ArtistHomeAdapter extends RecyclerView.Adapter<ArtistHomeAdapter.ViewHolder> {

    private Activity activity;
    private JSONArray array;
    ArtistHomeAdapter(Activity activity, JSONArray array) {
        this.activity = activity;
        this.array = array;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View artistRow = inflater.inflate(R.layout.artist_row, parent, false);

        ViewHolder viewHolder = new ViewHolder(artistRow);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            JSONObject object = array.getJSONObject(position);

            String fullName = String.format("%s %s", object.getString("firstName"), object.getString("lastName"));
            holder.artistName.setText(fullName);
            holder.artistExp.setText(object.getString("experience"));
            holder.artistLoc.setText(object.getString("location"));
            holder.artistTalent.setText(object.getString("talent"));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    try {
                        Intent intent = new Intent(activity, UserProfileActivity.class);
                        intent.putExtra("fullName", fullName);
                        intent.putExtra("talent", object.getString("talent"));
                        intent.putExtra("location", object.getString("location"));
                        intent.putExtra("experience", object.getString("experience"));
                        intent.putExtra("biography", object.getString("biography"));
                        intent.putExtra("contactInfo", object.getString("contactInfo"));
                        activity.startActivity(intent);
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                }
            });

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
        public TextView artistName;
        public TextView artistExp;
        public TextView artistLoc;
        public TextView artistTalent;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            artistName = (TextView) itemView.findViewById(R.id.artist_name);
            artistExp = (TextView) itemView.findViewById(R.id.artist_exp);
            artistLoc = (TextView) itemView.findViewById(R.id.artist_location);
            artistTalent = (TextView) itemView.findViewById(R.id.artist_talent);
        }
    }
}
