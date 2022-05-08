package com.moment.space.data

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.moment.space.R
import java.util.*

data class NewsContent(
    val title: MutableState<String>,    // 标题
    val author: MutableState<String>, // 作者
    val content: MutableState<String>, // 新闻内容
    val date: MutableState<Date>, // 日期
    val isMark: MutableState<Boolean> = mutableStateOf(false)// 是否收藏
)
