package com.sample.kotlinquizchallenge

/*
* Model a Tic Tac Toe game with board state and game status.
*
* // Input
* // X _ _
* // O X _
* // O _ X

* // Expected Output
* gameState.status → GameStatus.X_WINS
* gameState.currentPlayer → null (game ended)
* */

fun main() {
    val game = TicTacToeGame()

    game.placeMove(0,0)
    game.placeMove(1,0)
    game.placeMove(1,1)
    game.placeMove(2,0)
    game.placeMove(2,2)

    game.printBoard()

    println(game.status.name)
    println(game.currentPlayer?.name)
}

class TicTacToeGame {
    private val board: Array<Array<Player?>> = Array(3) { Array(3) { null } }

    var status: GameStatus = GameStatus.X_TURN
        private set

    val currentPlayer: Player?
        get() = when (status) {
            GameStatus.X_TURN -> Player.X
            GameStatus.O_TURN -> Player.O
            else -> null // game is over
        }

    fun placeMove(row: Int, col: Int): Boolean {
        if (currentPlayer == null) {
            println("Game is over")
            return false
        }

        if (row !in 0..2 || col !in 0..2 || board[row][col] != null) {
            println("Move is invalid, either out of bounds or cell is occupied")
            return false
        }

        val player = currentPlayer!!
        board[row][col] = player

        updateGameStatus(player)
        return true
    }

    private fun updateGameStatus(player: Player) {
        // win
        if (checkForWin(player)) {
            status = if (player == Player.X) GameStatus.X_WINS else GameStatus.O_WINS
            return
        }

        // draw
        if (board.all { row -> row.all { cell -> cell != null } }) {
            status = GameStatus.DRAW
            return
        }

        // continue game
        status = if (player == Player.X) GameStatus.O_TURN else GameStatus.X_TURN
    }

    private fun checkForWin(player: Player): Boolean {
        for (i in 0..2) {
            if (board[i].all { it == player }) return true
            if (board.all { it[i] == player }) return true
        }

        // diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true

        return false
    }

    fun printBoard() {
        println("--- Board ---")
        board.forEach { row ->
            println(row.joinToString(" | ") { it?.name ?: " " })
        }
        println("-------------")
    }
}

enum class GameStatus {
    X_WINS,
    O_WINS,
    X_TURN,
    O_TURN,
    DRAW,
}

enum class Player {
    X,
    O;
}