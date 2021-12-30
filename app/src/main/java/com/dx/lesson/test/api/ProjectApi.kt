package com.dx.lesson.test.api

import com.dx.baselib.net.bean.BaseResponse
import com.dx.lesson.test.bean.ProjectTree
import com.dx.lesson.test.bean.Repo
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * date: 2021/8/13
 * description:
 */
interface ProjectApi {
    @GET("project/tree/json")
    suspend fun loadProjectTree(): BaseResponse<List<ProjectTree>>

    @GET("xxx/xxx/test")
    suspend fun getShitList(): List<String>

    @GET("users/{user}/repos")
    fun getGithub(@Path("user") user: String): Call<List<Repo>>


}