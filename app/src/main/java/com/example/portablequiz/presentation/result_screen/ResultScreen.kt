package com.example.portablequiz.presentation.result_screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.portablequiz.presentation.Routes.mainScreenRoute
import com.example.portablequiz.presentation.Routes.quizScreenRoute
import com.example.portablequiz.utils.Constants.questionsAmount

@Composable
fun ResultScreen (
    navController: NavController,
    viewModel: ResultScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(Modifier.height(40.dp))

        Text(
            text = "The Quiz is over!",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(20.dp))

        Text(
            text = "Your score is ${state.value.correctAnswersAmount}/${questionsAmount}",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.height(60.dp))

        Text(
            text = "Try another quiz! The questions will be different!",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(Modifier.weight(1f))

        Button(
            onClick = {
                navController.navigate(quizScreenRoute)
            },
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Play Again",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate(mainScreenRoute)
            },
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Menu",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(20.dp))

    }
}