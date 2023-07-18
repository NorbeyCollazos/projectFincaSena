package com.ncrdesarrollo.exampleprojectsena.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun getUsers(): LiveData<List<User>>

    @Insert
    fun registerUser(user: User)
}
