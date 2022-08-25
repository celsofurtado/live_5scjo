package br.com.fiap.gameslistprof.api

import br.com.fiap.gameslistprof.model.Game
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface GameCall {

    @GET("games")
    fun getAllGames(): Call<List<Game>>

    @GET("games/{id}")
    fun getGameById(@Path("id") id: Long): Call<Game>

    @POST("games")
    fun saveGame(@Body game: Game): Call<Game>

}