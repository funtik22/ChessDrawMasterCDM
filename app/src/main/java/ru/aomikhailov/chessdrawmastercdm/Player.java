package ru.aomikhailov.chessdrawmastercdm;

import java.io.Serializable;

public class Player implements Serializable {

    private String name;
    private String surname;
    private String patronymic;
    private Integer YearOfBirth;
    private Integer rating;
    private Double points;

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

    public Double getPoints() {
        return points;
    }

    public String getSurname() {
        return surname;
    }

    public Integer getYearOfBirth() {
        return YearOfBirth;
    }

    //This method adds one point to the player, that is, it is used if the player wins.
    public void win(){
        this.points=this.points+1.;
    }

    //This method adds half a point to the player, that is, it is used in case of no result.
    public void draw() {
        this.points=this.points+0.5;
    }
}
