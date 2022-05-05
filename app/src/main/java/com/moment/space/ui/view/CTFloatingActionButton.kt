package com.moment.space.ui.view

import android.annotation.SuppressLint
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moment.space.ui.theme.Shapes

@SuppressLint("UnusedTransitionTargetStateParameter")
@Composable
fun CTFloatingActionButton(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    iconColor: Color = Color.White,
    fabBackground: Color = Color.Unspecified,
    items: List<CTFabItem>,
    isShowLabel: Boolean = true,
    onFabItemClicked: (item: CTFabItem) -> Unit
) {
    // 悬浮Button的默认状态
    val currentState = remember { mutableStateOf(CTFabState.Collapsed) }
    // 管理动画，根据状态变化运行值
    val transition = updateTransition(targetState = currentState, label = "")
    val rotateAnimation: Float by transition.animateFloat(
        transitionSpec = {
            if (targetState.value == CTFabState.Expanded) {
                spring(stiffness = Spring.StiffnessLow)
            } else {
                spring(stiffness = Spring.StiffnessMedium)
            }
        }, label = ""
    ) { state ->
        if (state.value == CTFabState.Collapsed) 0f else -45f
    }
    // 透明度
    val alphaAnimation: Float by transition.animateFloat(transitionSpec = {
        tween(durationMillis = 200)
    }, label = "") { state ->
        if (state.value == CTFabState.Expanded) 1f else 0f
    }
    // 记录每个item的收缩动画
    val listAnimation: MutableList<Float> = mutableListOf()
    items.forEachIndexed { index, ctFabItem ->
        val anima by transition.animateFloat(targetValueByState = { state ->
            when (state.value) {
                CTFabState.Collapsed -> 5f
                CTFabState.Expanded -> (index + 1) * 60f + if (index == 0) 5f else 0f
            }
        }, label = "", transitionSpec = {
            if (targetState.value == CTFabState.Expanded) {
                spring(stiffness = Spring.StiffnessLow, dampingRatio = 0.58f)
            } else {
                spring(stiffness = Spring.StiffnessMedium)
            }
        })
        listAnimation.add(index, anima)
    }
    Box(modifier = modifier, contentAlignment = Alignment.BottomEnd) {
        items.forEachIndexed { index, ctFabItem ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(
                    bottom = listAnimation[index].dp,
                    top = 5.dp,
                    end = 30.dp
                )
            ) {
                if (isShowLabel) {
                    Text(
                        text = ctFabItem.label,
                        color = ctFabItem.labelTextColor,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .clip(Shapes.medium)
                            .alpha(animateFloatAsState(targetValue = alphaAnimation).value)
                            .background(color = ctFabItem.labelBackgroundColor)
                            .padding(vertical = 4.dp, horizontal = 6.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                }
                FloatingActionButton(
                    backgroundColor = if (ctFabItem.fabBackground == Color.Unspecified) MaterialTheme.colors.primary else ctFabItem.fabBackground,
                    modifier = Modifier.size(46.dp),
                    onClick = { },
                    elevation = FloatingActionButtonDefaults.elevation(
                        defaultElevation = 2.dp,
                        pressedElevation = 4.dp
                    ),
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Icon(
                        modifier = Modifier.size(16.dp),
                        imageVector = ctFabItem.icon,
                        tint = ctFabItem.iconColor,
                        contentDescription = ctFabItem.label
                    )
                }
            }
            FloatingActionButton(
                modifier = Modifier.padding(0.dp, end = 25.dp),
                backgroundColor = if (fabBackground == Color.Unspecified) MaterialTheme.colors.primary else fabBackground,
                onClick = {
                    //更新状态执行：收缩动画
                    currentState.value =
                        if (currentState.value == CTFabState.Collapsed) CTFabState.Expanded else CTFabState.Collapsed
                },
                shape = RoundedCornerShape(5.dp)
            ) {
                Icon(
                    imageVector = icon,
                    modifier = Modifier.rotate(rotateAnimation),
                    tint = iconColor,
                    contentDescription = null
                )
            }
        }
    }
}

class CTFabItem(
    val icon: ImageVector,
    val label: String,
    val iconColor: Color = Color.White,
    val labelTextColor: Color = Color.White,
    val labelBackgroundColor: Color = Color.White,
    val fabBackground: Color = Color.Unspecified
)

enum class CTFabState {
    Expanded,
    Collapsed
}