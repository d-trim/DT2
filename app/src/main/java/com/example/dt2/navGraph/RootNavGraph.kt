package com.example.dt2.navGraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.dt2.Graph
import com.example.dt2.menu.MenuScreen

@Composable
fun RootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Graph.AUTHENTICATION,
        route = Graph.ROOT
    ) {
        authGraph(navController)
        composable(Graph.MENU){ MenuScreen()}
    }
}