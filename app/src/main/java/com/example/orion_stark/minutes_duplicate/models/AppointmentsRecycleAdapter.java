package com.example.orion_stark.minutes_duplicate.models;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orion_stark.minutes_duplicate.ItemCardsCollection.Empty_Appointment;
import com.example.orion_stark.minutes_duplicate.ItemCardsCollection.appointments_card;
import com.example.orion_stark.minutes_duplicate.R;
import com.example.orion_stark.minutes_duplicate.controllers.About;

/**
 * Created by orionstark on 1/6/18.
 */

public class AppointmentsRecycleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        if ( Appointment.appointments.size() <= 0 ) {
            View view;
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_empty__appointment, parent, false);
            return new Empty_Appointment(view);
        } else {
            View view;
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_appointments_card, parent, false);
            return new appointments_card(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if ( holder instanceof appointments_card ) {
            ((appointments_card) holder).nama_tempat_pangkas.setText(Appointment.appointments.get(position).barberShop.nama);
            ((appointments_card) holder).service_appointment.setText(Appointment.appointments.get(position).service);
            ((appointments_card) holder).time_appointment.setText(Appointment.appointments.get(position).time);
            ((appointments_card) holder).btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    context.startActivity(new Intent(context, About.class).putExtra("barber_data_about", BarberShop.barbers.get(position).nama));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if ( Appointment.appointments.size() > 0 ) {
            return Appointment.appointments.size();
        } else {
            return 1;
        }
    }
}
