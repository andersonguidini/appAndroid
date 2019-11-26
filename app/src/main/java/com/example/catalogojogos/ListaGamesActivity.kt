package com.example.catalogojogos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catalogojogos.back.Game
import kotlinx.android.synthetic.main.activity_lista_games.*

class ListaGamesActivity : AppCompatActivity() {

    val REQUEST_CODE = 12

    private lateinit var gameViewModel: GameViewModel

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_games)

        recyclerView = recycler_games
        montaLista(recyclerView)

        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        fbNew.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)

            startActivityForResult(intent, REQUEST_CODE)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK){
            data?.let { resultado ->
                val game: Game = resultado.extras?.get(MainActivity.EXTRA_REPLY) as Game
                game.let {
                    gameViewModel.insert((game))
                    Toast.makeText(
                        this,
                        R.string.save_success_message,
                        Toast.LENGTH_LONG
                    ).show()
                }
            }
        }
    }

    private fun montaLista(recyclerView: RecyclerView){
        val adapter = ListaGameAdapter(this)

        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        gameViewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        gameViewModel.games.observe(this,
            Observer { gameLista ->
                gameLista?.let { lista ->
                    adapter.setGameLista(lista)
                }
            })
    }

    override fun onRestart() {
        super.onRestart()

        montaLista(recyclerView)
    }
}
