package com.moment.space.ui.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.moment.space.R
import com.moment.space.ui.util.SpaceNavigation

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NewsContentPage(controller: NavHostController) {
    val sizeList = rememberSaveable {
        mutableStateOf(listOf(
            13.sp,
            18.sp,
            23.sp
        ))
    }
    val index = rememberSaveable {
        mutableStateOf(1)
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        stickyHeader {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp)
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
                    ),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "go back",
                    alignment = Alignment.CenterStart,
                    modifier = Modifier
                        .size(45.dp)
                        .padding(start = 20.dp)
                        .clickable(onClick = {
                            controller.popBackStack()
                        }),
                    colorFilter = ColorFilter.tint(color = Color.DarkGray),
                    contentScale = ContentScale.Fit
                )
                Image(
                    painter = painterResource(id = R.drawable.font_size),
                    contentDescription = "go back",
                    alignment = Alignment.CenterStart,
                    modifier = Modifier
                        .size(45.dp)
                        .padding(end = 20.dp)
                        .clickable(enabled = true, onClick = {
                            if (index.value == 2) {
                                index.value = 0
                            } else {
                                index.value = index.value + 1
                            }
                        }),
                    colorFilter = ColorFilter.tint(color = Color.DarkGray),
                    contentScale = ContentScale.Fit
                )
            }
        }
        item {
            Text(
                text = "长征九号重型运载火箭发射成功",
                fontSize = 23.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp, horizontal = 20.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 10.dp), horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "作者：新华社",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
                Spacer(modifier = Modifier.width(10.dp))
                Text(
                    text = "发布时间：2022年12月12日 13:22",
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray
                )
            }
            Text(
                text = "人民日报欧洲网编译报道，脉冲星（Pulsa）是恒星死亡后的残骸，高速旋转、并具有很强的磁场。最近，天文学家观测到一颗脉冲星发出一条长达40万亿英里（40⨯10¹²）的物质带，更奇特的是，里面不仅有正物质，还有不少反物质（即正电子）。\n" +
                        "\n" +
                        "并不是所有的脉冲星都在发出如此大量正电子，因此这颗脉冲星很奇特。它所发出的物质带的规模相当大，科学家认为也许可以作为银河系中为什么有大量正电子存在的一种可能解释。正电子是普通电子的反物质，电子带负电荷，正电子带正电荷。\n" +
                        "\n" +
                        "天文学家最早在2020年发现这颗脉冲星发出的物质带，但是当时并不知道它究竟有多长，因为它的长度超出了钱德拉X射线观测台（Chandra X-ray Observatory）当时观测的范围。结合2021年2月和11月新一批的观测数据，科学家终于确定了它的全长。\n" +
                        "\n" +
                        "从地球上看，它在天空中的跨度相当于半个月球那么宽，是至今为止在地球上观测到的最长的一条由单个脉冲星发出的物质带。\n" +
                        "\n" +
                        "这项研究的负责人斯坦福大学的马丁·德弗里斯（Martijn de Vries）说：“一颗直径只有10英里的脉冲星所发出的物质竟然形成这么大的一个结构，这相当令人震惊。两者的大小比例是什么概念呢？如果把这条物质带比作纽约到洛杉矶的距离，那么这颗脉冲星只有人眼能看到的最小物质的百分之一这么大。”\n" +
                        "\n" +
                        "这颗脉冲星代号PSR J2030+4415，距离地球大约1,600光年，大约每秒钟自转三圈，比屋顶常见的风扇转得更快一些。\n" +
                        "\n" +
                        "研究人员认为，这项发现更重要的意义在于，为银河系中反物质的来源提供了新的线索。反物质与普通物质多数属性都是一样的，只不过带相反的电荷。比如普通的电子带负电荷，电子的反物质就带有正电荷。\n" +
                        "\n" +
                        "科学家观测到这个宇宙中普通物质占绝大多数，反物质只有很少量。可是奇怪的是，从地球上探测到的情况来看，正电子的数量比其它反物质多得多。科学家觉得这很奇怪，是什么事件会特别产生这种反物质？\n" +
                        "\n" +
                        "科学家认为这份研究找到了一个可能的原因。脉冲星结合自转快和磁场强的特点，导致粒子被加速、产生带有正、负电子对的高能射线。爱因斯坦提出的能量公式E = mc²，人们所熟悉的理解是，这描述了物质质量会转化为多少能量。其实反过来看也是成立的规律：能量也可以转化成物质。\n" +
                        "\n" +
                        "这颗脉冲星在特殊的条件下，就在向宇宙中发出大量正电子。这份研究提出的解释是，脉冲星产生的大量带电粒子风通常受限于脉冲星自身强大的磁场。这颗脉冲星在太空中以百万英里的时速运动着，这个过程使得它发出的带电粒子风像尾流一样尾随其后。而在脉冲星的前方有一道弓形气体冲击波，类似船在水中开动的时候前方的弓形水波。\n" +
                        "\n" +
                        "可是大约在二三十年前，这道弓形气体冲击波突然停止了运动，脉冲星赶上了它。研究者认为，这导致脉冲星自身的磁场和“几乎是从左至右呈直线的方向”的星际磁场相遇，从而发生相互作用。\n" +
                        "\n" +
                        "“很可能就是此时激发了粒子泄漏。”合作研究者之一罗杰·罗曼尼（Roger Romani）说，“脉冲星的磁场与星际磁场连接了起来，形成一个喷嘴一样的通道，高能电子和正电子就从这个通道被喷射而出。”\n" +
                        "\n" +
                        "研究称，这些粒子沿着星际磁场的磁力线方向、以接近三分之一光速的速度运动，发出了X射线。这个过程形成了钱德拉X射线观测台所观测到的巨大的物质带结构。\n" +
                        "\n" +
                        "以前，天文学家观测到脉冲星周围存在伽马射线，这意味着正电子并没有泄漏到太空之中。然而这次发现的这颗脉冲星PSR J2030+4415情况不一样，说明脉冲星产生的反物质粒子也会泄漏到太空中，并最终抵达地球。",
                fontSize = sizeList.value[index.value],
                modifier = Modifier.padding(vertical = 10.dp, horizontal = 20.dp)
            )
        }
    }

}