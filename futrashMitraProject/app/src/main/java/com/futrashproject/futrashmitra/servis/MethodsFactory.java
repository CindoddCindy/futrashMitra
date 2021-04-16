package com.futrashproject.futrashmitra.servis;

import com.futrashproject.futrashmitra.model.pojo_confirm.get_confirm.GetConfirmRespon;
import com.futrashproject.futrashmitra.model.pojo_confirm.post_confirm.MitraPostConfirmRespon;
import com.futrashproject.futrashmitra.model.pojo_item.pojo_get_item.FoodTrashMitraGetItemRespon;
import com.futrashproject.futrashmitra.model.pojo_item.pojo_post_item.FoodTrashMitraPostItemRespon;
import com.futrashproject.futrashmitra.model.pojo_login.FoodTrashLoginMitraRespon;
import com.futrashproject.futrashmitra.model.pojo_order.get_order.MitraGetOrderRespon;
import com.futrashproject.futrashmitra.model.pojo_regis.FoodTrashRegisMitraRespon;
import com.google.gson.JsonObject;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

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
    Call<FoodTrashMitraPostItemRespon> isPostDataItem(@Path ("id") Long id, @HeaderMap Map<String,String > Map, @Body JsonObject body);


    @Headers({
            "Content-Type:application/json"
    })
    @GET("order/users/{id}/orders")
    Call<MitraGetOrderRespon> getOrder(@Path ("id") Long id, @HeaderMap Map<String,String > Map);


    @Headers({
            "Content-Type:application/json"
    })
    @GET("item/users/{id}/items")
    Call<FoodTrashMitraGetItemRespon> getItem(@Path ("id") Long id, @HeaderMap Map<String,String > Map);


    @Headers({
            "Content-Type:application/json"
    })
    @POST("confirm/users/{id}/confirm")
    Call<MitraPostConfirmRespon> postConfirmToMySelf(@Path ("id") Long id, @HeaderMap Map<String,String > Map, @Body JsonObject body);

    @Headers({
            "Content-Type:application/json"
    })
    @POST("confirm/users/{id}/confirm")
    Call<MitraPostConfirmRespon> postConfirmToBuyer(@Path ("id") Long id, @HeaderMap Map<String,String > Map, @Body JsonObject body);




    @Headers({
            "Content-Type:application/json"
    })
    @GET("confirm/users/{id}/confirm")
    Call<GetConfirmRespon> getListConfirm(@Path ("id") Long id, @HeaderMap Map<String,String > Map);


    //edit delete

    @Headers({
            "Content-Type:application/json"
    })
    @PUT("")
    Call<String> editItem(@Path ("id") Long id, @Path ("id") Long idEditItem,@HeaderMap Map<String,String > Map, @Body JsonObject body);

    @Headers({
            "Content-Type:application/json"
    })
    @PUT("")
    Call<String> editConfirm(@Path ("id") Long id,@Path ("id") Long idConfirmEdit, @HeaderMap Map<String,String > Map,@Body JsonObject body);

    @Headers({
            "Content-Type:application/json"
    })
    @PUT("")
    Call<String> editConfirmToOwnSelf(@Path ("id") Long id,@Path ("id") Long idConfirmEdit, @HeaderMap Map<String,String > Map,@Body JsonObject body);



    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("")
    Call<String> deleteItem(@Path ("id") Long id,@Path ("id") Long idItem, @HeaderMap Map<String,String > Map);


    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("")
    Call<GetConfirmRespon> deleteOrder(@Path ("id") Long id, @Path ("id") Long idOrder,@HeaderMap Map<String,String > Map);

    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("")
    Call<GetConfirmRespon> deleteConfirm(@Path ("id") Long id, @Path ("id") Long idConfirm, @HeaderMap Map<String,String > Map);






}
