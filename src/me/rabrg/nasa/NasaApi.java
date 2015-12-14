package me.rabrg.nasa;

import com.squareup.okhttp.Headers;
import me.rabrg.nasa.model.apod.AstronomyPictureDay;
import me.rabrg.nasa.model.earth.EarthAssets;
import me.rabrg.nasa.model.earth.EarthImage;
import me.rabrg.nasa.model.mars.MarsRoverPhotos;
import me.rabrg.nasa.model.neo.NearEarthObject;
import me.rabrg.nasa.model.neo.NearEarthObjectBrowse;
import me.rabrg.nasa.model.neo.NearEarthObjectFeed;
import me.rabrg.nasa.service.AstronomyPictureDayService;
import me.rabrg.nasa.service.EarthService;
import me.rabrg.nasa.service.MarsRoverPhotosService;
import me.rabrg.nasa.service.NearEarthObjectService;
import retrofit.Call;
import retrofit.GsonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

import java.io.IOException;

/**
 * The core class of the NASA API.
 *
 * @author Ryan Greene
 */
public final class NasaApi {

    /**
     * The Retrofit instance used to submit REST requests.
     */
    private final Retrofit retrofit;

    /**
     * The service instance used to get data regarding near earth objects.
     */
    private final NearEarthObjectService nearEarthObjectService;

    /**
     * The service instance used to get the astronomy picture of the day.
     */
    private final AstronomyPictureDayService astronomyPictureDayService;

    /**
     * The service instance used to get data regarding
     */
    private final EarthService earthService;

    /**
     * The service instance used to get mars rover photos.
     */
    private final MarsRoverPhotosService marsRoverPhotosService;

    /**
     * The API key which is sent in REST requests.
     */
    private final String apiKey;

    /**
     * The amount of requests allowed per hour.
     */
    private int rateLimit = -1;

    /**
     * The amount of remaining requests allowed to be made this hour.
     */
    private int rateLimitRemaining = -1;

    /**
     * Constructs a new NASA API instance without an API key which makes REST requests default to the demo API key.
     * The demo API key can be used for 30 requests per IP address per hour and 50 requests per IP address per day.
     */
    public NasaApi() {
        this("");
    }

    /**
     * Constructs a new NASA API instance with the specified API key.
     *
     * @param apiKey The API key.
     */
    public NasaApi(final String apiKey) {
        retrofit = new Retrofit.Builder().baseUrl("https://api.nasa.gov").addConverterFactory(GsonConverterFactory
                .create()).build();
        nearEarthObjectService = retrofit.create(NearEarthObjectService.class);
        astronomyPictureDayService = retrofit.create(AstronomyPictureDayService.class);
        earthService  = retrofit.create(EarthService.class);
        marsRoverPhotosService= retrofit.create(MarsRoverPhotosService.class);
        this.apiKey = apiKey;
    }

    /**
     * Gets a list of asteroids based on their closest approach date to Earth.
     *
     * @param startDate The starting date for asteroid search.
     * @param endDate The ending date for asteroid search.
     * @return The list of asteroids based on their closest approach date to Earth.
     * @throws IOException If the call is unsuccessful.
     */
    public NearEarthObjectFeed getNearEarthObjectFeed(final String startDate, final String endDate)
            throws IOException {
        return get(nearEarthObjectService.feed(startDate, endDate, apiKey));
    }

    /**
     * Gets a specific asteroid based on its NASA JPL small body (SPK-ID) ID.
     *
     * @param asteroidId The asteroid SPK-ID correlates to the NASA JPL small body.
     * @return The specific asteroid based on its NASA JPL small body (SPK-ID) ID.
     * @throws IOException If the call is unsuccessful.
     */
    public NearEarthObject getNearEarthObject(final String asteroidId) throws IOException {
        return get(nearEarthObjectService.nearEarthObject(asteroidId, apiKey));
    }

