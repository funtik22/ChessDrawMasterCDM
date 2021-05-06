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
    private Double points;
    private String male;

    public Player(String name, String surname, String patronymic, Integer YearOfBirth,
                  Integer rating, Double points) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.YearOfBirth = YearOfBirth;
        this.rating = rating;
        this.points = points;


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

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getYearOfBirth() {
        return YearOfBirth;
    }

    public void win(){
        this.points=this.points+1.;
    }

    public void draw() {
        this.points=this.points+0.5;
    }
}
