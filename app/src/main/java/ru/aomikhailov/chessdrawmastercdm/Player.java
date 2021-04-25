package ru.aomikhailov.chessdrawmastercdm;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private String surname;
    private String patronymic;
    private Integer YearOfBirth;
    private Integer rating;
    private Float points;
    private String male;

    public Player(String name, String surname, String patronymic, Integer YearOfBirth,
                  Integer rating) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.YearOfBirth = YearOfBirth;
        this.rating = rating;


    }

    public String getName() {
        return name;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Float getPoints() {
        return points;
    }

    public void setPoints(Float points) {
        this.points = points;
    }


}
