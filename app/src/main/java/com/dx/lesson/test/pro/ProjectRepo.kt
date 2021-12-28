package com.dx.lesson.test.pro

import com.dx.baselib.mvvm.rep.BaseRepository
import com.dx.baselib.net.bean.BaseResponse
import com.dx.baselib.utils.UILogUtil
import com.dx.lesson.test.api.NetWorkApi
import com.dx.lesson.test.api.ProjectApi
import com.dx.lesson.test.bean.ProjectTree

/**
 * date: 2021/8/13
 * description:
 */
class ProjectRepo : BaseRepository() {
    private var mService: ProjectApi =
        NetWorkApi.INSTANCE.getApi(ProjectApi::class.java)
    private var mService1: ProjectApi =
        NetWorkApi.INSTANCE.getApi(ProjectApi::class.java)
    suspend fun loadProjectTree(): BaseResponse<List<ProjectTree>> {
        UILogUtil.i("wangly","loadProjectTree instance = ${mService}")

        return executeReq { mService.loadProjectTree() }
    }

    suspend fun loadProjectTree2(): BaseResponse<List<ProjectTree>> {
        UILogUtil.i("wangly","loadProjectTree2 instance = ${mService}")

        return executeReq { mService1.loadProjectTree() }
    }


}