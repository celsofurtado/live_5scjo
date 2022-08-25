package br.com.fiap.gameslistprof.model

class Game {

    var id = 0
    var title = ""
    var studio = ""
    var description = ""
    var releaseYear = 0
    var isFinished = false

    override fun toString(): String {
        return "Game(id=$id, title='$title', studio='$studio', description='$description', releaseYear=$releaseYear, isFinished=$isFinished)"
    }

}