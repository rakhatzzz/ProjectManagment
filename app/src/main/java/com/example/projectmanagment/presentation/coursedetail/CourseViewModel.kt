package com.example.projectmanagment.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectmanagment.data.Course
import com.example.projectmanagment.network.EduPwlApi
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException


sealed interface CourseUiState {
    data class Success(val course: Course) : CourseUiState
    object Error : CourseUiState
    object Loading : CourseUiState
}

class CourseViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    var id: Int = savedStateHandle["CourseID"] ?: 1
    var uiState: CourseUiState by mutableStateOf(CourseUiState.Loading)
        private set
    init {
        getCourse()
    }

    fun getCourse() {
        viewModelScope.launch {
            uiState = CourseUiState.Loading
            uiState = try {
                CourseUiState.Success(
                    course =
                        coulis[id-1]
//                        EduPwlApi.retrofitService.getCourse(id = id)
                )
            } catch (_: IOException) {
                CourseUiState.Error
            } catch (_: HttpException) {
                CourseUiState.Error
            }
        }
    }
}



