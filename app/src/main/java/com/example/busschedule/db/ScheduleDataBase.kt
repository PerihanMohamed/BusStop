package com.example.busschedule.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Schedule::class), version = 1)
abstract class ScheduleDataBase :RoomDatabase() {

    abstract fun scheduleDao() : SchedueleDao

    companion object {

        @Volatile
        private var INSTANCE: ScheduleDataBase? = null

        fun getDatabase(context: Context): ScheduleDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ScheduleDataBase::class.java,
                    "word_database"
                )

                    .createFromAsset("database/bus_schedule.db")
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}