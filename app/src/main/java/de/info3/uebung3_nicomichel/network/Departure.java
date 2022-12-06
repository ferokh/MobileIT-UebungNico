package de.info3.uebung3_nicomichel.network;

import com.google.gson.annotations.SerializedName;

public class Departure {

    @SerializedName("servingLine")

    private ServingLine servingLine;

    public ServingLine getServingLine() {
        return this.servingLine;
    }

    public void setServingLine(ServingLine servingLine) {
        this.servingLine = servingLine;
    }

    @SerializedName("dateTime")

    private DateTime dateTime;

    public DateTime getDateTime() {
        return this.dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }
}
