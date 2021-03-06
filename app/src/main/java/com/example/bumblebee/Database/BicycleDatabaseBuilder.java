package com.example.bumblebee.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.bumblebee.DAO.PartDAO;
import com.example.bumblebee.DAO.ProductDAO;
import com.example.bumblebee.Entity.Part;
import com.example.bumblebee.Entity.Product;

@Database(entities = {Product.class, Part.class}, version = 1, exportSchema = false)
public abstract class BicycleDatabaseBuilder extends RoomDatabase {
    public abstract ProductDAO productDAO();
    public abstract PartDAO partDAO();

    private static volatile BicycleDatabaseBuilder INSTANCE;

    static BicycleDatabaseBuilder getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (BicycleDatabaseBuilder.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), BicycleDatabaseBuilder.class, "myBicycleDatabase")
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
