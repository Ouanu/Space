package com.moment.space.ui.util

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController


object SpaceDestination{
    const val NEWS_ROUTE = "news"
    const val TASK_ROUTE = "task"
    const val ROCKET_ROUTE = "rocket"
}

class SpaceNavigation(navController: NavHostController) {
    val navigationToHome: () -> Unit = {
        navController.navigate(SpaceDestination.NEWS_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigationToTask: () -> Unit = {
        navController.navigate(SpaceDestination.TASK_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val navigationToRocket: () -> Unit = {
        navController.navigate(SpaceDestination.ROCKET_ROUTE) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}