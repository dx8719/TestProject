package com.dx.lesson.mvp

import com.dx.baselib.base.impl.ResultCallback
import com.dx.baselib.presenter.BasePresenter
import com.dx.lesson.contract.TestConstract

class KTMainPresenter : BasePresenter<TestConstract.View, TestConstract.Model>(), TestConstract.Presenter {

    override fun initModel(): TestConstract.Model? = KTMainModel()

    override fun request(map: HashMap<String, String>) {

        mModel?.requestList(object : ResultCallback<String> {
            override fun onSuccess(data: String) {
                mView?.showData(data)
            }

            override fun onFailed(errorCode: Int, errorMsg: String) {
                mView?.showEmpty()
            }
        })

    }
}