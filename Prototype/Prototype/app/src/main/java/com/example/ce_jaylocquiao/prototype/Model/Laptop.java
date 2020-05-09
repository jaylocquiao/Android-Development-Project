package com.example.ce_jaylocquiao.prototype.Model;

import java.io.Serializable;

/**
 * Created by Ce-Jay Locquiao on 2/22/2018.
 */

public class Laptop implements Serializable{
    private String laptopName = "";
    private String laptopColor = "";


    public String getLaptopName() {
        return laptopName;
    }

    public void setLaptopName(String laptopName) {
        this.laptopName = laptopName;
    }

    public String getLaptopColor() {

        return laptopColor;
    }

    public void setLaptopColor(String laptopColor) {
        this.laptopColor = laptopColor;
    }


    @Override
    public String toString() {
        return laptopName;
    }

}
