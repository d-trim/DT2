package com.example.dt2.navGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.dt2.AuthData
import com.example.dt2.Graph
import com.example.dt2.authentication.ContactAuthScreen
import com.example.dt2.authentication.LogInScreen
import com.example.dt2.authentication.SignUpScreen

fun NavGraphBuilder.authGraph(navController: NavHostController){
navigation(startDestination = AuthData.Login.route, route = Graph.AUTHENTICATION){
    composable(route = AuthData.Login.route){ LogInScreen(navController=navController)}
    composable(route = AuthData.Signup.route){ SignUpScreen(navController = navController)}
    composable(route=AuthData.Contact.route){ ContactAuthScreen(navController = navController)}
}
}