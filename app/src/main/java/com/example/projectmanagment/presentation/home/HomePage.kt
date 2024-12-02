package com.example.projectmanagment.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.projectmanagment.R
import com.example.projectmanagment.data.Course
import com.example.projectmanagment.presentation.HomeViewModel
import com.example.projectmanagment.presentation.UiState
import com.example.projectmanagment.presentation.auth.AuthViewModel
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomePage(navController: NavController, authViewModel: AuthViewModel) {
    val user = FirebaseAuth.getInstance().currentUser
    val userName = user?.displayName ?: "User"



    val homeViewModel: HomeViewModel = viewModel()
    val UiState = homeViewModel.uiState
    Box(
        modifier = Modifier
            .fillMaxSize()

    ) {
        when (UiState) {
            is UiState.Loading -> LoadingScreen(modifier = Modifier.fillMaxSize())
            is UiState.Success -> SuccessScreen(modifier = Modifier.fillMaxSize(),
                UiState.categori,userName, navController)
//            is UiState.Success -> categories(UiState.categories,navController = navController)
            is UiState.Error -> ErrorScreen(modifier = Modifier.fillMaxSize())
            else -> {}
        }
    }

}
@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = "loading"
    )
}
@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = "loading_failed", modifier = Modifier.padding(16.dp))
    }
}
@Composable
fun SuccessScreen(
    modifier: Modifier = Modifier,
    categori: List<Course>,
    userName: String,
    navController: NavController
) {
    Column(
//        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
//            .background(Color(0xff0d77f3))//2
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.logok),
                contentDescription = null,
                Modifier.size(50.dp)
//                    .clip(RoundedCornerShape(3.dp))
//                    .background(color = Color.White)
            )
            Text(
                modifier = Modifier.padding(start= 5.dp),
                text = "Hello $userName",
                fontSize = 32.sp,
//                color = Color.White,//2
                fontWeight = FontWeight.Bold
            )

        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            modifier = Modifier.padding(start = 4.dp),
            text= "Live and learn!",
            fontSize = 15.sp,
            color = Color(0xff979797) //1
//            color = Color.White //2
        )

        Spacer(modifier = Modifier.height(30.dp))
        Text(
            modifier = Modifier.padding(start = 14.dp),
            text="Popular Courses",
            fontSize = 20.sp,
//            color = Color.White //2
        )
        Spacer(modifier = Modifier.height(15.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(1.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(categori){ Course->
                Courses(
                    Course, navController
                )
            }
        }
    }

}


@Composable
fun Courses(
    Cource: Course,
    navController: NavController,
){
//    2
//    OutlinedCard(
//        colors = CardDefaults.cardColors(containerColor = Color.White),
//        modifier = Modifier.fillMaxWidth()
//            .clickable(
//                onClick = {}
////                onClick = navController.navigate(
////                    Screen.CourseDetailPage.route + "/$CourseID"
////                )
//            ),
//        shape = RoundedCornerShape(15.dp)
//    )

//   1
    ElevatedCard(
        colors = CardDefaults.cardColors(containerColor = Color(0xff0d77f3)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 9.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
//                onClick = {}
                onClick = {
                    navController.navigate(
                        "course"+ "/${Cource.id}"

                    )
                }
            ),
        shape = RoundedCornerShape(15.dp)
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier.size(100.dp,100.dp)
                    .clip(RoundedCornerShape(5.dp))
            ){

                AsyncImage(
                    model = ImageRequest.Builder(context = LocalContext.current)
                        .data(Cource.poster)
                        .crossfade(true)
                        .build(),
                    error = painterResource(R.drawable.ic_broken_image),
                    placeholder = painterResource(R.drawable.loading_img),
                    contentScale = ContentScale.Crop,
                    contentDescription = null,
                    modifier = Modifier
                        .size(126.dp, 165.dp)
                        .clip(RoundedCornerShape(15.dp))

                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Column(modifier= Modifier.fillMaxWidth()) {
                Text(
                    text=Cource.name,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White //1

                )
                Text(
                    text = Cource.small_descr.toString(),
                    color = Color.White //1
                )
            }

        }
    }



    
}