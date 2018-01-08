package com.example.orion_stark.minutes_duplicate.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orion_stark.minutes_duplicate.ItemCardsCollection.InformationHolder;
import com.example.orion_stark.minutes_duplicate.ItemCardsCollection.LocationHolder;
import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.models.BarberShop;
import com.squareup.picasso.Picasso;

/**
 * Created by orionstark on 12/9/17.
 */

public class MultipleViewRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aboutus_item_type1, parent, false);
            return new LocationHolder(view);
        } else if (viewType == 1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.aboutus_item_type2, parent, false);
            return new InformationHolder(view);
        } else {
            return null;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return 0;
        } else if (position == 1) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        String nama = ((Activity) context).getIntent().getStringExtra("barber_data_about");
        BarberShop barber = null;
        for (int i = 0; i < BarberShop.barbers.size(); i++) {
            if (BarberShop.barbers.get(i).nama.equals(nama)) {
                barber = BarberShop.barbers.get(i);
                break;
            }
        }
        if(holder instanceof LocationHolder) {
            final String lat = barber.lat;
            final String lon = barber.lon;
            Picasso.with(context).load("http://maps.google.com/maps/api/staticmap?center=" + lat + "," + lon + "&zoom=15&size=300x200&sensor=false").into(((LocationHolder) holder).mapLocation);
            ((LocationHolder) holder).nameLocation_space.setText(barber.city);
            ((LocationHolder) holder).fullLocationText.setText(barber.locationText);
            ((LocationHolder) holder).mapLocation.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Uri gmmIntentUri = Uri.parse("geo:" + lat + ","+lon);
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    context.startActivity(mapIntent);
                }
            });
        } else if (holder instanceof InformationHolder) {
            ((InformationHolder) holder).name.setText(barber.nama);
            ((InformationHolder) holder).desc.setText(barber.desc);
            ((InformationHolder) holder).openTime.setText("10:00 AM - 10:00 PM");
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
