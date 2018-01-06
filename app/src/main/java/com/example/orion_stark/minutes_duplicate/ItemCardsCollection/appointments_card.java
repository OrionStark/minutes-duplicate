package com.example.orion_stark.minutes_duplicate.ItemCardsCollection;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.orion_stark.minutes_duplicate.R;


public class appointments_card extends RecyclerView.ViewHolder {
    public TextView nama_tempat_pangkas, time_appointment, service_appointment;
    public Button btn;
    public appointments_card(View itemView) {
        super(itemView);
        viewInit(itemView);
    }

    private void viewInit(View view) {
        this.nama_tempat_pangkas = view.findViewById(R.id.card_nama_pangkas);
        this.time_appointment = view.findViewById(R.id.card_time_pangkas);
        this.service_appointment = view.findViewById(R.id.card_service_pangkas);
        this.btn = view.findViewById(R.id.about_card_pangkas);
    }

}
