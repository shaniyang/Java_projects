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



    public void addMoney() {
        money += 1;
        System.out.println("Klink! Added more money!");
    }
    public boolean buyBottle() {
        if (money > 0) {
            if (bottle_list.size() > 1) {
                removeBottle();
                money -= 1;
                System.out.println("KACHUNK! " + b.getName() +" " + b.getManufacturer() +" " + b.getEnergy() + " came out of the dispenser!");
                return true;
            }
            else if (money == 0 && bottle_list.size() == 0){
                returnMoney();
                return false;
            }
        }
        else {
            System.out.println(("Add money first!"));
            addMoney();
        }
        return true;
    }
    public void returnMoney() {
        money = 0;
        System.out.println("Klink klink. Money came out!");
    }

    public void removeBottle() {
        bottle_list.remove(0);
        }
    }

