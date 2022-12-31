package com.example.dt2.authentication

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.dt2.AuthData
import com.example.dt2.Graph
import com.example.dt2.R
import com.example.dt2.ui.theme.BG
import com.example.dt2.ui.theme.bg1
import com.example.dt2.ui.theme.btn

@Composable
fun LogInScreen(navController: NavController) {
    var username by remember { mutableStateOf("") }
    var password by remember {mutableStateOf("")  }
    var visibility by remember {    mutableStateOf(false)   }
    val icon = if (visibility) {
        painterResource(id = R.drawable.ic_baseline_visibility_24)
    } else {
        painterResource(id = R.drawable.ic_baseline_visibility_off_24)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(if (isSystemInDarkTheme()) BG else BG),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Image(painter = painterResource(id = R.drawable.app_logo), contentDescription = null)
        TextField(
            modifier = Modifier.fillMaxWidth(.8f),
            value = username,
            onValueChange = { username = it },
            placeholder = { Text(text = "Username") },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_baseline_person_24),
                    contentDescription = null
                )
            },
            shape = RoundedCornerShape(50.dp),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                backgroundColor = bg1,
                textColor = Color.White,
                leadingIconColor = btn,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent,
                cursorColor = btn

                ),

            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Default)

        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = password,
            modifier = Modifier.fillMaxWidth(.8f),
            onValueChange = { password = it },
            placeholder = { Text(text = "Password") },
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
                leadingIconColor = btn,
                disabledBorderColor = Color.Transparent,
                cursorColor = btn,
                focusedBorderColor = Color.Transparent,
                unfocusedBorderColor = Color.Transparent
            ),
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii)
        )
        Row(
            modifier = Modifier.fillMaxWidth(.8f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.End
        ) {
            TextButton(
                onClick = { /*TODO*/ },

                ) {
                Text(text = "Forget Password?", color = Color.LightGray)
            }
        }

        Button(
            onClick = {
                navController.popBackStack()
                navController.navigate(Graph.MENU) },
            modifier = Modifier.fillMaxWidth(.8f),
            shape = RoundedCornerShape(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = btn)
        ) {
            Text(
                text = "LogIn",
                color = Color.White,
                fontSize =MaterialTheme.typography.h6.fontSize,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(.8f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = { /*TODO*/ },
                Modifier.fillMaxWidth(.35f),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = bg1)
            ) {
                Text(text = "Guest", color = Color.White,fontSize =MaterialTheme.typography.body1.fontSize)
            }
            Button(
                onClick = {
                          navController.navigate(AuthData.Signup.route)
                },
                Modifier.fillMaxWidth(.5f),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = bg1)
            ) {
                Text(text = "SignUp",fontSize =MaterialTheme.typography.body1.fontSize, color = Color.White)
            }
        }
        Spacer(modifier = Modifier.height(80.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth(.8f)
        ) {
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxSize(.16f)

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.google_logo),
                    contentDescription = "google signIn",
                    tint = Color.Unspecified
                )
            }
            IconButton(
                onClick = { /*TODO*/ },
                modifier = Modifier.fillMaxSize(.2f)

                ) {
                Icon(
                    painter = painterResource(id = R.drawable.facebook_logo),
                    contentDescription = "facebook signIn",
                    tint = Color.Unspecified
                )
            }

        }
        Spacer(modifier = Modifier.height(80.dp))
        Text(text="By continuing, you agree to Dream Trim`s", color = Color.LightGray)
        TextButton(onClick = { /*TODO*/ }) {
            Text(text = "Terms Of Services & Privacy Policy",color=Color.White)

        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier
            .fillMaxSize(.8f)
            .padding(bottom = 1.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = R.drawable.ic_baseline_copyright_24),
                contentDescription =null, colorFilter = ColorFilter.tint(Color.White) )
            Text(text = "copyright", color = Color.White)
        }
        Spacer(modifier = Modifier.fillMaxSize())

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewLogInScreen() {
    LogInScreen(navController = rememberNavController())
}