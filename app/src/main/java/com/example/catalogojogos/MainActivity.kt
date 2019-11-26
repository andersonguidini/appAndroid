package com.example.catalogojogos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.catalogojogos.back.Game
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun save(view: View){
        if(edtNome.text.isNullOrEmpty()){
            Toast.makeText(
                this,
                getString(R.string.empty_nome_message),
                Toast.LENGTH_LONG
            ).show()
        } else if(edtPreco.text.isNullOrEmpty()){
            Toast.makeText(
                this,
                R.string.empty_price_message,
                Toast.LENGTH_LONG
            ).show()
        } else if(edtYear.text.isNullOrEmpty()){
            Toast.makeText(
                this,
                getString(R.string.empty_year_message),
                Toast.LENGTH_LONG
            ).show()
        } else if (edtStudio.text.isNullOrEmpty()){
            Toast.makeText(
                this,
                R.string.empty_studio_message,
                Toast.LENGTH_LONG
            ).show()
        } else {
            game = Game()
            popObj()

            var intent = Intent()

            intent.putExtra(EXTRA_REPLY, game)

            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }

    private fun popObj(){
        game.nome = edtNome.text.toString()
        game.estudio = edtStudio.text.toString()
        game.preco = edtPreco.text.toString().toDouble()
        game.ano = edtYear.text.toString()
    }

    companion object{
        const val EXTRA_REPLY = "com.example.catalogojogos.REPLY"
    }
}
