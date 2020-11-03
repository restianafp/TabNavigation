package com.vokasi.tabnavigation;

import android.content.ClipData;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class FirstFragment extends Fragment {


    private ArrayList<itemData> itemValues;
    private RecyclerView recyclerView;
    private  ItemAdapter itemAdapter;
    private FloatingActionButton addButton;

    public FirstFragment() {

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater inflater.inflate(R.layout.fragment_first, container, false);
       recyclerView= view.findViewById(R.id.recycler_view);
       addButton= view.findViewById(R.id.addButton);
       itemValues = new ArrayList<>();
       for (int i =1; i<=10; i++){
           itemData item = new itemData();
           item.itemTitle = "Title Data - " +i;
           item.itemSubtitle = "Subtitle Data - " +i;
           itemValues.add(item);
       }
       itemAdapter= new ItemAdapter(getActivity(),itemValues);
        LinearLayoutManager LayoutManager = new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false);
        GridLayoutManager LayoutManager2 = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(LayoutManager);
        recyclerView.setAdapter(itemAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addData();
            }
        });

       return view;
    }
    private void  addData(){
        itemData item = new itemData();
        item.itemTitle = "Title Data - Baru";
        item.itemSubtitle = "Subtitle Data - Baru" ;
        itemValues.add(item);
        itemAdapter.notifyDataSetChanged();
    }
}