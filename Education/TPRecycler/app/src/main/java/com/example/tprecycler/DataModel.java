package com.example.tprecycler;

public class DataModel {

    private String name;
    private int id_image;
    public DataModel(String name,Integer id_)
    {
        this.name=name;
        this.id_image=id_;
    }
    public String getName() {
        return name;
    }

    public int getId_() {
        return id_image;
    }

}


