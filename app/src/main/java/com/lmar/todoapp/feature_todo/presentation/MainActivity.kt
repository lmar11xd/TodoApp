package com.lmar.todoapp.feature_todo.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lmar.todoapp.feature_todo.presentation.todo_list.TodoListScreen
import com.lmar.todoapp.feature_todo.presentation.todo_list.TodoListViewModel
import com.lmar.todoapp.feature_todo.presentation.todo_new_update.TodoNewUpdateScreen
import com.lmar.todoapp.feature_todo.presentation.util.Screen
import com.lmar.todoapp.ui.theme.TodoAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    //https://www.youtube.com/watch?v=0wjnk62I01c&t=1s
    //4:57:22

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TodoAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    val navController = rememberNavController()
                    val listViewModel: TodoListViewModel = hiltViewModel()

                    NavHost(
                        navController = navController,
                        startDestination = Screen.TodoItemListScreen.route,
                    ){
                        composable(route = Screen.TodoItemListScreen.route){
                            TodoListScreen(
                                navController = navController,
                                viewModel = listViewModel
                            )
                        }
                        composable(
                            route = Screen.TodoNewUpdateScreen.route + "?todoId={todoId}",
                            arguments = listOf(
                                navArgument(
                                    name = "todoId"
                                ){
                                    type = NavType.IntType
                                    defaultValue = -1
                                }
                            )
                        ){
                            TodoNewUpdateScreen(
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}