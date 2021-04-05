
package com.futrashproject.futrashmitra.model.pojo_regis;

//import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//@Generated("jsonschema2pojo")
public class FoodTrashRegisMitraRespon {

    @SerializedName("message")
    @Expose
    private String message;

    /**
     * No args constructor for use in serialization
     * 
     */
    public FoodTrashRegisMitraRespon() {
    }

    /**
     * 
     * @param message
     */
    public FoodTrashRegisMitraRespon(String message) {
        super();
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
