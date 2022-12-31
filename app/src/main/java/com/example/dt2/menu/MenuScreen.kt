package com.example.dt2.menu

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.dt2.ScreenData
import com.example.dt2.navGraph.BottomNavGraph

@Composable
fun MenuScreen(navController: NavHostController = rememberNavController()) {
    Scaffold(bottomBar = { BottomBar(navController = navController) }) {
        BottomNavGraph(navController = navController)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screen = listOf(
        ScreenData.Home,
        ScreenData.Search,
        ScreenData.Create,
        ScreenData.Subscribed,
        ScreenData.Profile
    )
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination
    val bottomBarDestination = screen.any { it.route == currentDestination?.route }
    if (bottomBarDestination) {
        BottomNavigation {
            screen.forEach { ScreenData ->
                AddItem(
                    screenData = ScreenData,
                    currentDestination = currentDestination,
                    navController = navController
                )
            }
        }
    }


}

@Composable
fun RowScope.AddItem(
    screenData: ScreenData,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    BottomNavigationItem(selected = currentDestination?.hierarchy?.any { it.route == screenData.route } == true,
        onClick = {
            navController.navigate(screenData.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }

        },
        icon = {
            Icon(
                painter = painterResource(id = screenData.icon),
                contentDescription = "icons"
            )
        }
    )
}
