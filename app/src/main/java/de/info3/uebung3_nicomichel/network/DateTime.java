package de.info3.uebung3_nicomichel.network;

import com.google.gson.annotations.SerializedName;

public class DateTime {
    @SerializedName("hour")
    private String hour;

    @SerializedName("minute")
    private String minute;



    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMinute() {
        return minute;
    }

    public void setMinute(String minute) {
        this.minute = minute;
    }

}
