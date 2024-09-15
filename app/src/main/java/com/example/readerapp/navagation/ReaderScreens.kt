package com.example.readerapp.navagation

enum class ReaderScreens {
    SplashScreen,
    LoginScreen,
    CreateAccountScreen,
   ReaderHomeScreen,
    SearchScreen,
    DetailScreen,
    UpdateScreen,
    ReaderStatsScreen;
    companion object {
        fun frmRoute(route:String?):ReaderScreens
        =when(route?.substringBefore("/")){
            SplashScreen.name -> SplashScreen
            LoginScreen.name -> LoginScreen
            CreateAccountScreen.name ->  CreateAccountScreen
            ReaderHomeScreen.name -> ReaderHomeScreen
            DetailScreen.name -> DetailScreen
            SearchScreen.name -> SearchScreen
            ReaderStatsScreen.name -> ReaderStatsScreen
            UpdateScreen.name -> UpdateScreen
            null ->ReaderHomeScreen
            else ->throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}