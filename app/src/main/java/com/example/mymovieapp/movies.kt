package com.example.mymovieapp.data

import com.example.mymovieapp.R


val movies = listOf(

    Movies(
        1,
        "Miraculous",
        R.drawable.movie1,
        "Un jeune hobbit, Frodon Sacquet, hérite d'un anneau magique. Il doit entreprendre un périlleux voyage pour le détruire et sauver la Terre du Milieu.",
        4.8f,
        true,
    false,
        true,
        true
    ),
    Movies(
        2,
        "Inception",
        R.drawable.movie2,
       "Un voleur expérimenté entre dans les rêves de ses victimes pour leur voler des secrets précieux. Il se voit offrir une mission spéciale qui pourrait changer sa vie.",
       4.7f,
       false,
        false,
        false,
        false
    ),
    Movies(
        3,
       "Interstellar",
        R.drawable.movie3,
        "Dans un futur proche où la Terre est devenue inhabitable, un groupe d'explorateurs entreprend un voyage interstellaire à la recherche d'une nouvelle planète habitable.",
        4.9f,
        true,
        false,
        true,
        false,
    ),
    Movies(
        4,
       "Le Parrain",
       R.drawable.movie4,
        "L'histoire d'une famille de mafieux italo-américains et de la montée en puissance du fils du patriarche pour devenir le nouveau parrain.",
        4.8f,
    false,
        false,
        true,
        true
    ),
    Movies(
       5,
    "Forrest Gump",
        R.drawable.movie5,
        "L'histoire de Forrest Gump, un homme simple d'esprit qui se retrouve impliqué dans des moments clés de l'histoire américaine du XXe siècle.",
         4.6f,
         true,
        false,
        false,
        false
    ),
    Movies(
        6,
         "Avengers: Endgame",
        R.drawable.movie6,
        "Les Avengers s'unissent pour affronter leur plus grand ennemi et tenter de rétablir l'équilibre après les événements dévastateurs d'Infinity War.",
        4.7f,
        false,
        false,
        false,
        true

    )
)

val favoritMovies = movies.filter {it.estFavorit}
val topRatedMovies = movies.filter { it.rating >= 4.8f }
val upcomingMovies = movies.filter { it.aLaffiche }
val nowPlayingMovies = movies.filter { it.estPopulaire }
val allMovies = movies