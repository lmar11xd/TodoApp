package com.lmar.todoapp.feature_todo.data.remote

import com.google.gson.Gson
import com.lmar.todoapp.feature_todo.data.remote.dto.RemoteTodoItem
import dagger.Provides
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query
import retrofit2.http.Url
import javax.inject.Singleton

interface TodoApi {

    @Provides
    fun providesRetrofitApi(retrofit: Retrofit): TodoApi {
        return retrofit.create(TodoApi::class.java)
    }

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://todoapp-7a9dd-default-rtdb.firebaseio.com/")
            .build()
    }

    @GET("todo.json")
    suspend fun getAllTodos(): List<RemoteTodoItem>

    @GET("todo.json?orderBy=\"ID\"")
    suspend fun getSingleTodoById(@Query("equalTo") id: Int?): Map<String, RemoteTodoItem>

    //@POST("todo.json")
    //suspend fun addTodo(@Body url: String, @Body updatedTodo: RemoteTodoItem): Response<Unit>

    @PUT
    suspend fun addTodo(@Url url: String, @Body updatedTodo: RemoteTodoItem): Response<Unit>

    @DELETE("todo/{id}.json")
    suspend fun deleteTodo(@Path("id") id: Int?): Response<Unit>

    @PUT("todo/{id}.json")
    suspend fun updatedTodoItem(@Path("id") id: Int?, @Body todoItem: RemoteTodoItem): Response<Unit>
}