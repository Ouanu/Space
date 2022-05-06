package com.moment.space.ui.view

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moment.space.R
import com.moment.space.ui.util.SpaceNavigation

@ExperimentalFoundationApi
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewsPage(navigation: SpaceNavigation) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        stickyHeader {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colors.background,
                                Color(0x55ffffff)
                            ),
                            startY = 10f,
                            endY = 600f,
                            tileMode = TileMode.Clamp
                        ),
                        shape = RoundedCornerShape(bottomStart = 20.dp, bottomEnd = 20.dp)
                    )
                    .padding(top = 20.dp, bottom = 5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        alignment = Alignment.TopStart,
                        modifier = Modifier
                            .fillMaxHeight()
                            .size(38.dp)
                            .padding(start = 10.dp)
                    )
                    Text(text = "星球日报", fontSize = 23.sp, fontWeight = FontWeight.Bold, fontStyle = FontStyle.Italic)
                    Image(
                        painter = painterResource(id = R.drawable.help),
                        contentDescription = null,
                        contentScale = ContentScale.Fit,
                        alignment = Alignment.TopEnd,
                        modifier = Modifier
                            .fillMaxHeight()
                            .size(38.dp)
                            .padding(end = 10.dp)
                    )
                }
            }

        }
        item {
            HotNews()
        }
        items(20) {
            Divider(modifier = Modifier.padding(vertical = 10.dp))
            NewsItem(navigation)
        }
    }
}

@Composable
fun HotNews() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .padding(horizontal = 10.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Icon(
            painter = painterResource(id = R.drawable.hot_point),
            contentDescription = "hot_point",
            tint = Color.Red,
            modifier = Modifier.padding(vertical = 5.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.fly),
            contentDescription = "Test Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillWidth
        )
        Text(
            text = "长征九号重型运载火箭发射成功",
            fontSize = 20.sp,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp)
        )
        Text(
            text = "发布时间：2022年12月12日 13:22",
            fontSize = 15.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.Gray,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}

@Composable
fun NewsItem(navigation: SpaceNavigation) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp)
            .clickable(enabled = true, onClick = {
                Log.d("NewsPage", "NewsItem: click")
                navigation.navigationToContent()
            }),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = R.drawable.fly),
            contentDescription = "Test image",
            modifier = Modifier
                .size(70.dp)
                .clip(shape = RoundedCornerShape(10.dp)),
            contentScale = ContentScale.FillHeight,

            )
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(8f)
                .padding(horizontal = 10.dp),
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "科学家发现脉一冲星释出巨大物质带 包含大量正物质和反物质",
                maxLines = 2,
                fontSize = 16.sp,
                textAlign = TextAlign.Start,
                overflow = TextOverflow.Ellipsis,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(1f)
            )
            Text(
                text = "发布时间：2022年12月12日 13:22",
                fontSize = 13.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.Gray,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .padding(top = 10.dp),
            )

        }
        Image(
            painter = painterResource(id = R.drawable.unmark),
            contentDescription = "Test image",
            modifier = Modifier.weight(1f),
            contentScale = ContentScale.Fit
        )
    }
}