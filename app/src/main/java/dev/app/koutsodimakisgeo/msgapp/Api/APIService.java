package dev.app.koutsodimakisgeo.msgapp.Api;

import dev.app.koutsodimakisgeo.msgapp.Models.Message;
import dev.app.koutsodimakisgeo.msgapp.Models.MessageResponse;
import dev.app.koutsodimakisgeo.msgapp.Models.Messages;
import dev.app.koutsodimakisgeo.msgapp.Models.Result;
import dev.app.koutsodimakisgeo.msgapp.Models.Users;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import static android.R.attr.path;

/**
 * Created by koutsodimakisgeo on 09-Oct-17.
 */

public interface APIService {

    @FormUrlEncoded
    @POST("register")
    Call<Result> createUser(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("gender") String gender);


    @FormUrlEncoded
    @POST("login")
    Call<Result> userLogin(
            @Field("email") String email,
            @Field("password") String password
    );


    @GET("users")
    Call<Users> getUsers();

    @FormUrlEncoded
    @POST("sendmessage")
    Call<MessageResponse> sendMessage(
            @Field("from") int from,
            @Field("to") int to,
            @Field("title") String title,
            @Field("message") String message);

    @FormUrlEncoded
    @POST("update/{id}")
    Call<Result> updateUser(
            @Path("id") int id,
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("gender") String gender
    );

    //getting messages
    @GET("messages/{id}")
    Call<Messages> getMessages(@Path("id") int id);
}