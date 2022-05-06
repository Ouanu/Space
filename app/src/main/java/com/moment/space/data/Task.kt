package com.moment.space.data

import androidx.compose.runtime.MutableState
import java.util.*

data class Task(
    val country: MutableState<String>,
    val rocket: MutableState<String>,
    val date: MutableState<Date>,
    val location: MutableState<String>,
    val task: MutableState<String>
)
