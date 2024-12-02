package com.example.projectmanagment.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.projectmanagment.R
import com.example.projectmanagment.presentation.auth.AuthState
import com.example.projectmanagment.presentation.auth.AuthViewModel
import com.example.projectmanagment.presentation.navigation.AuthRoutes
import com.google.firebase.auth.FirebaseAuth


@Composable
fun ProfilePage(navController: NavController,authViewModel: AuthViewModel){
    val user = FirebaseAuth.getInstance().currentUser
    val userName = user?.displayName ?: "User"
    val usermail = user?.email ?: ""
    val authState = authViewModel.authState.observeAsState()

    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Unauthenticated -> navController.navigate(AuthRoutes.LOGIN)
            else -> Unit
        }
    }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp).padding(horizontal = 25.dp)
    ){
        Icon(imageVector = Icons.Default.AccountCircle,
            contentDescription = null,
            modifier = Modifier
                .size(250.dp)
        )
//        Image(
//            painter = painterResource(),
//            contentDescription = "profile_icon",
//            modifier = Modifier
//                .size(250.dp)
//        )
        Text(
            text = userName,
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
//                color = Color(0xFF3D3BFF),
                textAlign = TextAlign.Center,
            )
        )
        Text(
            text = usermail,
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
//                color = Color(0xFF3D3BFF),
                textAlign = TextAlign.Center,
            )
        )

        Spacer(modifier = Modifier.height(25.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color(0xFF3D3BFF), RoundedCornerShape(20.dp))
        ){
            Text(
                text = "Favourite",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight(600),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .background(Color(0xFF3D3BFF), RoundedCornerShape(20.dp))
        ){
            Text(
                text = "History",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight(600),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            )
        }
        Spacer(modifier = Modifier.height(200.dp))

        TextButton(
            onClick = { authViewModel.signout() }
        ) {
            Text(text = "Sign out")
        }
    }
}