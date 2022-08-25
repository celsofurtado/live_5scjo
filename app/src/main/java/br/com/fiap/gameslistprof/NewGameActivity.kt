package br.com.fiap.gameslistprof

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import br.com.fiap.gameslistprof.api.GameCall
import br.com.fiap.gameslistprof.api.RetrofitApi
import br.com.fiap.gameslistprof.databinding.ActivityNewGameBinding
import br.com.fiap.gameslistprof.model.Game
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewGameActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_new_game)

        binding = ActivityNewGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonSaveNewGame.setOnClickListener {
            saveGame()
        }

    }

    private fun saveGame() {
        val game = Game()

        game.apply {
            title = binding.editGameName.text.toString()
            description = binding.editGameDescription.text.toString()
            studio = binding.editGameStudio.text.toString()
            releaseYear = binding.editGameReleaseYear.text.toString().toInt()
            isFinished = true
        }

        val retrofit = RetrofitApi.getRetrofitApi()
        val gameCall = retrofit.create(GameCall::class.java)

        val call = gameCall.saveGame(game)

        call.enqueue(object : Callback<Game> {
            override fun onResponse(call: Call<Game>, response: Response<Game>) {
                Log.i("xpto", response.body()!!.toString())
            }

            override fun onFailure(call: Call<Game>, t: Throwable) {
                Log.i("xpto", t.message.toString())
            }

        })

    }
}