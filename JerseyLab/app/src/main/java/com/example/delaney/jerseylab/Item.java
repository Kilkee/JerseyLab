package com.example.delaney.jerseylab;

/**
 * Created by boutell on 11/14/2015.
 */
public class Item {
    private String mName;
    private int mNumber;
    private boolean mColour;

    public Item() {
        mName = "Android";
        mNumber = 17;
        mColour = true;

    }

    public Item(String name, int number, boolean colour ) {
        mName = name;
        mNumber = number;
        mColour = colour;

    }

   // public static Item getDefaultItem() {
   //     return new Item("Earplugs", 5);
   // }

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

    //  public boolean setColour (){ mColour = colour; }
    public boolean getColour(){
        return mColour;
    }


}
