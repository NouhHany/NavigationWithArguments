package com.example.navigationwitharguments

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun HomeScreen(navController: NavHostController) {
	Column(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.Center,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		val context = LocalContext.current
		var nameValue by remember { mutableStateOf(value = "") }
		var ageValue by remember { mutableStateOf(value = "") }
		Text(text = "Home Screen", fontSize = 54.sp)
		Spacer(modifier = Modifier.height(65.dp))
		TextField(
			value = nameValue,
			onValueChange = { nameValue = it },
			modifier = Modifier.padding(10.dp),
			placeholder = { Text(text = "Enter your name") }
		)
		TextField(
			value = ageValue,
			onValueChange = { ageValue = it },
			modifier = Modifier.padding(40.dp),
			placeholder = { Text(text = "Enter your age") }
		)
		Button(onClick = {
//			if (nameValue.isNotEmpty() && ageValue.isNotEmpty()) {
//				navController.navigate(route = "Details/$nameValue/$ageValue")
//			} else {
//				Toast.makeText(context,"Enter data", Toast.LENGTH_SHORT).show()
//			}
			navController.navigate(route = "Details?name=$nameValue&age=$ageValue")
		}) {
			Text(text = "Pass data", fontSize = 30.sp)
		}
	}
}
