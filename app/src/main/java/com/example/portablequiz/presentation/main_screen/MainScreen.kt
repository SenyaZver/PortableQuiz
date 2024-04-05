package com.example.portablequiz.presentation.main_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.portablequiz.Routes.quizScreenRoute

@Composable
fun MainScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(20.dp))

        Card(
            shape = RoundedCornerShape(32.dp),
            elevation = 10.dp,
            border = BorderStroke(width = 2.dp, color = Color.Gray)
        ) {
            Text(
                modifier = Modifier.padding(30.dp),
                text = "Portable Quiz",
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
        Spacer(Modifier.weight(1f))

        Button(
            onClick = {},
            shape = RoundedCornerShape(32.dp)
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Change topic",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                navController.navigate(quizScreenRoute)
            },
            shape = RoundedCornerShape(32.dp)
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Play",
                fontSize = 34.sp,
                fontWeight = FontWeight.Bold
            )
        }


        Spacer(Modifier.height(60.dp))
    }
}