package com.example.mymovieapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.mymovieapp.data.Movies

@Composable
fun MovieDetail(movie: Movies, navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = Color.White,
                title = { Text(text = movie.title) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_back),
                            contentDescription = "Back"
                        )
                    }
                }
            )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = movie.imageRes),
                    contentDescription = movie.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(MaterialTheme.shapes.medium)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = movie.title,
                    style = MaterialTheme.typography.h5
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Description: ${movie.description}",
                    style = MaterialTheme.typography.body1,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Note: ${movie.rating}",
                    style = MaterialTheme.typography.body1,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.height(16.dp))
                Icon(
                    painter = painterResource(
                        id = if (movie.estFavorit) R.drawable.ic_coeur else R.drawable.ic_coeur2
                    ),
                    contentDescription = "Favori",
                    modifier = Modifier
                        .size(32.dp)
                        .clickable {
                            movie.estFavorit = !movie.estFavorit
                        }
                )
            }
        }
    )
}
