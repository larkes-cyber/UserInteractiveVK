package com.example.vkcupsteptwo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.vkcupsteptwo.ui.navigation.BottomNavBar
import com.example.vkcupsteptwo.ui.navigation.BottomNavItem
import com.example.vkcupsteptwo.ui.navigation.Navigation
import com.example.vkcupsteptwo.ui.theme.VkCupStepTwoTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkCupStepTwoTheme {
                val navController = rememberNavController()
                Scaffold(
                    Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavBar(
                            items = listOf(
                                BottomNavItem(
                                    icon = R.drawable.ic_baseline_question_answer_24,
                                    name = "Вопросы",
                                    route = "questions_screen"
                                ),
                                BottomNavItem(
                                    icon = R.drawable.ic_baseline_compare_arrows_24,
                                    name = "Cопоставить",
                                    route = "compare_screen"
                                ),
                                BottomNavItem(
                                    icon = R.drawable.ic_baseline_subtitles_24,
                                    name = "Вставить",
                                    route = "drag_variants_text_screen"
                                ),
                                BottomNavItem(
                                    icon = R.drawable.documenttext,
                                    name = "Пропуски",
                                    route = "filling_gaps_screen"
                                ),
                                BottomNavItem(
                                    icon = R.drawable.ic_baseline_star_border_24,
                                    name = "Оценки",
                                    route = "article_rate_screen"
                                )
                            ),
                            navController = navController
                        ){
                            navController.navigate(it.route)
                        }
                    }
                ){
                    Navigation(navHostController = navController)
                }
            }
        }
    }
}
