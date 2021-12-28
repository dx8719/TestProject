package com.dx.lesson.mvp

import com.dx.baselib.base.impl.ResultCallback
import com.dx.baselib.model.BaseModel
import com.dx.lesson.contract.TestConstract

class KTMainModel : BaseModel(),TestConstract.Model{
    override fun requestList(callback: ResultCallback<String>) {
        callback.onSuccess("测时")
    }
}