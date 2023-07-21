package com.example.mymovieapp
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
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
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mymovieapp.data.*

@Composable
fun AllMovies() {
        Scaffold(
            content = { padding ->
                MovieList(modifier = Modifier.padding(padding))
            }
        )
    }


@Composable
fun MovieList(modifier: Modifier) {
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
            MovieCategory("Tous les films", allMovies)
            Spacer(modifier = Modifier.height(32.dp)) // Add more spacing between categories
            MovieCategory("Top Rated", topRatedMovies)
            Spacer(modifier = Modifier.height(32.dp))
            MovieCategory("Upcoming", upcomingMovies)
            Spacer(modifier = Modifier.height(32.dp))
            MovieCategory("Now Playing", nowPlayingMovies)
        }
    }
}

@Composable
fun MovieCategory(title: String, movies: List<Movies>) {
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
                MoviePoster(movie.title, movie.imageRes, navController = navController)
            }
        }
    }
}

@Composable
fun MoviePoster(title: String, imageRes: Int, movie: Movies, navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable{navController.navigate("movieDetail/${movie.id}")}
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
    AllMovies()
}
