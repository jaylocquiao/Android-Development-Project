package com.example.ce_jaylocquiao.prototype.Model;

/**
 * Created by Ce-Jay Locquiao on 2/22/2018.
 */

public class LaptopSvcCacheImpl implements ILaptopSvc{

    public String [] getLaptopName() {
        final String names [] = {"Razer Blade", "Macbook Pro", "Macbook Air"};
        return names;
    }

    public Laptop[] getLaptop() {
        Laptop[] laptops = new Laptop[2];
        Laptop laptop1 = new Laptop(); //Calling the default constructor
        laptop1.setLaptopName("Razer Blade 2014");
        laptop1.setLaptopColor("Black");
        laptops[0] = laptop1;

        Laptop laptop2 = new Laptop();
        laptop2.setLaptopName("Macbook Pro");
        laptop2.setLaptopColor("Silver");
        laptops[1] = laptop2;
        return laptops;
    }



}
