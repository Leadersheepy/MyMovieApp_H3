package com.example.mymovieapp

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController




@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController) },
       // topBar = { TopAppBar(backgroundColor = Color.White, title = { Text(stringResource(R.string.app_name)) }) }
    ){ BottomNavGraph(navController = navController) }
}




@Composable
fun BottomBar(navController: NavController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Library,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Surface(
        color = Color(0xFF9f7975)
    ) {
        BottomNavigation {
            screens.forEach { screen ->
                AddItem(
                    screen = screen,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavController
){
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(
                imageVector = screen.icon,
                contentDescription = "Navigation Icon"
            )
        },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}



/*
@Composable
fun AllMovies() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar= { BottomBar(navController = navController)},
        topBar={ TopAppBar(backgroundColor = Color.White, title = { Text(stringResource(R.string.app_name)) }) },
        content = { padding ->
            BottomNavGraph(navController = navController)


        }
    )

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Text(
                    "\uD83C\uDFAC  Films",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            item {
                MovieCategory("Tous les films", allMovies)
            }

            item {
                MovieCategory("Top Rated", topRatedMovies)
            }

            item {
                MovieCategory("Upcoming", upcomingMovies)
            }

            item {
                MovieCategory("Now Playing", nowPlayingMovies)
            }
        }
    }
*/


/*@Composable
fun AllMovies() {
    val navController = rememberNavController()
    Scaffold(
        topBar={
            TopAppBar(
                backgroundColor = Color.White,
                title = { Text(stringResource(R.string.app_name)) }
            )
        },
        bottomBar= { BottomBar(navController = navController)}

    ) {

        BottomNavGraph(navController = navController)

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            item {
                Text(
                    "\uD83C\uDFAC  Films",
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
            }

            item {
                MovieCategory("Tous les films", allMovies)
            }

            item {
                MovieCategory("Top Rated", topRatedMovies)
            }

            item {
                MovieCategory("Upcoming", upcomingMovies)
            }

            item {
                MovieCategory("Now Playing", nowPlayingMovies)
            }
        }
    }
}*/

/*

@Composable
fun AllMovies(platList: List<Movies>) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(stringResource(R.string.app_name)) }
            )
        }
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Text(
                "\uD83C\uDF3F  Films",
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(end = 16.dp)
            ) {
                items(platList) { movie ->
                    MoviePoster(movie.title, movie.imageRes)
                    Spacer(modifier = Modifier.width(16.dp)) // Ajoute un espace entre les affiches de films
                }
            }
        }
    }
}

@Composable
fun MoviePoster(title: String, imageRes: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = title,
            modifier = Modifier
                .size(120.dp)
                .padding(8.dp)
        )
        Text(title, style = MaterialTheme.typography.body1)
    }
}
*/


/*
package com.example.mymovieapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mymovieapp.data.Movies
import androidx.compose.ui.Modifier

@Composable
fun AllMovies(platList: List<Movies>) {
    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                title = { Text(stringResource(R.string.app_name)) }
            )
        }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
            item {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(vertical = 25.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        "\uD83C\uDF3F  Films",
                        style = MaterialTheme.typography.h3
                    )
                }
            }
            items(platList) { movie ->
                MovieCard(movie.title, movie.description, movie.imageRes)
            }
        }
    }
}*/

