package com.example.busschedule.app

import android.app.Application
import com.example.busschedule.db.ScheduleDataBase

class BaseApplication :Application() {

     val dataBase:ScheduleDataBase by lazy {
          ScheduleDataBase.getDatabase(this)
     }

}