package com.example.portablequiz.presentation.change_topic_screen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.portablequiz.presentation.theme.Primary
import com.example.portablequiz.presentation.theme.Surface
import com.example.portablequiz.utils.Constants.topics

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ChangeTopicScreen(
    navController: NavController,
    viewModel: ChangeTopicScreenViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Choose the topic!",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold
        )

        LazyColumn(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(topics.size) { index ->
                Card (
                    modifier = Modifier.padding(20.dp),
                    border = BorderStroke(2.dp, Color.Black),
                    shape = RoundedCornerShape(16.dp),
                    backgroundColor = if (index == state.value.chosenTopicIndex) {
                        Primary
                    } else {
                        Surface
                    },
                    onClick = {
                        viewModel.setTopic(index)
                    }
                ) {
                    Text(
                        modifier = Modifier.padding(10.dp),
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        text = topics[index]
                    )
                }
            }
        }
    }
}