package com.moment.space.ui.view

import android.annotation.SuppressLint
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.moment.space.R
import com.moment.space.ui.theme.SpaceTheme
import com.moment.space.ui.util.SpaceDestination
import com.moment.space.ui.util.SpaceNavGraph
import com.moment.space.ui.util.SpaceNavigation
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SpaceApp(controller: NavHostController) {
    val navigationActions = remember(controller) {
        SpaceNavigation(controller)
    }
    val navBackStackEntry by controller.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: SpaceDestination.NEWS_ROUTE
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState = drawerState)
    SpaceTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            scaffoldState = scaffoldState,
            drawerContent = {
                SpaceDrawer(
                    navController = controller,
                    currentRoute = currentRoute,
                    navigateToHome = navigationActions.navigationToHome,
                    navigateToTask = navigationActions.navigationToTask,
                    navigateToRocket = navigationActions.navigationToRocket,
                    closeDrawer = {
                        coroutineScope.launch { drawerState.close() }
                    }
                )
            },
            drawerShape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .statusBarsPadding()
            ) {
                SpaceNavGraph(
                    controller = controller,
                    openDrawer = { coroutineScope.launch { drawerState.open() } }
                )
            }
        }
    }

}