package com.example.artyzt.ui.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artyzt.R;
import com.example.artyzt.ui.home.ArtistHomeAdapter;

public class DashboardAdapter extends RecyclerView.Adapter<DashboardAdapter.ViewHolder> {
    @NonNull
@Override
public DashboardAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    Context context = parent.getContext();
    LayoutInflater inflater = LayoutInflater.from(context);

    View artistRow = inflater.inflate(R.layout.artist_row, parent, false);

    DashboardAdapter.ViewHolder viewHolder = new DashboardAdapter.ViewHolder(artistRow);
    return viewHolder;
}

    @Override
    public void onBindViewHolder(@NonNull DashboardAdapter.ViewHolder holder, int position) {
        holder.artistName.setText("Shan");
        holder.artistExp.setText("5 Years");
        holder.artistLoc.setText("New Jersey");
        holder.artistTalent.setText("Drums");
    }

    @Override
    public int getItemCount() {
        return 100;
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

