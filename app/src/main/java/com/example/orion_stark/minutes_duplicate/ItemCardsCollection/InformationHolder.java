package com.example.orion_stark.minutes_duplicate.ItemCardsCollection;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.orion_stark.minutes_duplicate.R;

/**
 * Created by orionstark on 12/9/17.
 */

public class InformationHolder extends RecyclerView.ViewHolder {
    public TextView name, phoneNumber, openTime;
    public InformationHolder(View itemView) {
        super(itemView);
        setComponent(itemView);
    }

    private void setComponent(View v) {
        name = v.findViewById(R.id.BarberShopName);
        phoneNumber = v.findViewById(R.id.phoneNumber);
        openTime = v.findViewById(R.id.waktu);
    }
}
