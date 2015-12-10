package me.rabrg.nasa.service;

import me.rabrg.nasa.model.apod.AstronomyPictureDay;
import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

public interface AstronomyPictureDayService {

    @GET("/planetary/apod")
    Call<AstronomyPictureDay> astronomyPictureOfTheDay(@Query("date") String date,
                                                       @Query("concept_tags") boolean conceptTags, @Query("hd") boolean hd, @Query("api_key") String apiKey);
}
