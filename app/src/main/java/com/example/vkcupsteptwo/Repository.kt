package com.example.vkcupsteptwo

import com.example.vkcupsteptwo.model.*
import com.example.vkcupsteptwo.untils.Constants.CompareScreen
import com.example.vkcupsteptwo.untils.Constants.FillTextScreen
import com.example.vkcupsteptwo.untils.Constants.QuestionsScreen
import com.example.vkcupsteptwo.untils.Constants.RateArticleScreen
import com.example.vkcupsteptwo.untils.Constants.TextExamplesScreen
import kotlinx.coroutines.delay

class Repository {

    private val remoteDataSource = DataSource(
        questions = (1..100).map {
            QuestionForm(
                answers = listOf("минимализм", "Сверхицизм", "Расизм", "Полиморфизм"),
                currentValue = 100,
                count = it,
                group = GroupInfo(
                    name = "опросы)",
                    icon = R.drawable.some_pict,
                    date = "5 янв в 13:20"
                ),
                postData = PostData(
                    title = "Какой стить в дизайне вам нравится больше?",
                    postKind = "Публичный опрос"
                ),
                actionsInfo = ActionsInfo(12,12,12)
            )
        },
        compareItems = (1..100).map {
            CompareForm(
                compareItems = listOf(Pair("одиdfgdfgdfdfн","1"),Pair("два","2"),Pair("три","3"),Pair("четыре","4"),Pair("три","3"),Pair("четыре","4")),
                currentValue = 100,
                count = it,
                group = GroupInfo(
                    name = "опросы)",
                    icon = R.drawable.some_pict,
                    date = "5 янв в 13:20"
                ),
                postData = PostData(
                    title = "Сопоставьте элементы",
                    postKind = "Публичный опрос"
                ),
                actionsInfo = ActionsInfo(12,12,12)
            )
        },
        textExamplesWithVariants = (1..100).map {
            TextFormWithVariants(
                variants = Pair("Текст & несколькими пропусками & вариантами несколькими пропусками & вариантами текст & несколькими пропусками", listOf("один","два","и","и")),
                currentValue = 100,
                count = it,
                group = GroupInfo(
                    name = "опросы)",
                    icon = R.drawable.some_pict,
                    date = "5 янв в 13:20"
                ),
                postData = PostData(
                    title = "Заполните пропуски",
                    postKind = "Публичный опрос"
                ),
                actionsInfo = ActionsInfo(12,12,12)
            )
        },
        textExamples = (1..100).map {
            TextForm(
                text = "Текст & несколькими пропусками & вариантами несколькими пропусками & вариантами текст & несколькими пропусками",
                currentValue = 100,
                count = it,
                group = GroupInfo(
                    name = "опросы)",
                    icon = R.drawable.some_pict,
                    date = "5 янв в 13:20"
                ),
                postData = PostData(
                    title = "Заполните пропуски",
                    postKind = "Публичный опрос"
                ),
                actionsInfo = ActionsInfo(12,12,12)
            )
        },
        articleData = (1..100).map {
            ArticleForm(
                title = "Cтатья",
                currentValue = 100,
                count = it,
                group = GroupInfo(
                    name = "опросы)",
                    icon = R.drawable.some_pict,
                    date = "5 янв в 13:20"
                ),
                postData = PostData(
                    title = "Заполните пропуски",
                    postKind = "Публичный опрос"
                )
            )
        }
    )

    suspend fun getData(page:Int, pageSize: Int, kindData:Int):Result<List<*>> {
        delay(500L)
        val startingIndex = page * pageSize
        return when (kindData) {
            QuestionsScreen -> {
                if (startingIndex + pageSize <= remoteDataSource.questions.size) {
                    Result.success(
                        remoteDataSource.questions.slice(startingIndex until startingIndex + pageSize)
                    )
                } else Result.success(emptyList())
            }
            CompareScreen -> {
                if (startingIndex + pageSize <= remoteDataSource.compareItems.size) {
                    Result.success(
                        remoteDataSource.compareItems.slice(startingIndex until startingIndex + pageSize)
                    )
                } else Result.success(emptyList())
            }
            TextExamplesScreen -> {
                if (startingIndex + pageSize <= remoteDataSource.textExamplesWithVariants.size) {
                    Result.success(
                        remoteDataSource.textExamplesWithVariants.slice(startingIndex until startingIndex + pageSize)
                    )
                } else Result.success(emptyList())
            }
            FillTextScreen -> {
                if (startingIndex + pageSize <= remoteDataSource.textExamples.size) {
                    Result.success(
                        remoteDataSource.textExamples.slice(startingIndex until startingIndex + pageSize)
                    )
                } else Result.success(emptyList())
            }
            RateArticleScreen -> {
                if (startingIndex + pageSize <= remoteDataSource.articleData.size) {
                    Result.success(
                        remoteDataSource.articleData.slice(startingIndex until startingIndex + pageSize)
                    )
                } else Result.success(emptyList())
            }
            else -> Result.success(listOf<String>())
        }
    }
}