    /**
     * Gets the overall Asteroid data-set.
     *
     * @return The overall Asteroid data-set.
     * @throws IOException If the call is unsuccessful.
     */
    public NearEarthObjectBrowse getNearEarthObjectBrowse() throws IOException {
        return get(nearEarthObjectService.browse(apiKey));
    }

    /**
     * Gets the astronomy picture of the day from the specified date and optionally the concept tags and hd picture.
     *
     * @param date The date of the astronomy picture of the day image to retrieve.
     * @param conceptTags Whether or not an ordered dictionary of concepts from the APOD explanation should be returned.
     * @param hd Whether or not the URL for the high resolution image should be returned.
     * @return The astronomy picture of the day.
     * @throws IOException If the call is unsuccessful.
     */
    public AstronomyPictureDay getAstronomyPictureOfTheDay(final String date, final boolean conceptTags,
            final boolean hd) throws IOException {
        return get(astronomyPictureDayService.astronomyPictureOfTheDay(date, conceptTags, hd, apiKey));
    }

    /**
     * Gets the Landsat 8 image for the supplied location and date.
     *
     * @param lat The latitude of the image.
     * @param lon The longitude of the image.
     * @param dim The width and height of the image in degrees.
     * @param date The date of the image.
     * @param cloudScore Whether or not calculate the percentage of the image covered by clouds.
     * @return The earth image.
     * @throws IOException If the call is unsuccessful.
     */
    public EarthImage getEarthImage(final double lat, final double lon, final double dim, final String date,
            final boolean cloudScore) throws IOException {
        return get(earthService.earthImage(lat, lon, dim, date, cloudScore, apiKey));
    }

    /**
     * Gets the date-times and asset names for available imagery for a supplied location.
     *
     * @param lat The latitude of the assets.
     * @param lon The longitude of the assets.
     * @param begin The beginning of date range.
     * @param end The end of date range.
     * @return The earth assets.
     * @throws IOException If the call is unsuccessful.
     */
    public EarthAssets getEarthAssets(final double lat, final double lon, final String begin, final String end)
            throws IOException {
        return get(earthService.earthAssets(lat, lon, begin, end, apiKey));
    }

    /**
     * Gets mars rover photos for the specified sol, camera, and page.
     *
     * @param sol The sol of the photo.
     * @param camera The camera which took the photo.
     * @param page The page of the photos.
     * @return The photos.
     * @throws IOException If the call is unsuccessful.
     */
    public MarsRoverPhotos getMarsRoverPhotos(final int sol, final String camera, final int page) throws IOException {
        return get(marsRoverPhotosService.marsRoverPhotoSol(sol, camera, page, apiKey));
    }

    /**
     * Gets mars rover photos for the specified earth date, camera, and page.
     *
     * @param earthDate The earth date of the photo.
     * @param camera The camera which took the photo.
     * @param page The page of the photos.
     * @return The photos.
     * @throws IOException If the call is unsuccessful.
     */
    public MarsRoverPhotos getMarsRoverPhotos(final String earthDate, final String camera, final int page) throws IOException {
        return get(marsRoverPhotosService.marsRoverPhotoEarthDate(earthDate, camera, page, apiKey));
    }

    /**
     * Gets the response body for the specified call and sets the rate limit vatiables.
     *
     * @param call The call.
     * @param <T> The type of the call.
     * @return The response body.
     * @throws IOException If the call is unsuccessful.
     */
    private <T> T get(final Call<T> call) throws IOException {
        final Response<T> response = call.execute();
        final Headers headers = response.headers();
        rateLimit = Integer.parseInt(headers.get("X-RateLimit-Limit"));
        rateLimitRemaining = Integer.parseInt(headers.get("X-RateLimit-Remaining"));
        return response.body();
    }

    /**
     * Gets the amount of requests allowed per hour.
     *
     * @return The amount of requests allowed per hour.
     */
    public int getRateLimit() {
        return rateLimit;
    }

    /**
     * Gets the amount of remaining requests allowed to be made this hour.
     *
     * @return The amount of remaining requests allowed to be made this hour.
     */
    public int getRateLimitRemaining() {
        return rateLimitRemaining;
    }
}
