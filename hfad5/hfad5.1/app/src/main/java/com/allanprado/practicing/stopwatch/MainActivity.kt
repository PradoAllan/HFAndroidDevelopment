package com.allanprado.practicing.stopwatch


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import com.allanprado.practicing.stopwatch.R.*

class MainActivity : AppCompatActivity() {

    lateinit var stopwatch : Chronometer //The stopwatch
    var running = false //Is the stopwatch running?
    var offset: Long = 0 //The base offset for the stopwatch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        //Get a refernce to the stopwatch
        stopwatch = findViewById<Chronometer>(R.id.stopwatch)

        //update the stopwatch.base time, allowing for any offset
        fun setBaseTime() {
            stopwatch.base = SystemClock.elapsedRealtime() - offset
        }

        //Record the offset
        fun saveOffset() {
            offset = SystemClock.elapsedRealtime() - stopwatch.base
        }

        //The start button starts the stopwatch if its not running
        val startButton = findViewById<Button>(R.id.start_button)
        startButton.setOnClickListener {
            if (!running) {
                setBaseTime()
                stopwatch.start()
                running = true
            }
        }

        //The pause button pauses the stopwatch if its running
        val pauseButton = findViewById<Button>(R.id.pause_button)
        pauseButton.setOnClickListener {
            if (running) {
                saveOffset()
                stopwatch.stop()
                running = false
            }
        }

        //The reset button sets the offset and stopwatch to 0
        val resetButton = findViewById<Button>(R.id.reset_button)
        resetButton.setOnClickListener {
            offset = 0
            setBaseTime()
        }
    }
}