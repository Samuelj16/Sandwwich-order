package entities;

public class Meat extends Toppings{
    private boolean meatExtra;

    public Meat(String topping, double price, int size, boolean meatExtra) {
        super(topping, price, size);
        this.meatExtra = meatExtra;
    }

    public Meat(){

    }

    public boolean getMeatExtra() {
        return meatExtra;
    }

    public void setMeatExtra(boolean meatExtra) {
        this.meatExtra = meatExtra;
    }

    @Override
    public String toString() {
        return "Meat{" +
                "meatExtra=" + meatExtra +
                '}';
    }
}
