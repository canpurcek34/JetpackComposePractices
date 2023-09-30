package com.canpurcek.jetpackcomposepractices.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.canpurcek.jetpackcomposepractices.room.dao.PersonDao
import com.canpurcek.jetpackcomposepractices.room.entity.PersonEntitiy


@Database(entities = [PersonEntitiy::class], version = 1)
abstract class DataBase: RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object{
        var INSTANCE: DataBase?=null

        fun databaseAccess(context: Context): DataBase?{
            if (INSTANCE == null){
                synchronized(DataBase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        DataBase::class.java,
                        "person.db")
                        .createFromAsset("person.db")
                        .build()
                }
            }
            return INSTANCE

        }
    }
}