package com.example.app_insta;

import com.example.app_insta.Models.User;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<User>> getUsers(
            @Query("userId") Integer[] userId,
            @Query("sort") String sort,
            @Query("_order") String order);
    @GET("posts")
    Call<List<User>> getUsers(@QueryMap Map<String, String> parameters);

  //@GET("posts/{id})
   // Call<List<User>> getUsers(@Path("id")int mId);

    @GET
    Call<List<User>> getUsers(@Url String url);

    @POST("posts")
    Call<User> createUsers(@Body User user);

    @FormUrlEncoded
    @POST("posts")
    Call<User> createUsers(
            @Field("userName") String userName,
            @Field("likes") int likes
    );

    @FormUrlEncoded
    @POST("posts")
    Call<User> createUsers(@FieldMap Map<String, String>fields);

    @PUT("posts/{id}")
    Call<User> putUser(@Path(("id") int id, @Body Post post));//kompletno go zamenuvame postoeckiot resource so toj sto go isrativme

    @PATCH("posts/{id}")
    Call<User> patchUser(@Path(("id") int id, @Body Post post));//samo gi menuvame fiels-ot koi se isprateni

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path(("id") int id));


}
