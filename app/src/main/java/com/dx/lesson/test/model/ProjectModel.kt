package com.dx.lesson.test.model

import com.dx.baselib.net.status.StateLiveData
import com.dx.lesson.test.bean.ProjectTree


class ProjectModel {

//    private val repo = ProjectRepo()
    val projectTreeData = StateLiveData<List<ProjectTree>>()
//
////    fun loadProjectTree() {
////        viewModelScope.launch {
////            repo.loadProjectTree(projectTreeData)
////        }
////    }
//
//
//    fun loadProjectTree2() {
//        viewModelScope.launch {
//            projectTreeData.value = repo.loadProjectTree()
//            repo.loadProjectTree2()
//        }
//    }


}