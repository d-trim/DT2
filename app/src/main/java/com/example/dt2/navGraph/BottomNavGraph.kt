package com.example.dt2.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dt2.Graph
import com.example.dt2.ScreenData
import com.example.dt2.menu.*


@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(navController =navController ,
        route = Graph.HOME,
        startDestination = ScreenData.Home.route ){
        composable(ScreenData.Home.route){ HomeScreen(navController)}
        composable(ScreenData.Create.route){ CreateScreen(navController)}
        composable(ScreenData.Profile.route){ ProfileScreen(navController)}
        composable(ScreenData.Search.route){ SearchScreen(navController = navController)}
        composable(ScreenData.Subscribed.route){ SubscribeScreen(navController = navController)}

    }
}