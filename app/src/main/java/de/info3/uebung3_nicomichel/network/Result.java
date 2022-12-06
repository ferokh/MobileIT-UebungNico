package de.info3.uebung3_nicomichel.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("departureList") //hier den Namen aus der API eingeben. Also departureList oder departure_List
    private List<Departure> departureList;

    public List<Departure> getDepartureList() {
        return this.departureList; //ansonsten this. raus machen
    }

    public void setDepartureList(List<Departure> departureList) {
        this.departureList = departureList;
    }
}
