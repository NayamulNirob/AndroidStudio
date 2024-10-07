package com.neyamul.myapplication;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;

public class Home extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

//    val imageList = ArrayList < SlideModel >() // Create image list
//
//// imageList.add(SlideModel("String Url" or R.drawable)
//// imageList.add(SlideModel("String Url" or R.drawable, "title") You can add title
//
//imageList.add(SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years."))
//            imageList.add(SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct."))
//            imageList.add(SlideModel("https://bit.ly/3fLJf72", "And people do that."))
//
//    val imageSlider = findViewById< ImageSlider >(R.id.image_slider)
//            imageSlider.setImageList(imageList)
}