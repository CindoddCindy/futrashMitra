
package com.futrashproject.futrashmitra.model.pojo_auth;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class FoodTrashMitraLoginRespon {

    @SerializedName("accessToken")
    @Expose
    private String accessToken;
    @SerializedName("tokenType")
    @Expose
    private String tokenType;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FoodTrashMitraLoginRespon() {
    }

    /**
     * 
     * @param accessToken
     * @param tokenType
     */
    public FoodTrashMitraLoginRespon(String accessToken, String tokenType) {
        super();
        this.accessToken = accessToken;
        this.tokenType = tokenType;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

}
