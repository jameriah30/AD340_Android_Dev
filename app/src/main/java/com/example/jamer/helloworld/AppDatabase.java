package com.example.jamer.helloworld;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.jamer.helloworld.dao.SettingsDao;
import com.example.jamer.helloworld.entity.Settings;

@Database(entities = {Settings.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract SettingsDao settingsDao();
}