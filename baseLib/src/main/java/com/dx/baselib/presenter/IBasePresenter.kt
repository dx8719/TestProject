package com.dx.baselib.presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.dx.baselib.base.impl.IView

interface IBasePresenter<V: IView>: LifecycleObserver {

    fun onAttachView(view:V)

    fun onDetachView()


    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(owner: LifecycleOwner)
}