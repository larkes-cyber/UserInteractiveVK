package com.example.vkcupsteptwo.ui.navigation

sealed class Screen(val route:String) {
    object QuestioningScreen: Screen("questions_screen")
    object CompareElementsScreen: Screen("compare_screen")
    object DragVariantsTextScreen: Screen("drag_variants_text_screen")
    object FillingGapsScreen:Screen("filling_gaps_screen")
    object ArticleGradeScreen:Screen("article_grade_screen")
}