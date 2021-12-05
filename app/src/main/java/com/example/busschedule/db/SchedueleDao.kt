package com.example.busschedule.db

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface SchedueleDao {

    @Query("SELECT * FROM schedule ORDER BY arrival_time ASC")
    fun getAllList () : Flow<List<Schedule>>

    @Query("SELECT * FROM schedule WHERE stop_name = :stopName ORDER BY arrival_time ASC")
    fun getStopName (stopName : String) :Flow<List<Schedule>>


}