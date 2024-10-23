package com.example.readerapp.navagation


import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.readerapp.screens.details.BookDetailsScreen
import com.example.readerapp.screens.home.ReaderHomeScreen
import com.example.readerapp.screens.login.LoginScreen
import com.example.readerapp.screens.search.SearchScreen
import com.example.readerapp.screens.splash.ReaderSplashScreen
import com.example.readerapp.screens.upddate.BookUpdateScreen

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ReaderNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = ReaderScreens.SplashScreen.name
    ) {
        composable(ReaderScreens.SplashScreen.name) {
            ReaderSplashScreen(navController = navController)
        }
        composable(ReaderScreens.ReaderHomeScreen.name) {
            ReaderHomeScreen(navController = navController)
        }
        composable(ReaderScreens.LoginScreen.name) {
            LoginScreen(navController = navController)
        }

        composable(ReaderScreens.SearchScreen.name) {
            SearchScreen(navController = navController)
        }
 composable(ReaderScreens.DetailScreen.name) {
     BookDetailsScreen(navController = navController)
        }
 composable(ReaderScreens.UpdateScreen.name) {
     BookUpdateScreen(navController = navController)
        }


    }
}