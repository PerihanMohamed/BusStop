package com.example.busschedule.viewmodel

import androidx.lifecycle.ViewModel
import com.example.busschedule.db.SchedueleDao
import com.example.busschedule.db.Schedule
import kotlinx.coroutines.flow.Flow

class ScheduleViewModel(val dao :SchedueleDao) : ViewModel() {


    fun getAllLists () : Flow<List<Schedule>> = dao.getAllList()

    fun getStopName (name : String)  :Flow <List<Schedule>> = dao.getStopName(name)

    

}