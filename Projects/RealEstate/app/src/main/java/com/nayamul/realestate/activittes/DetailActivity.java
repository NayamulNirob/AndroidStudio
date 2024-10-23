package com.nayamul.realestate.activittes;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.nayamul.realestate.Domin.ItemsDomin;
import com.nayamul.realestate.R;

import java.text.DecimalFormat;
import java.util.Objects;

public class DetailActivity extends AppCompatActivity {

    private TextView titleTxt,addressTxt,bedTxt,bathTxt,wifiTxt,descriptionTxt,priceTxt;
    private ItemsDomin itemsDomin;
    private ImageView pic;

    DecimalFormat formatter=new DecimalFormat("###,###,###.##");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        setVariable();

    }

    @SuppressLint("SetTextI18n")
    private void setVariable() {
        itemsDomin = (ItemsDomin) getIntent().getSerializableExtra("object");

        titleTxt.setText(itemsDomin.getTitle());
        addressTxt.setText(itemsDomin.getAddress());
        bedTxt.setText(itemsDomin.getBed() + " Bed");
        bathTxt.setText(itemsDomin.getBath()+ " Bath");
        descriptionTxt.setText(itemsDomin.getDescription());
        priceTxt.setText("$"+formatter.format(itemsDomin.getPrice()));

        if(itemsDomin.isWifi()){
            wifiTxt.setText("Wifi");
        }
        else {
            wifiTxt.setText("No-Wifi");
        }

        @SuppressLint("DiscouragedApi") int drawableResourceId=getResources().getIdentifier(itemsDomin.getPic(),"drawable",getPackageName());

        Glide.with(this)
                .load(drawableResourceId)
                .into(pic);

    }

    private void initView() {
        titleTxt=findViewById(R.id.titleTxt);
        addressTxt=findViewById(R.id.addressTxt);
        bedTxt=findViewById(R.id.bedTxt);
        bathTxt=findViewById(R.id.bathTxt);
        wifiTxt=findViewById(R.id.wifiTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        pic=findViewById(R.id.pic);
        priceTxt=findViewById(R.id.priceTxt);

    }
}