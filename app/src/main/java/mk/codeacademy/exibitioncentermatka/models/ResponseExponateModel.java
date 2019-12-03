package mk.codeacademy.exibitioncentermatka.models;

import java.util.ArrayList;

public class ResponseExponateModel {
    int numberOfItems;
    ArrayList<Exponate> eksponati;

    public ResponseExponateModel(){}

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(int numberOfItems) {
        this.numberOfItems = numberOfItems;
    }

    public ArrayList<Exponate> getEksponati() {
        return eksponati;
    }

    public void setEksponati(ArrayList<Exponate> eksponati) {
        this.eksponati = eksponati;
    }
}
