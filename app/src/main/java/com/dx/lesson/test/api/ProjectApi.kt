package com.dx.lesson.test.api

import com.dx.baselib.net.bean.BaseResponse
import com.dx.lesson.test.bean.ProjectTree
import retrofit2.http.GET

/**
 * date: 2021/8/13
 * description:
 */
interface ProjectApi {
    @GET("project/tree/json")
    suspend fun loadProjectTree(): BaseResponse<List<ProjectTree>>


}