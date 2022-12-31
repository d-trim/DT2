package com.example.dt2.authentication

import android.app.DatePickerDialog
import android.icu.util.Calendar
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dt2.AuthData
import com.example.dt2.R
import com.example.dt2.ui.theme.BG
import com.example.dt2.ui.theme.bg1
import com.example.dt2.ui.theme.bg2
import com.example.dt2.ui.theme.btn
import java.util.*

@Composable
fun SignUpScreen(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var userName by remember {  mutableStateOf("")    }
    var password by remember { mutableStateOf("")     }
    var confirmPassword by remember { mutableStateOf("")     }

    var visibility by remember {    mutableStateOf(false)   }
    val icon = if (visibility) {
        painterResource(id = R.drawable.ic_baseline_visibility_24)
    } else {
        painterResource(id = R.drawable.ic_baseline_visibility_off_24)
    }

    val context= LocalContext.current
    val year: Int
    val month: Int
    val day: Int

    val calender = Calendar.getInstance()
    year = calender.get(Calendar.YEAR)
    month = calender.get(Calendar.MONTH)
    day = calender.get(Calendar.DAY_OF_MONTH)
    calender.time = Date()
    val date = remember {
        mutableStateOf("")
    }
    val datePickerDialog = DatePickerDialog(
        context, { _, year: Int, month: Int, dayOfMonth: Int ->
            date.value = "$dayOfMonth/${month+1}/$year"

        }, year, month, day
    )


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(if (isSystemInDarkTheme()) BG else BG),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Sign Up",
            fontSize = MaterialTheme.typography.h4.fontSize,
            color = btn
        )
        Spacer(modifier = Modifier.height(50.dp))
        TextField(
            modifier = Modifier.fillMaxWidth(.8f),
            value = name,
            onValueChange = { name = it },
            label = {
                Text(
                    text = "Full Name", color = Color.LightGray
                )
            },
            shape = RoundedCornerShape(50.dp),
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_person_24),
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.White,
                backgroundColor = bg1,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                leadingIconColor = Color.White
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next
            ),

        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(modifier = Modifier.fillMaxWidth(.8f),
            value = userName,
            onValueChange ={userName=it},
            leadingIcon = { Icon(painter = painterResource(id = R.drawable.ic_baseline_sync_24),
                contentDescription ="sync" )},
            label = { Text(text ="Username", color = Color.LightGray )},
            shape = RoundedCornerShape(50.dp),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
            colors = TextFieldDefaults.textFieldColors(
                cursorColor = Color.White,
                textColor = Color.White,
                backgroundColor = bg1,
                leadingIconColor = Color.LightGray,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            )
            

        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = password,
            modifier = Modifier.fillMaxWidth(.8f),
            onValueChange = { password = it },
            label = { Text(text = "Password", color = Color.LightGray) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                    contentDescription = null
                )
            },
            trailingIcon = {
                IconButton(onClick = {
                    visibility = !visibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "visibility"
                    )
                }
            },
            visualTransformation = if (visibility) VisualTransformation.None
            else PasswordVisualTransformation(),
            shape = RoundedCornerShape(50.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = bg1,
                textColor = Color.White,
                leadingIconColor = Color.LightGray,
                disabledBorderColor = Color.Transparent,
                cursorColor = Color.White,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = confirmPassword,
            modifier = Modifier.fillMaxWidth(.8f),
            onValueChange = { confirmPassword = it },
            label = { Text(text = "Confirm Password", color = Color.LightGray) },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_lock_24),
                    contentDescription = null
                )
            },

            visualTransformation = PasswordVisualTransformation(),
            shape = RoundedCornerShape(50.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = bg1,
                textColor = Color.White,
                leadingIconColor = if (password=="") Color.LightGray else if (password==confirmPassword) Color.Green else Color.Red,
                disabledBorderColor = Color.Transparent,
                cursorColor = btn,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(.8f),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Date Of Birth :",
                color = Color.LightGray,
                fontSize =MaterialTheme.typography.h6.fontSize
            )
            Text(
                modifier = Modifier.clickable { datePickerDialog.show() },
                text =if(date.value=="") "__ /__ /____" else "  ${date.value}",
                fontSize =MaterialTheme.typography.h6.fontSize,
                color = Color.White
            )
            IconButton(onClick = {  datePickerDialog.show() }) {
                Icon(painter = painterResource(id = R.drawable.ic_baseline_calendar_month_24) ,
                    contentDescription ="calender", tint = Color.White )
            }
        }
        Spacer(modifier = Modifier.height(50.dp))
        Button(
            onClick = { navController.navigate(AuthData.Contact.route) },
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor =if (name!="" && userName!="" && password!="" && date.value!="") btn
                else bg1,
                contentColor = Color.White),
        ) {
            Text(text = "Continue",
                fontSize = MaterialTheme.typography.body1.fontSize)
        }

    }
}



@Preview(showBackground = true)
@Composable
fun PreviewSignUpScreen() {
    SignUpScreen(navController = rememberNavController())
}