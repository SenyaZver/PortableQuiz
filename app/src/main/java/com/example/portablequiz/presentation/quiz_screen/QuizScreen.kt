package com.example.portablequiz.presentation.quiz_screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.portablequiz.presentation.Routes.resultScreenRoute
import com.example.portablequiz.utils.Constants.questionsAmount


@Composable
fun QuizScreen(
    navController: NavController,
    viewModel: QuizScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()

    if (state.value.gameOver) {
        LaunchedEffect(Unit) {
            viewModel.saveScore()
            navController.navigate(resultScreenRoute)
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.surface),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                modifier = Modifier.padding(10.dp),
                text = "Question ${state.value.currentQuestionNumber+1}/${questionsAmount}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                modifier = Modifier.padding(10.dp),
                text = "Correct Answers: ${state.value.correctAnswersAmount}",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(20.dp))

        Text(
            text = "Question:",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(10.dp))

        Text(
            text = state.value.question,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(100.dp))


        if (state.value.answers!= null) {
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                items(state.value.answers!!.size) {index ->
                    Button(
                        modifier = Modifier.padding(10.dp),
                        onClick = {
                            viewModel.chooseAnswer(index)
                        },
                        shape = RoundedCornerShape(16.dp),
                        colors = ButtonDefaults.buttonColors(state.value.colors[index])
                    ) {
                        Text(
                            text = state.value.answers!![index],
                            fontWeight = FontWeight.Bold,
                            fontSize = 20.sp
                        )
                    }
                }
            }
        } else {
            Spacer(Modifier.weight(1f))

            CircularProgressIndicator()

            Spacer(Modifier.weight(1f))
        }

        if (state.value.answerIsChosen) {

            Button(
                shape = RoundedCornerShape(16.dp),
                onClick = {
                    viewModel.changeQuestion()
                }
            ) {
                Text(
                    text = "Next",
                    fontSize = 20.sp
                )
            }
        }

        Spacer(Modifier.height(20.dp))




    }
}