package com.example.vkcupsteptwo.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.vkcupsteptwo.ui.screen.compare_screen.CompareScreen
import com.example.vkcupsteptwo.ui.screen.drag_text_variants_screen.DragTextVariantsScreen
import com.example.vkcupsteptwo.ui.screen.fill_gaps_screen.FillGapsScreen
import com.example.vkcupsteptwo.ui.screen.questions_screen.QuestionsScreen
import com.example.vkcupsteptwo.ui.screen.rate_article_screen.RateArticleScreen

@Composable
fun Navigation(navHostController: NavHostController) {

    NavHost(navController = navHostController, startDestination =  Screen.QuestioningScreen.route){
        composable(route = Screen.QuestioningScreen.route){
            QuestionsScreen()
        }
        composable(route = Screen.CompareElementsScreen.route){
            CompareScreen()
        }
        composable(route = Screen.DragVariantsTextScreen.route){
            DragTextVariantsScreen()
        }
        composable(route = Screen.FillGapsScreen.route){
            FillGapsScreen()
        }
        composable(route = Screen.ArticleRateScreen.route){
            RateArticleScreen()
        }
    }

}