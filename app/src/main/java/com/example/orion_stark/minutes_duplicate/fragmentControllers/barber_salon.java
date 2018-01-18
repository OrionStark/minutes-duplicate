package com.example.orion_stark.minutes_duplicate.fragmentControllers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.orion_stark.minutes_duplicate.R;

/**
 * Created by evan on 18/01/18.
 */

public class barber_salon extends Fragment {
    View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: Implement this method
        view = inflater.inflate(R.layout.fragment_barber_salon, container, false);
        return view;
    }
}
