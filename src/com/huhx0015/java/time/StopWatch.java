package com.huhx0015.java.time;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Michael Yoon Huh on 4/30/2017.
 */
public class StopWatch {

    private boolean isRunning = false;
    private boolean isPaused = false;
    private boolean isTerminating = false;

    private long startTime;
    private long pauseTime;

    private static final int TO_SECONDS = 1000;
    private static final String INSTRUCTIONS = "Please press '1' to start, '2' to pause, '3' to resume, '4' to getTime, '5' to stop, any other value to quit.";

    public static void main(String[] args) {

        System.out.println("Preparing stopwatch...");

        // STOPWATCH INITIALIZATION:
        StopWatch stopWatch = new StopWatch();

        System.out.println(INSTRUCTIONS);

        while (!stopWatch.isTerminating) {
            promptKey(stopWatch);
        }
    }

    private static void promptKey(StopWatch stopWatch) {

        Scanner input = new Scanner(System.in);

        try {
            int key = input.nextInt(); // Scans the next token of the input as an int.
            stopTimerAction(key, stopWatch);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input.\n" + INSTRUCTIONS);
        }
    }

    private static void stopTimerAction(int key, StopWatch stopWatch) {

        switch (key) {
            case 1:
                stopWatch.start();
                break;
            case 2:
                stopWatch.pause();
                break;
            case 3:
                stopWatch.resume();
                break;
            case 4:
                stopWatch.getTime();
                break;
            case 5:
                stopWatch.stop();
                break;
            default:
                stopWatch.isTerminating = true;
                break;
        }

    }

    private static void promptEnterKey() {
        try {
            int read = System.in.read(new byte[2]); // Waits for the user's input until moving on.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        if (!isRunning && !isPaused) {
            startTime = System.currentTimeMillis();
            isRunning = true;

            System.out.println("Starting stopwatch...");
        }
    }

    private void stop() {
        if (isRunning) {
            long elapsedTime = (System.currentTimeMillis() - startTime) / TO_SECONDS;
            System.out.println("Time in seconds elapsed: " + elapsedTime + " seconds.");

            isRunning = false;
            startTime = -1;
        }
    }

    private void pause() {
        if (isRunning && !isPaused) {
            pauseTime = System.currentTimeMillis();
            long elapsedTime = (pauseTime - startTime) / TO_SECONDS;

            System.out.println("Stopwatch paused at: " + elapsedTime + " seconds.");
            isPaused = true;
            isRunning = false;
        }
    }

    private void resume() {
        if (!isRunning && isPaused) {
            long resumeTime = System.currentTimeMillis();
            long elapsedTime = (System.currentTimeMillis() - startTime) / TO_SECONDS;
            long previousTime = (pauseTime - startTime) / TO_SECONDS;
            startTime = resumeTime - (pauseTime - startTime);

            System.out.println("Stopwatch was paused for: " + elapsedTime + " seconds.");
            System.out.println("Stopwatch resumed at: " + previousTime + " seconds.");

            isRunning = true;
            isPaused = false;
            pauseTime = -1;
        }
    }

    private void getTime() {
        if (isRunning) {
            long currentTime = (System.currentTimeMillis() - startTime) / TO_SECONDS;

            System.out.println("Stopwatch current time: " + currentTime);
        }
    }
}
