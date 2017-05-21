package com.example.nowel.android_training_roman_ananich;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Created by Nowel on 01.04.2017.
 */

public class Category {

    private int ID;
    private String name;
    private String descr;

    public Category (int anID, String aName, String aDescr) {
        this.ID = anID;
        this.name = aName;
        this.descr = aDescr;
    }

    public int getID() { return this.ID; }

    public String getName() { return this.name; }

    public String getDescr() { return this.descr; }

}



