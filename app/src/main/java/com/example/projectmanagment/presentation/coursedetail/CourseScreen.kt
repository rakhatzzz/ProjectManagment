package com.example.projectmanagment.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.projectmanagment.R
import com.example.projectmanagment.data.Course
import com.example.projectmanagment.presentation.home.ErrorScreen
import com.example.projectmanagment.presentation.home.LoadingScreen


@Composable
fun CourseScreen(
    CourseID: Int,
    modifier: Modifier,
    navController: NavController

){
    val courseViewModel: CourseViewModel = viewModel()
    val UiState = courseViewModel.uiState
    courseViewModel.id = CourseID

    Column(modifier = Modifier.fillMaxSize()){
        Row(
            modifier = Modifier.fillMaxWidth()
                .background(Color(0xff0d77f3))
        ) {
            IconButton(onClick = { navController.navigateUp()} ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = null,
                    tint = Color.White
                )

            }
        }
        Box(
            modifier = Modifier
                .fillMaxSize()

        ) {

            when (UiState) {
                is CourseUiState.Loading -> LoadingScreen(modifier = modifier.fillMaxSize())
                is CourseUiState.Success -> SuccessScreen(modifier = modifier.fillMaxSize(),
                    UiState.course)
//            is UiState.Success -> categories(UiState.categories,navController = navController)
                is CourseUiState.Error -> ErrorScreen(modifier = modifier.fillMaxSize())

                else -> {}
            }
        }
    }

}
@Composable
fun SuccessScreen(modifier: Modifier, course: Course) {



    LazyColumn(
        modifier = Modifier.fillMaxSize()
//            .background(Color.Black)
            .padding(15.dp)
    ) {
        item { Text(
            text = course.name,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
//            color = Color.White

        ) }

        item {
            AsyncImage(
                model = ImageRequest.Builder(context = LocalContext.current)
                    .data(course.poster)
                    .crossfade(true)
                    .build(),
                error = painterResource(R.drawable.ic_broken_image),
                placeholder = painterResource(R.drawable.loading_img),
                contentDescription = null,
                modifier = Modifier.fillMaxWidth()
                    .padding(vertical = 30.dp, horizontal = 10.dp),
                contentScale = ContentScale.FillWidth
//                modifier = Modifier
//                    .padding(vertical = 10.dp)
//                    .fillMaxWidth()
//                    .clip(RoundedCornerShape(10.dp))

            )

        }
        item {
            Text(
                modifier = Modifier.fillMaxSize(),
                text = course.description,
//                color = Color.White
            )
        }

    }

}
