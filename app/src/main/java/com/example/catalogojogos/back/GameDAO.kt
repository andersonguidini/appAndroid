package com.example.catalogojogos.back

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface GameDAO {

    @Insert
    fun insert(game: Game)

    @Update
    fun update(game: Game)

    @Delete
    fun delete(game: Game)

    @Query("SELECT * FROM game_tb ORDER BY ano")
    fun getAll():LiveData<List<Game>>

    @Query("SELECT * FROM game_tb where id = :id_")
    fun getById(id_: Int): LiveData<Game>

    @Query("DELETE FROM game_tb")
    fun deleteAll()
}
