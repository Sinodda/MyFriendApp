package com.example.myfriendapp

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context


@Database(entities = [MyFriend::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun myFriendDao():MyFriendDao

    companion object{
        var INSTANCE:AppDataBase? = null

        fun getAppDataBase(context: Context): AppDataBase? {
            if(INSTANCE == null){
                synchronized(AppDataBase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    AppDataBase::class.java, "MyFriendAppDB").build()
                  }
                }
            return INSTANCE
            }
        fun destroyDataBase(){
            INSTANCE = null
           }
        }
    }
