package com.example.orion_stark.minutes_duplicate.ItemCardsCollection;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.orion_stark.minutes_duplicate.R;

/**
 * Created by orionstark on 12/9/17.
 */

public class LocationHolder extends RecyclerView.ViewHolder {
    public TextView nameLocation_space;
    public ImageView mapLocation;
    public TextView fullLocationText;
    public LocationHolder(View itemView) {
        super(itemView);
        setComponent(itemView);
    }

    private void setComponent(View v) {
        nameLocation_space = v.findViewById(R.id.nameText);
        fullLocationText = v.findViewById(R.id.locationText);
        mapLocation = v.findViewById(R.id.mapImage);
    }
}
