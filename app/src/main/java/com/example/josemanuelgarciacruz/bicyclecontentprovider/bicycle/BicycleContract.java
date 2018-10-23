package com.example.josemanuelgarciacruz.bicyclecontentprovider.bicycle;

import android.provider.BaseColumns;

import com.example.josemanuelgarciacruz.bicyclecontentprovider.BicycleShopApplication;

public class BicycleContract implements BaseColumns {
    public static String TABLE_NAME = "bicycle";
    public static String CONTENT_URI = "content://" + BicycleShopApplication.AUTORITY + TABLE_NAME;

    public static String MODEL = "model";
    public static String YEAR = "year";


}
