package com.futrashproject.futrashmitra.shared_preference;

import android.content.Context;
import android.content.SharedPreferences;

public class SpHandle {

    public static final String SP_FOOD_TRASH_MERCHANT_APP = "FtMerchant";

    public static final String SP_ID_USER = "spIdUser";
    public static final String SP_TOKEN_USER = "spTokenUser";
    public static final String SP_ID_CHART="spIdChart";
    public static final String SP_ID_ORDER="spIdOrder";
    public static final String SP_ID_CONFIRM_ORDER="spIdConfirmOrder";

    public  static final  String SP_NAMA_MITRA="spNamaMitra";
    public static  final  String SP_EMAIL_MITRA="spEmailMitra";
    public static final String SP_PHONE_MITRA="spPhoneMitra";
    public static final String SP_ROLE_MITRA="spRoleMitra";

    public static final String SP_HAVE_LOGIN = "spHaveLogin";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SpHandle(Context context){
        sp = context.getSharedPreferences(SP_FOOD_TRASH_MERCHANT_APP, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    public void setSpTokenUser(String keySP, String value){
        spEditor.putString(keySP, value);
        spEditor.commit();
    }

    public void setSpIdUser(String keySP, Long value){
        spEditor.putLong(keySP, value);
        spEditor.commit();
    }

    public void setSpIdChart(String keySP, Long value){
        spEditor.putLong(keySP,value);
        spEditor.commit();
    }

    public void setSpIdOrder(String keySP, Long value){
        spEditor.putLong(keySP,value);
        spEditor.commit();
    }

    public void setSpIdConfirm(String keySP, Long value){
        spEditor.putLong(keySP,value);
        spEditor.commit();
    }

    public void setSpNamaMitra(String keySp, String value){
        spEditor.putString(keySp,value);
        spEditor.commit();
    }

    public void setSpEmailMitra(String keySP, String value){
        spEditor.putString(keySP,value);
        spEditor.commit();
    }

    public void setSpPhoneMitra(String keySP, String value){
        spEditor.putString(keySP,value);
        spEditor.commit();
    }

    public  void setSpRoleMitra(String keySP, String value){
        spEditor.putString(keySP,value);
        spEditor.commit();
    }

    public void saveSPBoolean(String keySP, boolean value){
        spEditor.putBoolean(keySP, value);
        spEditor.commit();
    }

    public String getSpTokenUser(){
        return sp.getString(SP_TOKEN_USER, "");
    }

    public Long getSpIdUser(){
        return sp.getLong(SP_ID_USER, 0);
    }

    public Long getSpIdChart(){
        return sp.getLong(SP_ID_CHART,0);
    }

    public Long getSpIdOrder(){
        return  sp.getLong(SP_ID_ORDER,0);
    }

    public Long getSpIdConfirm(){
        return  sp.getLong(SP_ID_CONFIRM_ORDER,0);
    }

    public String getSpNamaMitra(){
        return  sp.getString(SP_NAMA_MITRA,"");

    }

    public String getSpEmailMitra(){
        return  sp.getString(SP_EMAIL_MITRA,"");
    }

    public String getSpPhoneMitra(){
        return  sp.getString(SP_PHONE_MITRA,"");
    }

    public String getSpRoleMitra(){
        return  sp.getString(SP_ROLE_MITRA,"");

    }

    public Boolean getHaveLogin(){
        return sp.getBoolean(SP_HAVE_LOGIN, false);
    }
}
