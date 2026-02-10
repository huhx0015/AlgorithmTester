package main.com.huhx0015.algorithmtester.kotlin.time

import java.io.IOException
import java.util.InputMismatchException
import java.util.Scanner

/**
 * Created by Michael Yoon Huh on 4/30/2017.
 */
class StopWatch {

    private var isRunning = false
    private var isPaused = false
    private var isTerminating = false

    private var startTime: Long = 0
    private var pauseTime: Long = 0

    private fun start() {
        if (!isRunning && !isPaused) {
            startTime = System.currentTimeMillis()
            isRunning = true

            println("Starting stopwatch...")
        }
    }

    private fun stop() {
        if (isRunning) {
            val elapsedTime = (System.currentTimeMillis() - startTime) / TO_SECONDS
            println("Time in seconds elapsed: $elapsedTime seconds.")

            isRunning = false
            startTime = -1
        }
    }

    private fun pause() {
        if (isRunning && !isPaused) {
            pauseTime = System.currentTimeMillis()

            val elapsedTime = (pauseTime - startTime) / TO_SECONDS

            println("Stopwatch paused at: $elapsedTime seconds.")
            isPaused = true
            isRunning = false
        }
    }

    private fun resume() {
        if (!isRunning && isPaused) {
            val resumeTime = System.currentTimeMillis()
            val elapsedTime = (System.currentTimeMillis() - startTime) / TO_SECONDS
            val previousTime = (pauseTime - startTime) / TO_SECONDS

            startTime = resumeTime - (pauseTime - startTime)

            println("Stopwatch was paused for: $elapsedTime seconds.")
            println("Stopwatch resumed at: $previousTime seconds.")

            isRunning = true
            isPaused = false
            pauseTime = -1
        }
    }

    private fun getTime() {
        if (isRunning) {
            val currentTime = (System.currentTimeMillis() - startTime) / TO_SECONDS

            println("Stopwatch current time: " + currentTime)
        }
    }

    companion object {

        private val TO_SECONDS = 1000
        private val INSTRUCTIONS = "Please press '1' to start, '2' to pause, '3' to resume, '4' to getTime, '5' to stop, any other value to quit."

        @JvmStatic fun main(args: Array<String>) {

            println("Preparing stopwatch...")

            // STOPWATCH INITIALIZATION:
            val stopWatch = StopWatch()

            println(INSTRUCTIONS)

            while (!stopWatch.isTerminating) {
                promptKey(stopWatch)
            }
        }

        private fun promptKey(stopWatch: StopWatch) {

            val input = Scanner(System.`in`)

            try {
                val key = input.nextInt() // Scans the next token of the input as an int.
                stopTimerAction(key, stopWatch)
            } catch (e: InputMismatchException) {
                println("Invalid input.\n" + INSTRUCTIONS)
            }

        }

        private fun stopTimerAction(key: Int, stopWatch: StopWatch) {
            when (key) {
                1 -> stopWatch.start()
                2 -> stopWatch.pause()
                3 -> stopWatch.resume()
                4 -> stopWatch.getTime()
                5 -> stopWatch.stop()
                else -> stopWatch.isTerminating = true
            }
        }

        private fun promptEnterKey() {
            try {
                val read = System.`in`.read(ByteArray(2)) // Waits for the user's input until moving on.
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }
}
