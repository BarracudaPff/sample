package ru.otus.otuskotlin.exercise7

import java.util.*
import kotlin.math.abs

const val N = 8

fun main() {
    val scanner = Scanner(System.`in`)

    val results = mutableListOf<Int>()
    val n = scanner.nextInt()

    scanner.nextLine() // required to correctly scan next line
    for (i in 0 until n) {
        // scal whole line and split by spaces
        val line = scanner.nextLine().split(" ")
            .filter { it.isNotBlank() }
        val result = solve(*line.toTypedArray())
        results.add(result)
    }

    // print results
    for (result in results) {
        print("$result ")
    }
}

fun solve(vararg moves: String): Int {
    val board = Array(N) { CharArray(N) }
    initBoard(board)

    var playerBig = true
    for (i in moves.indices) {
        val move = moves[i]
//        println("=".repeat(60))
//        println("Move: $move")

        // Parse "from" and "to" moves
        // j - index of row
        // i - index of column
        val j1 = move[0].code - 'a'.code
        val i1 = move[1].code - '1'.code

        val j2 = move[2].code - 'a'.code
        val i2 = move[3].code - '1'.code

        val from = board[i1][j1]
        val to = board[i2][j2]

        // if current move is pawn - we need to check if it's correct
        if (from == 'p' || from == 'P') {
            val check = checkPawnMove(board, j1, i1, j2, i2, playerBig)
            if (!check) {
                return i + 1
            }
        }

        // swap player's move
        playerBig = !playerBig

        // make a move
        board[i2][j2] = from
        board[i1][j1] = '-'

//        printBoard(board)
    }
    return 0
}

/**
 * Check if pawn move is correct
 */
fun checkPawnMove(board: Array<CharArray>, j1: Int, i1: Int, j2: Int, i2: Int, playerBig: Boolean): Boolean {
    val from = board[i1][j1]

    return when {
        playerBig && from.code >= 'a'.code && from.code <= 'z'.code -> false // Big player must move with big letters
        !playerBig && from.code <= 'Z'.code && from.code >= 'A'.code -> false // Small player must move with small letters
        playerBig -> checkMoveBig(board, j1, i1, j2, i2) // Check big player's move
        else -> checkMoveSmall(board, j1, i1, j2, i2) // Check small player's move
    }
}


/**
 * Check if big pawn "P" move is correct
 */
fun checkMoveBig(board: Array<CharArray>, j1: Int, i1: Int, j2: Int, i2: Int): Boolean {
    val to = board[i2][j2]

    return when {
        board[i1][j1] == '-' -> false // move only pawn
        i2 <= i1 -> false // move back
        abs(i1 - i2) > 2 -> false // move too far
        abs(i1 - i2) == 2 -> j1 == j2 && i1 == 1 && board[2][j1] == '-' // move 2 blocks only forward, when in init position, and no figures between
        abs(i1 - i2) == 1 -> when (j1) { // moving 1 block forward
            j2 -> to.code == '-'.code // move forward
            else -> to.code <= 'z'.code && to.code >= 'a'.code // move diagonal
        }

        else -> true
    }
}

/**
 * Check if small pawn "p" move is correct
 */
fun checkMoveSmall(board: Array<CharArray>, j1: Int, i1: Int, j2: Int, i2: Int): Boolean {
    val to = board[i2][j2]

    return when {
        board[i1][j1] == '-' -> false // move only pawn
        i2 >= i1 -> false // move back
        abs(i1 - i2) > 2 -> false // move too far
        abs(i1 - i2) == 2 -> j1 == j2 && i1 == 6 && board[5][j1] == '-'// move 2 blocks only forward, when in init position, and no figures between
        abs(i1 - i2) == 1 -> when (j1) { // moving 1 block forward
            j2 -> to.code == '-'.code // move forward
            else -> to.code <= 'Z'.code && to.code >= 'A'.code // move diagonal
        }

        else -> true
    }
}

/**
 * Init board with all chess figures
 * @param board matrix to store figures
 */
fun initBoard(board: Array<CharArray>) {
    // Init big letters
    board[0][0] = 'R'
    board[0][1] = 'N'
    board[0][2] = 'B'
    board[0][3] = 'Q'
    board[0][4] = 'K'
    board[0][5] = 'B'
    board[0][6] = 'N'
    board[0][7] = 'R'
    for (i in 0..7) {
        board[1][i] = 'P'
    }

    // Init small letters
    board[7][0] = 'r'
    board[7][1] = 'n'
    board[7][2] = 'b'
    board[7][3] = 'q'
    board[7][4] = 'k'
    board[7][5] = 'b'
    board[7][6] = 'n'
    board[7][7] = 'r'
    for (i in 0..7) {
        board[6][i] = 'p'
    }

    // Init space
    for (i in 2..5) {
        for (j in 0..7) {
            board[i][j] = '-'
        }
    }
}

/**
 * Print current state of board
 */
fun printBoard(board: Array<CharArray>) {
    for (chars in board.reversed()) {
        for (char in chars) {
            print("$char ")
        }
        println()
    }
}
