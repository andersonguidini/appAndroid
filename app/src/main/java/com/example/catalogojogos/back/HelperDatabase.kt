package com.example.catalogojogos.back

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Game::class], version = 2)
abstract class HelperDatabase: RoomDatabase() {

    abstract fun gameDao(): GameDAO

    companion object{
        private var INSTANCE: HelperDatabase? = null

        fun getDataBase(context: Context): HelperDatabase{
            return INSTANCE ?: synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    HelperDatabase::class.java,
                    "game_tb"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}