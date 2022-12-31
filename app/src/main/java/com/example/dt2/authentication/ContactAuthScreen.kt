package com.example.dt2.authentication

import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.rememberNavController
import com.example.dt2.AuthData
import com.example.dt2.Graph
import com.example.dt2.ui.theme.BG
import com.example.dt2.ui.theme.btn

@Composable
fun ContactAuthScreen(navController: NavController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(if (isSystemInDarkTheme()) BG else BG),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Text(text = "Verify Contact Details ",
            color = btn,
            fontSize =MaterialTheme.typography.h4.fontSize,
            modifier = Modifier.padding(vertical = 100.dp)
        )
        Spacer(modifier = Modifier.height(400.dp))
        Button(onClick = {
            navController.navigate(Graph.MENU) {
                popUpTo(Graph.AUTHENTICATION){inclusive=true}
            } },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = btn,
                contentColor = Color.White,
            ),
            shape = RoundedCornerShape(50.dp),
        ) {
                Text(text = "Done", fontSize = MaterialTheme.typography.body1.fontSize)
        }

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewContactAuthScreen(){
    ContactAuthScreen(navController = rememberNavController())
}