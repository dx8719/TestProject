package com.dx.lesson.contract

import com.dx.baselib.presenter.IBasePresenter
import com.dx.baselib.model.IModel
import com.dx.baselib.base.impl.IView

interface CommonContract {

    interface View: IView {

    }

    interface Presenter<V:View>: IBasePresenter<V> {

    }

    interface Model: IModel {

    }
}