package com.neyamul.learning;

import com.neyamul.learning.model.Slide;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface SlideApi {

        @GET("get_slides.php")
        Call<List<Slide>>  getSlides();


}
