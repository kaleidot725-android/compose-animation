package jp.kaleidot725.animation

import androidx.compose.animation.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign

@ExperimentalAnimationApi
@Composable
fun AnimatedContentCounterDefault() {
    Column {
        // targetState に渡した値が変更され、更新する必要があれば、アニメーション表示し更新する
        // (taregetState に渡した値をキーとして識別するような仕組みになっている)
        var count: Int by remember { mutableStateOf(0) }

        // デフォルトのアニメーションで現在の値がフェードアウトして、次の値がフェードインして表示されるようになっている
        AnimatedContent(targetState = count) { targetCount ->
            Text(
                text = "$targetCount",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { count++ }) {
                Text("PLUS")
            }

            Button(onClick = { count-- }) {
                Text("MINUS")
            }
        }
    }
}

@ExperimentalAnimationApi
@Composable
fun AnimatedContentCounterCustom() {
    Column {
        var count: Int by remember { mutableStateOf(0) }

        AnimatedContent(
            targetState = count,
            transitionSpec = {
                // <EnterTransition> with <ExitTransition> という形式でアニメーションを定義する
                // 数がプラスされたか、マイナスされたかで移動する方向を変えたいので if で分岐している
                val isAdd = targetState > initialState
                if (isAdd) {
                    slideInHorizontally({ width -> width }) + fadeIn() with slideOutHorizontally({ width -> -width }) + fadeOut()
                } else {
                    slideInHorizontally({ width -> -width }) + fadeIn() with slideOutHorizontally({ width -> width }) + fadeOut()
                }.using(
                    SizeTransform(clip = false)
                )
            }
        ) { targetCount ->
            Text(
                text = "$targetCount",
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h2,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(onClick = { count++ }) {
                Text("PLUS")
            }

            Button(onClick = { count-- }) {
                Text("MINUS")
            }
        }
    }
}