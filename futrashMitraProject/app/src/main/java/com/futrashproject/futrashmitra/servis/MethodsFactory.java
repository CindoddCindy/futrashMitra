package com.futrashproject.futrashmitra.servis;

import com.futrashproject.futrashmitra.model.pojo_login.FoodTrashLoginMitraRespon;
import com.futrashproject.futrashmitra.model.pojo_regis.FoodTrashRegisMitraRespon;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MethodsFactory {

    @Headers({
            "Content-Type:application/json"
    })
    @POST("user/signin")
    Call<FoodTrashLoginMitraRespon> isLoginValid(@Body JsonObject body);



    @Headers({
            "Content-Type:application/json"
    })
    @POST("user/signup")
    Call<FoodTrashRegisMitraRespon> isRegistration(@Body JsonObject body);


    @Headers({
            "Content-Type:application/json"
    })
    @POST("item/users/{id}/items")
    Call<String> isPostDataItem(@Body JsonObject body);


}
