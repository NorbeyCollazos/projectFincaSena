package com.ncrdesarrollo.exampleprojectsena.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [User::class],
    version = 1
)
abstract class FincDB : RoomDatabase() {
    abstract fun userDao(): UserDao
}
