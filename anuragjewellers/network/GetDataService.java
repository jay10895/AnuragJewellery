package com.example.anuragjewellers.network;

import com.example.anuragjewellers.model.Login;
import com.example.anuragjewellers.model.Party;
import com.example.anuragjewellers.model.Register;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface GetDataService {

    @FormUrlEncoded
    @POST("index.php/wp-json/wp/v2/users/login/")
    Call<Login> login(@Field("username") String username
            , @Field("password") String password);

    @FormUrlEncoded
    @POST("index.php/wp-json/wp/v2/users/register/")
    Call<Register> register(@Field("username") String username,
                            @Field("email") String email,
                            @Field("password") String password,
                            @Field("confirm_password") String confirm_password,
                            @Field("phone_number") String phone_number,
                            @Field("role") String role);


    @GET("index.php/wp-json/wp/v2/get-salesman/")
    Call<ResponseBody> salesmanlist();


    @FormUrlEncoded
    @POST("index.php/wp-json/wp/v2/add-jeweler/")
    Call<ResponseBody> newsalesentry(@Field("user_id")String user_id,
                                     @Field("description")String description,
                                     @Field("weight")String weight,
                                     @Field("touch")String touch,
                                     @Field("fine")String fine,
                                     @Field("payment")String payment,
                                     @Field("salesman_id")String salesman_id,  //date, image baki
                                     @Field("jeweler_name")String jeweler_name,
                                     @Field("mode")String mode);

    @FormUrlEncoded
    @POST("index.php/wp-json/wp/v2/get-jeweler")
    Call<ResponseBody> getjewelerslist(@Field("user_id") String veparuser_id,
                                       @Field("salesman_id") String salesman_id);



    @FormUrlEncoded
    @POST("index.php/wp-json/wp/v2/get-sale-data")
    Call<ResponseBody> getsalesdata(@Field("jeweler") String vepari_id);


    @FormUrlEncoded
    @POST("index.php/wp-json/wp/v2/add-jeweler-details")
    Call<Party> addjewelerData(@Field("user_id") String user_id,
                               @Field("salesman_id") String salesman_id,
                               @Field("name") String name,
                               @Field("city") String city,
                               @Field("number") String number);

    @FormUrlEncoded
    @POST("index.php/wp-json/wp/v2/add-sale-data")
    Call<ResponseBody> newsalesentry2(@Field("user_id")String user_id,
                                      @Field("salesman_id")String salesman_id,
                                      @Field("jeweler")String jeweler_name,
                                      @Field("title")String description,
                                      @Field("weight")String weight,
                                      @Field("touch")String touch,
                                      @Field("fine")String fine,
                                      @Field("payment")String payment,
                                      //date, image baki

                                      @Field("mode")String mode);


    @FormUrlEncoded
    @POST("index.php/wp-json/wp/v2/get-jeweler")
    Call<ResponseBody> getsalesdata(@Field("user_id") String user_id,
                                    @Field("jeweler_name") String jeweler_name);

    @FormUrlEncoded
    @POST("index.php/wp-json/wp/v2/delete-data-entry")
    Call<ResponseBody> deletedataentry(@Field("data_id") String data_id);

}
