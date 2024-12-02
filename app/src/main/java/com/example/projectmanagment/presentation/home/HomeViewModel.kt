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
        "A linear function is a function that represents a straight line on the coordinate plane. For example, y = 3x - 2 represents a straight line on a coordinate plane and hence it represents a linear function. Since y can be replaced with f(x), this function can be written as f(x) = 3x - 2.\n" +
                "\n" +
                "In this article, we are going to learn the definition of a linear function along with its graph, domain, and range. We will also learn how to identify a linear function and how to find its inverse.\n" +
                "\n" +
                "What is a Linear Function?\n" +
                "A linear function is of the form f(x) = mx + b where 'm' and 'b' are real numbers. Isn't it looking like the slope-intercept form of a line which is expressed as y = mx + b? Yes, this is because a linear function represents a line, i.e., its graph is a line. Here,\n" +
                "\n" +
                "'m' is the slope of the line\n" +
                "'b' is the y-intercept of the line\n" +
                "'x' is the independent variable\n" +
                "'y' (or f(x)) is the dependent variable\n" +
                "Linear Function Equation\n" +
                "The parent linear function is f(x) = x, which is a line passing through the origin. In general, a linear function equation is f(x) = mx + b and here are some examples.\n" +
                "\n" +
                "f(x) = 3x - 2\n" +
                "f(x) = -5x - 0.5\n" +
                "f(x) = 3\n" + "\n" +
                "Real Life Example of Linear Function\n" +
                "Here are some real-life applications of the linear function.\n" +
                "\n" +
                "A movie streaming service charges a monthly fee of \$4.50 and an additional fee of \$0.35 for every movie downloaded. Now, the total monthly fee is represented by the linear function f(x) = 0.35x + 4.50, where x is the number of movies downloaded in a month.\n" +
                "A t-shirt company charges a one-time fee of \$50 and \$7 per T-shirt to print logos on T-shirts. So, the total fee is expressed by the linear function f(x) = 7x + 50, where x is the number of t-shirts.\n" +
                "The linear function is used to represent an objective function in linear programming problems, to help minimize the close, or maximize the profits.\n" +
                "How to Find a Linear Function?\n" +
                "We use the slope-intercept form or the point-slope form to find a linear function. The process of finding a linear function is the same as the process of finding the equation of a line and is explained with an example.\n" +
                "\n" +
                "Example: Find the linear function that has two points (-1, 15) and (2, 27) on it.\n" +
                "\n" +
                "Solution:\n" +
                "\n" +
                "The given points are (x1, y1) = (-1, 15) and (x₂, y₂) = (2, 27).\n" +
                "\n" +
                "Step 1: Find the slope of the function using the slope formula:\n" +
                "\n" +
                "m = (y₂ - y1) / (x₂ - x1) = (27 - 15) / (2 - (-1)) = 12/3 = 4.\n" +
                "\n" +
                "Step 2: Find the equation of linear function using the point slope form.\n" +
                "\n" +
                "y - y1 = m (x - x1)\n" +
                "\n" +
                "y - 15 = 4 (x - (-1))\n" +
                "\n" +
                "y - 15 = 4 (x + 1)\n" +
                "\n" +
                "y - 15 = 4x + 4\n" +
                "\n" +
                "y = 4x + 19\n" +
                "\n" +
                "Therefore, the equation of the linear function is, f(x) = 4x + 19."

    ),
    Course(
        2,"Quadratic function",
        "A quadratic function is a polynomial function with one or more variables... ",
        "https://upload.wikimedia.org/wikipedia/commons/1/14/Polynomialdeg2.png",
        ""
    )
)
