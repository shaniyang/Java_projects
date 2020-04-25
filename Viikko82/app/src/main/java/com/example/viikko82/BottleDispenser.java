package com.example.viikko82;
import java.util.ArrayList;

public class BottleDispenser {

    private int bottles;
    private int money;
    Bottle b = new Bottle();
    ArrayList<Bottle> bottle_list = new ArrayList<Bottle>(bottles);
    public BottleDispenser() {
        bottles = 5;
        money = 0;
        for (int i=1; i<=bottles; i++)
            bottle_list.add(new Bottle());
    }



    public String addMoney() {
        money += 1;
        String s = "Klink! Added more money!";
        return s;
    }
    public String buyBottle() {
        String s ="";
        if (money > 0) {
            if (bottle_list.size() > 1) {
                removeBottle();
                money -= 1;
                s = ("KACHUNK! " + b.getName() + " came out of the dispenser!");
                return s;
            }
            /*else if (money == 0 && bottle_list.size() == 0){
                returnMoney();
                return false;
            }*/
        }
        else {
            s = ("Add money first!");
            return s;
        }
        return s;
    }
    public String returnMoney() {
        money = 0;
        String s = ("Klink klink. Money came out!");
        return s;
    }

    public void removeBottle() {
        bottle_list.remove(0);
        }
    }

