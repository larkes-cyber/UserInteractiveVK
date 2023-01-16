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
        questions = (1..1000).map {
            QuestionForm(
                answers = listOf("Геймдизайн", "Дизайн интерьера", "Дизайн одежды", "Графический дизайн"),
                currentValue = 100,
                count = it,
                group = GroupInfo(
                    name = "опросы)",
                    icon = R.drawable.fifth_groupe_icon,
                    date = "5 янв в 13:20"
                ),
                postData = PostData(
                    title = "Какой дизайн вам нравится больше?",
                    postKind = "Публичный опрос",
                    comment = "Вопрос:$it/1000"
                ),
                actionsInfo = ActionsInfo(37,12,12)
            )
        },
        compareItems = (1..1000).map {
            CompareForm(
                compareItems = listOf(Pair("один","1"),Pair("два","2"),Pair("три","3"),Pair("четыре","4"),Pair("три","3"),Pair("четыре","4")),
                currentValue = 100,
                count = it,
                group = GroupInfo(
                    name = "4ch",
                    icon = R.drawable.fourth_group_icon,
                    date = "5 янв в 13:20"
                ),
                postData = PostData(
                    title = "Сопоставьте элементы",
                    postKind = "Публичный опрос",
                    comment = "Вы пробовали эту новую фичу вк?!?!?!?!?"
                ),
                actionsInfo = ActionsInfo(1200,12,12)
            )
        },
        textExamplesWithVariants = (1..100).map {
            TextFormWithVariants(
                variants = Pair("Текст & несколькими пропусками & вариантами несколькими пропусками & вариантами текст & несколькими пропусками", listOf("один","два","и","и")),
                currentValue = 100,
                count = it,
                group = GroupInfo(
                    name = "Nigga memes",
                    icon = R.drawable.third_group_icon,
                    date = "5 янв в 13:20"
                ),
                postData = PostData(
                    title = "Заполните пропуски",
                    postKind = "Публичный опрос",
                    comment = "Попробуйте кайф"
                ),
                actionsInfo = ActionsInfo(122,12,12)
            )
        },
        textExamples = (1..1000).map {
            TextForm(
                text = "Текст & несколькими пропусками & вариантами несколькими пропусками & вариантами текст & несколькими пропусками",
                currentValue = 100,
                count = it,
                group = GroupInfo(
                    name = "Чёткие приколы",
                    icon = R.drawable.fifth_groupe_icon,
                    date = "5 янв в 13:20"
                ),
                postData = PostData(
                    title = "Заполните пропуски",
                    postKind = "Публичный опрос",
                    comment = "Попробуйте кайф"
                ),
                actionsInfo = ActionsInfo(32,12,12)
            )
        },
        articleData = (1..1000).map {
            ArticleForm(
                title = "Cтатья",
                currentValue = 100,
                count = it,
                group = GroupInfo(
                    name = "Aнимае)",
                    icon = R.drawable.second_group_icon,
                    date = "5 янв в 13:20"
                ),
                postData = PostData(
                    title = "Заполните пропуски",
                    postKind = "Публичный опрос",
                    comment = "Как вам эта статья?"
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