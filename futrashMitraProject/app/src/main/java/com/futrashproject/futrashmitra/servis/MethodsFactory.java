package com.futrashproject.futrashmitra.servis;

import com.futrashproject.futrashmitra.model.pojo_confirm.get_confirm.GetConfirmRespon;
import com.futrashproject.futrashmitra.model.pojo_confirm.post_confirm.MitraPostConfirmRespon;
import com.futrashproject.futrashmitra.model.pojo_item.pojo_edit_item.MitraEditItemRespon;
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
    @POST("item/users/{userId}/items")
    Call<FoodTrashMitraPostItemRespon> isPostDataItem(@Path ("userId") Long id, @HeaderMap Map<String,String > Map, @Body JsonObject body);


    @Headers({
            "Content-Type:application/json"
    })
    @GET("order/users/{userId}/orders")
    Call<MitraGetOrderRespon> getOrder(@Path ("userId") Long id, @HeaderMap Map<String,String > Map);


    @Headers({
            "Content-Type:application/json"
    })
    @GET("item/users/{userId}/items")
    Call<FoodTrashMitraGetItemRespon> getItem(@Path ("userId") Long id, @HeaderMap Map<String,String > Map);


    @Headers({
            "Content-Type:application/json"
    })
    @POST("confirm/users/{userId}/confirm")
    Call<MitraPostConfirmRespon> postConfirmToMySelf(@Path ("userId") Long id, @HeaderMap Map<String,String > Map, @Body JsonObject body);

    @Headers({
            "Content-Type:application/json"
    })
    @POST("confirm/users/{userId}/confirm")
    Call<MitraPostConfirmRespon> postConfirmToBuyer(@Path ("userId") Long id, @HeaderMap Map<String,String > Map, @Body JsonObject body);




    @Headers({
            "Content-Type:application/json"
    })
    @GET("confirm/users/{userId}/confirm")
    Call<GetConfirmRespon> getListConfirm(@Path ("userId") Long id, @HeaderMap Map<String,String > Map);


    //edit delete

    @Headers({
            "Content-Type:application/json"
    })
    @PUT("item/users/{userId}/items/{itemId}")
    Call<MitraEditItemRespon> editItem(@Path ("userId") Long id, @Path ("itemId") Long idEditItem, @HeaderMap Map<String,String > Map, @Body JsonObject body);

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
    @DELETE("item/users/{userId}/items/{itemId}")
    Call<String> deleteItem(@Path ("userId") Long id,@Path ("itemId") Long idItem, @HeaderMap Map<String,String > Map);


    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("")
    Call<String> deleteOrderForMe(@Path ("id") Long id, @Path ("id") Long idOrder,@HeaderMap Map<String,String > Map);

    @Headers({
            "Content-Type:application/json"
    })
    @DELETE("")
    Call<String> deleteConfirm(@Path ("id") Long id, @Path ("id") Long idConfirm, @HeaderMap Map<String,String > Map);

    @DELETE("")
    Call<String> deleteConfirmForCustomer(@Path ("id") Long id, @Path ("id") Long idConfirm, @HeaderMap Map<String,String > Map);






}
