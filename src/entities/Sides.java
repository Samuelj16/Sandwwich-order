package entities;

public class Sides {
    private String sides;


    public Sides() {
    }

    public Sides(String sides) {
        this.sides = sides;
    }

    public String getSides() {
        return sides;
    }

    public void setSides(String sides) {
        this.sides = sides;
    }

    @Override
    public String toString() {
        return "Sides{" +
                "sides='" + sides + '\'' +
                '}';
    }
}
