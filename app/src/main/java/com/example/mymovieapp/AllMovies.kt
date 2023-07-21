package com.example.mymovieapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mymovieapp.data.Movies
import com.example.mymovieapp.data.allMovies
import com.example.mymovieapp.data.topRatedMovies
import com.example.mymovieapp.data.upcomingMovies
import okhttp3.OkHttpClient
import okhttp3.Request


/*val client = OkHttpClient()

val request = Request.Builder()
    .url("https://api.themoviedb.org/3/discover/movie")
    .get()
    .addHeader("accept", "application/json")
    .addHeader("Authorization", "Bearer cf1b61da26dea2aedcbc774537ad5501")
    .build()

val response = client.newCall(request).execute()*/

@Composable
fun AllMovies(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = {Text(text="Movie App")},
                navigationIcon = {
                    IconButton(onClick = { }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_search),
                            contentDescription = "Search"
                        )
                    }
                }
            )
        },
        content = { padding ->
            MovieList(Modifier.padding(padding), navController)
        }
    )
}


@Composable
fun MovieList(modifier: Modifier, navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .then(modifier)
    ) {
        item {
            Text(
                text = "\uD83C\uDFAC  Films",
                style = MaterialTheme.typography.h3.copy(
                    color = Color(0xFFD5A79B),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Cursive
                ),
                modifier = Modifier.padding(bottom = 32.dp),
                textAlign = TextAlign.Center
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp)) // Add spacing after the title
            MovieCategory("Now playing", allMovies, navController)
            Spacer(modifier = Modifier.height(32.dp)) // Add more spacing between categories
            MovieCategory("Top Rated", topRatedMovies, navController)
            Spacer(modifier = Modifier.height(32.dp))
            MovieCategory("Upcoming", upcomingMovies, navController)
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun MovieCategory(title: String, movies: List<Movies>, navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h4.copy(
                color = Color(0xFFD5A79B),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Cursive
            ),
            textAlign = TextAlign.Center
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(movies) { movie ->
                MoviePoster(movie.title, movie.imageRes, movie, navController)
            }
        }
    }
}

@Composable
fun MoviePoster(title: String, imageRes: Int, movie: Movies, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable { navController.navigate("movieDetail/${movie.id}") }
            .clip(MaterialTheme.shapes.medium)
            .background(Color.White)
            .padding(8.dp)
            .width(150.dp) // Set a fixed width for movie posters
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = title,
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            title,
            style = MaterialTheme.typography.body1.copy(
                color = Color(0xFFD5A79B),
                fontWeight = FontWeight.Bold,
                fontFamily = FontFamily.Serif
            )
        )
    }
}

@Composable
@Preview
fun AllMoviesPreview() {
//    AllMovies()
}