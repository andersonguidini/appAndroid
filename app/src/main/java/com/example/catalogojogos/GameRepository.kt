package com.example.catalogojogos

import androidx.lifecycle.LiveData
import com.example.catalogojogos.back.Game
import com.example.catalogojogos.back.GameDAO

class GameRepository(private val gameDAO: GameDAO) {

    fun insert(game: Game){
        gameDAO.insert(game)
    }

    fun update(game: Game){
        gameDAO.update(game)
    }

    fun delete(game: Game){
        gameDAO.delete(game)
    }

    val games: LiveData<List<Game>> = gameDAO.getAll()
}