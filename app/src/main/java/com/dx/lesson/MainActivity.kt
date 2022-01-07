package com.dx.lesson

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.animation.ValueAnimator
import android.annotation.SuppressLint
import android.os.Build
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.annotation.RequiresApi
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
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class MainActivity : KTBaseActivity<KTMainPresenter, TestConstract.View>(), TestConstract.View {
    override fun initPresenter(): KTMainPresenter = KTMainPresenter()
    private val mViewModel = ProjectModel()

    override fun layoutResId(): Int = R.layout.activity_main

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("WrongConstant")
    override fun initView() {
        super.initView()

        Glide.with(this)
            .load("https://saas-oss.mumway.com/auntsass/image/202108/61b7681aa759394d636042974d654363.png")
            .override(1090, 500)
            .into(image)



        mPresenter?.request(map = HashMap())

        //dsl
        edit.addTextChangedListener(customTextWatch {
            afterTextChanged {

            }
        })

        bt_bt.setOnClickListener {
            val objectAnimator1 = ObjectAnimator.ofFloat(view_avatar, "topFlip", -60f)
            val objectAnimator2 = ObjectAnimator.ofFloat(view_avatar, "bottomFlip", 60f)
            val objectAnimator3 = ObjectAnimator.ofFloat(view_avatar, "flipRotation", 270f)
//
//            objectAnimator.duration = 5000
//            objectAnimator.start()
            //动画顺序执行
//            val animatorSet = AnimatorSet()
//            animatorSet.playSequentially(objectAnimator1,objectAnimator2,objectAnimator3)
//            animatorSet.duration = 1000
//            animatorSet.start()

            //动画一起执行
            var topHolder = PropertyValuesHolder.ofFloat("topFlip", -60f)
            var topHolder1 = PropertyValuesHolder.ofFloat("bottomFlip", 60f)
            var topHolder2 = PropertyValuesHolder.ofFloat("flipRotation", 270f)

            var holderAnimator = ObjectAnimator.ofPropertyValuesHolder(view_avatar,topHolder,topHolder1,topHolder2)
            holderAnimator.duration = 1000
            holderAnimator.start()

        }


        val projectApi = NetWorkApi.INSTANCE.getApi(ProjectApi::class.java)


        //2021_1229_1247协程使用Retrofit
//        GlobalScope.launch {
//            withContext(Dispatchers.Main) {
//                var list = projectApi.getShitList()
//            }
//
//        }

        //源码阅读
//RetroFit TestCode
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

//源码阅读
//OkHttp TestCode
        val okHttpClient = OkHttpClient()
        val request = Request.Builder()
            .url("https://api.github.com/users/rengwuxian/repos")
            .build()

        okHttpClient.newCall(request).enqueue(object : okhttp3.Callback {
            override fun onFailure(call: okhttp3.Call, e: IOException) {

            }

            override fun onResponse(call: okhttp3.Call, response: okhttp3.Response) {
                println(response.code)
//                Toast.makeText(this@MainActivity, response.code.toString(), LENGTH_LONG).show()
            }
        })


//        mViewModel.projectTreeData.observe(this, { data ->
//
//            Log.i("wangly", "data = ${data.data}")
//
//        })


        mViewModel.projectTreeData.observeState(this, callback = {

            onSuccess {
                UILogUtil.d("dx", "$it")
            }

            onFail { i, s ->

                UILogUtil.e("dx", "$i")

            }

            onComplete {
                UILogUtil.e("dx", "onComplete")

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
