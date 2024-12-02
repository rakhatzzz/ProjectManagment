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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
import com.example.projectmanagment.presentation.auth.AuthViewModel


@Composable
fun ProfilePage(navController: NavController,authViewModel: AuthViewModel){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 25.dp).padding(horizontal = 25.dp)
    ){
        Image(
            painter = painterResource(R.drawable.icons8_male_user_96),
            contentDescription = "profile_icon",
            modifier = Modifier
                .size(250.dp)
        )
        Text(
            text = "Name Surname",
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF3D3BFF),
                textAlign = TextAlign.Center,
            )
        )
        Text(
            text = "example@ex.com",
            style = TextStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF3D3BFF),
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
                text = "Избранные",
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
                text = "История",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight(600),
                    color = Color.White,
                    textAlign = TextAlign.Center,
                )
            )
        }
    }
}