package ru.aomikhailov.chessdrawmastercdm;

public class Player {

    private String name;
    private String surname;
    private String patronymic;
    private Integer YearOfBirth;
    private Integer rating;
    private Float points;
    private Boolean male;

    public Player(String name, String surname, String patronymic, Integer YearOfBirth,
                  Integer rating, Float points, Boolean male) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.YearOfBirth = YearOfBirth;
        this.rating = rating;
        this.points = points;
        this.male = male;
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
