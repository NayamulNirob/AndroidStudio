package com.nayamul.realestate.activittes;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nayamul.realestate.Adapter.ItemsAdapter;
import com.nayamul.realestate.Domin.ItemsDomin;
import com.nayamul.realestate.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterPopular, adapterNew;
    private RecyclerView recyclerViewPopular, recyclerViewNew;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<ItemsDomin> itemsArrayList = new ArrayList<>();

        itemsArrayList.add(new ItemsDomin(
                "House with a great view",
                "5/C,Mohammadpur,Dhaka",
                "This 2 bed /2 bath home boasts an enormous,\n" +
                        "open-living plan,accented by striking \n" +
                        "Feel inspired by open sight lines that\n" +
                        "embrace the outdoors, crowned by stunning\n" +
                        "offered ceiling.",
                2, 2, 841456, "pic1", true));

        itemsArrayList.add(new ItemsDomin(
                "House with a great view",
                "50/A,32,Dhanmondhi,Dhaka",
                "This 3 bed /2 bath home boasts an enormous,\n" +
                        "open-living plan,accented by striking \n" +
                        "Feel inspired by open sight lines that\n" +
                        "embrace the outdoors, crowned by stunning\n" +
                        "offered ceiling.",
                3, 2, 941456, "pic2", true));


        itemsArrayList.add(new ItemsDomin(
                "House with a great view",
                " C/2,2,Jafrabad,Chittagong",
                "This 2 bed /1 bath home boasts an enormous,\n" +
                        "open-living plan,accented by striking \n" +
                        "Feel inspired by open sight lines that\n" +
                        "embrace the outdoors, crowned by stunning\n" +
                        "offered ceiling.",
                2, 2, 641456, "pic1", false));


        recyclerViewPopular = findViewById(R.id.viewPopular);
        recyclerViewNew=findViewById(R.id.viewNew);

        recyclerViewPopular.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        recyclerViewNew.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        adapterNew=new ItemsAdapter(itemsArrayList);
        adapterPopular=new ItemsAdapter(itemsArrayList);

        recyclerViewNew.setAdapter(adapterNew);
        recyclerViewPopular.setAdapter(adapterPopular);
    }
}