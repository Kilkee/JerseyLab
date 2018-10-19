package com.example.delaney.jerseylab;

import java.text.DateFormat;
import java.util.GregorianCalendar;

/**
 * Created by boutell on 11/14/2015.
 */
public class Item {
    private String mName;
    private int mNumber;

    public Item() {
        mName = "Nothing";
        mNumber = 0;

    }

    public Item(String name, int number) {
        mName = name;
        mNumber = number;

    }

    public static Item getDefaultItem() {
        return new Item("Limerick", 3);
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public int getNumber() {
        return mNumber;
    }

    public void setNumber(int number) {
        mNumber = number;
    }




}
