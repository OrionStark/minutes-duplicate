package com.example.orion_stark.minutes_duplicate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.orion_stark.minutes_duplicate.controllers.RecyclerAdapter;

public class Home_Page extends AppCompatActivity {
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        //menampilkan reyclerview yang ada pada file layout dengan id reycler view

        RecyclerAdapter adapter = new RecyclerAdapter(this);
        //membuat adapter baru untuk reyclerview
        recyclerView.setAdapter(adapter);
        //menset nilai dari adapter
        recyclerView.setHasFixedSize(true);
        //menset setukuran
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //menset layoutmanager dan menampilkan daftar/list
        //dalam bentuk linearlayoutmanager pada class saat ini
    }
}
