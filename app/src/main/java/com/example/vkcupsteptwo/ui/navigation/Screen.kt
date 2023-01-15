package com.example.vkcupsteptwo.ui.navigation

sealed class Screen(val route:String) {
    object QuestioningScreen: Screen("questions_screen")
    object CompareElementsScreen: Screen("compare_screen")
    object DragVariantsTextScreen: Screen("drag_variants_text_screen")
    object FillGapsScreen:Screen("filling_gaps_screen")
    object ArticleRateScreen:Screen("article_rate_screen")
}