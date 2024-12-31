package com.example

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SecondScreen(
    navigateToFirstScreen: (String, Int) -> Unit,
    navigateToThirdScreen: () -> Unit,
    name: String,
    age: Int,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("This is the Second Screen", fontSize = 24.sp)
        Text("Welcome $name. You are $age years old", fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navigateToFirstScreen(name, age) }) {
            Text("Go to First Screen")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { navigateToThirdScreen() }) {
            Text("Go to Third Screen")
        }
    }
}

@Preview
@Composable
fun SecondScreenPreview() {
    SecondScreen(navigateToFirstScreen = { name, age -> }, navigateToThirdScreen = {}, name = "", age = 0)
}