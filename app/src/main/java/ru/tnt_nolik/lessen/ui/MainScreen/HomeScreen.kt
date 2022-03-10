package ru.tnt_nolik.lessen.ui.HomeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.tnt_nolik.lessen.ui.MainScreen.HomeViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()){
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
        Text(text = viewModel.text , fontSize = 60.sp)
        inputText()
    }
}

@Composable
fun inputText(viewModel: HomeViewModel = hiltViewModel()){
    TextField(value = viewModel.text, onValueChange = { viewModel.text = it})
}


@Preview
@Composable
fun PreviewHome(){
    HomeScreen()
}