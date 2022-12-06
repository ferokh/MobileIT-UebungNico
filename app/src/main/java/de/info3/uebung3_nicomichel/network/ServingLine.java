package de.info3.uebung3_nicomichel.network;

import com.google.gson.annotations.SerializedName;

public class ServingLine {

    @SerializedName("number")
    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @SerializedName("direction")
    private String direction;

    public String getDirection() {return direction;}

    public void setDirection(String direction) {this.direction = direction;}

}
