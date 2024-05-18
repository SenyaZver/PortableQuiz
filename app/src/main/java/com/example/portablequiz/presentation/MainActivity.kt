package com.example.portablequiz.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.portablequiz.presentation.Routes.changeTopicScreenRoute
import com.example.portablequiz.presentation.Routes.mainScreenRoute
import com.example.portablequiz.presentation.Routes.quizScreenRoute
import com.example.portablequiz.presentation.Routes.resultScreenRoute
import com.example.portablequiz.presentation.main_screen.MainScreen
import com.example.portablequiz.presentation.quiz_screen.QuizScreen
import com.example.portablequiz.presentation.change_topic_screen.ChangeTopicScreen
import com.example.portablequiz.presentation.result_screen.ResultScreen
import com.example.portablequiz.presentation.theme.PortableQuizTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PortableQuizTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController, mainScreenRoute) {
                        composable(mainScreenRoute) {
                            MainScreen(navController)
                        }
                        composable(quizScreenRoute) {
                            QuizScreen(navController)
                        }
                        composable(resultScreenRoute) {
                            ResultScreen(navController)
                        }
                        composable(changeTopicScreenRoute) {
                            ChangeTopicScreen(navController)
                        }
                    }
                }


            }
        }
    }
}

object Routes {
    val mainScreenRoute = "StartScreen"
    val quizScreenRoute = "QuizScreen"
    val resultScreenRoute = "ResultScreen"
    val changeTopicScreenRoute = "ChangeTopicScreen"
}
