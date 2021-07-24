package jp.kaleidot725.animation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import jp.kaleidot725.animation.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    LazyColumn {
                        item {
                            AnimatedVisibilitySample()
                        }

                        item {
                            AnimatedVisibilityStateSample()
                        }

                        item {
                            AnimatedVisibilityEnterExitSample()
                        }

                        item {
                            AnimatedContentCounterDefault()
                        }

                        item {
                            AnimatedContentCounterCustom()
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalAnimationApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AppTheme {
        Surface(color = MaterialTheme.colors.background) {
            LazyColumn {
                item {
                    AnimatedVisibilitySample()
                }

                item {
                    AnimatedVisibilityStateSample()
                }

                item {
                    AnimatedVisibilityEnterExitSample()
                }
            }
        }
    }
}