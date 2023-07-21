package com.example.mymovieapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.example.mymovieapp.data.movies
import com.example.mymovieapp.ui.theme.MyMovieAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyMovieAppTheme() {
                Surface(color = MaterialTheme.colors.background

                ) {
                    MainScreen()
                }
            }
        }
    }
}