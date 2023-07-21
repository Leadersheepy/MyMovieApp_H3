package com.example.mymovieapp.data

import com.example.mymovieapp.R


val movies = listOf(

    Movies(
        1,
        "Miraculous",
        R.drawable.movie1,
        "La super-héroïne, qui a conquis le coeur de millions de fans à travers le monde, débarque pour la première fois au cinéma ! Ladybug va devoir unir ses forces avec Chat Noir, le charismatique justicier masqué qui n'a pas sa langue dans sa poche, pour affronter le Papillon et sa horde de super-vilains, alors que ceux-ci menacent de détruire Paris.",
        4.8f,
        true,
        false,
        true,
        true
    ),
    Movies(
        2,
        "Barbie",
        R.drawable.movie2,
        "Barbie, qui vit à Barbie Land, est expulsée du pays pour être loin d'être une poupée à l'apparence parfaite; n'ayant nulle part où aller, elle part pour le monde humain et cherche le vrai bonheur.",
        4.7f,
        false,
        false,
        true,
        false
    ),
    Movies(
        3,
        "Spider-Man : Across the Spider-Verse",
        R.drawable.movie3,
        "Après avoir retrouvé Gwen Stacy, Spider-Man, le sympathique quartier à temps plein de Brooklyn, est catapulté à travers le multivers, où il rencontre une équipe de Spider-People chargée de protéger son existence même",
        4.9f,
        true,
        false,
        false,
        true,
    ),
    Movies(
        4,
        "Star wars, l'empire contre-attaque",
        R.drawable.movie4,
        "Malgré la destruction de l'Étoile noire, l'Empire maintient son emprise sur la galaxie, et poursuit sans relâche sa lutte contre l'Alliance rebelle. Basés sur la planète glacée de Hoth, les rebelles essuient un assaut des troupes impériales.",
        4.8f,
        false,
        false,
        false,
        false
    ),
    Movies(
        5,
        "Black panther",
        R.drawable.movie5,
        "Après les événements qui se sont déroulés dans Captain America : Civil War, T'Challa revient chez lui prendre sa place sur le trône du Wakanda, une nation africaine technologiquement très avancée mais lorsqu'un vieil ennemi resurgit, le courage de T'Challa est mis à rude épreuve, aussi bien en tant que souverain qu'en tant que Black Panther.",
        4.6f,
        false,
        false,
        false,
        true
    ),
    Movies(
        6,
        "Spiderman : No way Home",
        R.drawable.movie6,
        "Avec l'identité de Spiderman désormais révélée, celui-ci est démasqué et n'est plus en mesure de séparer sa vie normale en tant que Peter Parker des enjeux élevés d'être un superhéros. Lorsque Peter demande de l'aide au docteur Strange, les enjeux deviennent encore plus dangereux, l'obligeant à découvrir ce que signifie vraiment être Spiderman.",
        4.7f,
        true,
        false,
        false,
        true

    )
)

val favoritMovies = movies.filter { it.estFavorit }
val topRatedMovies = movies.filter { it.rating >= 4.8f }
val upcomingMovies = movies.filter { it.aLaffiche }
val allMovies = movies

