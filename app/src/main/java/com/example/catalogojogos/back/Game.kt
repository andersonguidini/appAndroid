package com.example.catalogojogos.back

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "game_tb")
class Game(
    var nome: String = "",
    var preco: Double = 0.0,
    var ano: String = "",
    var estudio: String = ""
):Serializable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}