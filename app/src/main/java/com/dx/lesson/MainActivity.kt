package com.dx.lesson

import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.bumptech.glide.Glide
import com.dx.baselib.base.KTBaseActivity
import com.dx.baselib.utils.UILogUtil
import com.dx.lesson.contract.TestConstract
import com.dx.lesson.dsl.customTextWatch
import com.dx.lesson.mvp.KTMainPresenter
import com.dx.lesson.test.api.NetWorkApi
import com.dx.lesson.test.api.ProjectApi
import com.dx.lesson.test.bean.Repo
import com.dx.lesson.test.model.ProjectModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : KTBaseActivity<KTMainPresenter, TestConstract.View>(), TestConstract.View {
    override fun initPresenter(): KTMainPresenter = KTMainPresenter()
    private val mViewModel = ProjectModel()

    override fun layoutResId(): Int = R.layout.activity_main

    override fun initView() {
        super.initView()

        Glide.with(this)
            .load("https://saas-oss.mumway.com/auntsass/image/202108/61b7681aa759394d636042974d654363.png")
            .override(1090, 500)

            .into(image);



        mPresenter?.request(map = HashMap())

        //dsl
        edit.addTextChangedListener(customTextWatch {
            afterTextChanged {

            }
        })

        val projectApi = NetWorkApi.INSTANCE.getApi(ProjectApi::class.java)


        //2021_1229_1247协程使用Retrofit
//        GlobalScope.launch {
//            withContext(Dispatchers.Main) {
//                var list = projectApi.getShitList()
//            }
//
//        }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ProjectApi::class.java)
        val repo = service.getGithub("octocat")
        repo.enqueue(object : Callback<List<Repo>?> {
            override fun onResponse(call: Call<List<Repo>?>, response: Response<List<Repo>?>) {
                Toast.makeText(this@MainActivity, response.body()?.get(0)?.name, LENGTH_LONG).show()
            }

            override fun onFailure(call: Call<List<Repo>?>, t: Throwable) {

            }
        })

//        mViewModel.projectTreeData.observe(this, { data ->
//
//            Log.i("wangly", "data = ${data.data}")
//
//        })


        mViewModel.projectTreeData.observeState(this, callback = {

            onSuccess {
                UILogUtil.d("wangly", "$it")
            }

            onFail { i, s ->

                UILogUtil.e("wangly", "$i")

            }

            onComplete {
                UILogUtil.e("wangly", "onComplete")

            }

        })
    }

    override fun showData(data: String) {
        UILogUtil.d(message = "result: $data")

        GlobalScope.launch { withContext(Dispatchers.IO) { getSuspend() } }
    }

    override fun showEmpty() {
        UILogUtil.d(message = "showEmpty: ")

        GlobalScope.launch {
            withContext(Dispatchers.Main) {
                ioFun()
                uiFun()
            }

        }
        //创建scope 结构化并发 批量管理协程
        val scope = MainScope() //主线程
        scope.launch {

        }
        //cancel掉
        scope.cancel()


        //Android 对协程的支持 - lifeCycleScope
//        lifeCycleScope.Launch ......


//        var orderDetailBean = OrderDetailBean()
    }

    suspend fun ioFun() {
        withContext(Dispatchers.IO) {
            //do some thing
//            do {
//                Toast.makeText()
//            }
        }
    }

    fun uiFun() {

    }


    fun onReqData(view: View) {
//        mViewModel.loadProjectTree2()

    }


    suspend fun getSuspend() {
        withContext(Dispatchers.IO) {
        }
    }


    suspend fun getUser() {
        withContext(Dispatchers.IO) {
            delay(90)
        }

        return
    }
}
