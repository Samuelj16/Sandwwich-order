package entities;

public class Sauces {
    private String Sauce;

    public Sauces(){

    }

    public Sauces(String sauce) {
        Sauce = sauce;
    }

    public String getSauce() {
        return Sauce;
    }

    public void setSauce(String sauce) {
        Sauce = sauce;
    }

    @Override
    public String toString() {
        return "Sauces{" +
                "Sauce='" + Sauce + '\'' +
                '}';
    }
}
