package com.example.testlistview.model;

/**
 * Created by Promlert on 2017-10-29.
 */

public class Animal {

    public final String englishName;
    public final String thaiName;
    public final int picture;
    public final String details;

    public Animal(String englishName, String thaiName, int picture, String details) {
        this.englishName = englishName;
        this.thaiName = thaiName;
        this.picture = picture;
        this.details = details;
    }
}
