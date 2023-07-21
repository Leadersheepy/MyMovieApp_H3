package com.example.mymovieapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.mymovieapp.data.favoritMovies
import androidx.compose.ui.tooling.preview.Preview
import com.example.mymovieapp.data.Movies

@Composable
fun Library() {
    Scaffold(
        content = { padding ->
            LibraryList(modifier = Modifier.padding(padding))
        }
    )
}

@Composable
fun LibraryList(modifier: Modifier) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .then(modifier) // Merge the padding modifiers
    ) {
        item {
            Text(
                "Mes films préférés \uD83E\uDD70 ",
                style = MaterialTheme.typography.h3.copy(
                    color = Color(0xFFD5A79B),
                    fontWeight = FontWeight.Bold,
                    fontFamily = FontFamily.Cursive
                ),
                modifier = Modifier.padding(bottom = 32.dp),
                textAlign = TextAlign.Center
            )        }
        items(favoritMovies) { movie ->
            LibPoster(movie)
        }
    }
}

@Composable
fun LibPoster(movie: Movies) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // Movie image
        Image(
            painter = painterResource(id = movie.imageRes),
            contentDescription = movie.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .clip(RoundedCornerShape(8.dp))
        )

        Spacer(modifier = Modifier.width(16.dp))

        // Movie details
        Column {
            Text(
                text = movie.title,
                style = MaterialTheme.typography.subtitle1,
                color = MaterialTheme.colors.onSurface
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(top = 4.dp)
            ) {
                // Heart icon for favori status
                Icon(
                    painter = painterResource(id = R.drawable.ic_coeur),
                    contentDescription = "Favori",
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                // Download icon
                Icon(
                    painter = painterResource(id = R.drawable.ic_tel),
                    contentDescription = "Téléchargement",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}
