package Items;

import Characters.Characters;

public class Offer extends Items {
    public Offer(String titel, String text) {
        super(titel, text);
    }

    public void giveOffer(Characters toWhom, boolean received) {
        if (received) {
            toWhom.item.add(this);
        }
    }

    @Override
    public String toString() {
        return "Item{" +
                "titel = '" + name + '\'' +
                ", text = " + content +
                '}';
    }
}