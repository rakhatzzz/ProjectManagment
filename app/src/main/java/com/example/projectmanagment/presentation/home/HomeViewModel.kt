package com.example.projectmanagment.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectmanagment.data.Course
import com.example.projectmanagment.network.EduPwlApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface UiState {
    data class Success(val categori: List<Course>) : UiState
    object Error : UiState
    object Loading : UiState
}

class HomeViewModel : ViewModel() {
    var uiState: UiState by mutableStateOf(UiState.Loading)
        private set
    init {
        getCategori()
    }

    fun getCategori() {
        viewModelScope.launch {
            uiState = UiState.Loading
            uiState = try {
                UiState.Success(
                    categori =
                        coulis
//                        EduPwlApi.retrofitService.getListCourses("TOP_POPULAR")


                )
            } catch (_: IOException) {
                UiState.Error
            } catch (_: HttpException) {
                UiState.Error
            }
        }
    }
}


val coulis = listOf(
    Course(
        1,"Linear function",
        "A linear function is a function whose graph is a straight line",
        "https://upload.wikimedia.org/wikipedia/commons/thumb/0/0e/Linear_Function_Graph.svg/330px-Linear_Function_Graph.svg.png",
        ""
    ),
    Course(
        2,"Quadratic function",
        "A quadratic function is a polynomial function with one or more variables... ",
        "https://upload.wikimedia.org/wikipedia/commons/1/14/Polynomialdeg2.png",
        ""
    )
)
