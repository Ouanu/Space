package com.moment.space.ui.util

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.moment.space.ui.view.DataPage
import com.moment.space.ui.view.NewsContentPage
import com.moment.space.ui.view.NewsPage
import com.moment.space.ui.view.TaskPage

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun SpaceNavGraph(
    controller: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
    startDestination: String = SpaceDestination.NEWS_ROUTE,
    navigation: SpaceNavigation,
    openDrawer: () -> Unit
) {
    NavHost(navController = controller, startDestination = startDestination, modifier = modifier) {
        composable(SpaceDestination.NEWS_ROUTE){
            NewsPage(navigation)
        }
        composable(SpaceDestination.TASK_ROUTE){
            TaskPage()
        }
        composable(SpaceDestination.ROCKET_ROUTE){
            DataPage()
        }
        composable(SpaceDestination.CONTENT_ROUTE){
            NewsContentPage(controller)
        }
    }
}