package com.example.catalogojogos

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.catalogojogos.back.Game
import com.example.catalogojogos.back.HelperDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class GameViewModel (application: Application): AndroidViewModel(application) {

    private val repository: GameRepository

    val games: LiveData<List<Game>>

    private val parentJob = Job()

    private val coroutineContext get() =
        parentJob + Dispatchers.Main

    private val scope = CoroutineScope(coroutineContext)

    init{
        val gameDAO = HelperDatabase.getDataBase(application).gameDao()
        repository = GameRepository(gameDAO)

        games = repository.games
    }

    fun insert(game: Game) = scope.launch(Dispatchers.IO) {
        repository.insert(game)
    }


}