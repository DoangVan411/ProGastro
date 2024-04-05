package model;

import Model.Dish;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Table implements Serializable {
    
    public Map<Dish, Integer> map = new HashMap<Dish, Integer>();
    private int bill;
    private static String choiceString = "Add";

    public static String getChoiceString() {
        return choiceString;
    }

    public static void setChoiceString(String choiceString) {
        Table.choiceString = choiceString;
    }
    
    
    public int getBill(){
        return bill;
    }

    public void setBill(int bill) {
        this.bill = bill;
    }
    
}
