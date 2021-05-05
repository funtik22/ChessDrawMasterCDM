package ru.aomikhailov.chessdrawmastercdm;

public class Tournament {

    private Integer tour;

    public Tournament(Integer tour){
        this.tour=tour;
    }

    public Integer getTour() {
        return tour;
    }

    public void setTour(Integer tour) {
        this.tour = tour;
    }
}
