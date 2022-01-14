package com.dx.lesson

import android.animation.*
import android.annotation.SuppressLint
import android.graphics.Bitmap
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
import com.dx.lesson.test.view.ProvinceView
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

        view_avatar.setOnClickListener {
            Toast.makeText(this, "点击了", Toast.LENGTH_SHORT).show()
        }

        bt_bt.setOnClickListener {
            /**

            val objectAnimator1 = ObjectAnimator.ofFloat(view_avatar, "topFlip", -60f)
            val objectAnimator2 = ObjectAnimator.ofFloat(view_avatar, "bottomFlip", 60f)
            val objectAnimator3 = ObjectAnimator.ofFloat(view_avatar, "flipRotation", 270f)
            //
            //            objectAnimator.duration = 5000
            //            objectAnimator.start()
            //Set 对多个动画进行合成
            val animatorSet = AnimatorSet()
            animatorSet.playSequentially(objectAnimator1, objectAnimator2, objectAnimator3) //顺序播放
            //            animatorSet.playTogether(objectAnimator1,objectAnimator2,objectAnimator3)  //一起播放
            animatorSet.duration = 1000
            animatorSet.start()

             **/

            //动画一起执行
            val topHolder = PropertyValuesHolder.ofFloat("topFlip", -60f)
            val topHolder1 = PropertyValuesHolder.ofFloat("bottomFlip", 60f)
            val topHolder2 = PropertyValuesHolder.ofFloat("flipRotation", 270f)

            val holderAnimator = ObjectAnimator.ofPropertyValuesHolder(
                view_avatar,
                topHolder,
                topHolder1,
                topHolder2
            )
            holderAnimator.duration = 3000
            holderAnimator.start()


            //关键帧 KeyFrame
            /**
            //            val objectAnimator = ObjectAnimator.ofFloat(view_avatar, "topFlip", -60f)
            val keyFrame = Keyframe.ofFloat(0f, 0f)
            val keyFrame1 = Keyframe.ofFloat(0.2f, -(1.5 * 60).toFloat())
            val keyFrame2 = Keyframe.ofFloat(0.8f, -(0.6 * 60).toFloat())
            val keyFrame3 = Keyframe.ofFloat(1f, -60f)

            val propertyValuesHolder = PropertyValuesHolder.ofKeyframe(
            "topFlip",
            keyFrame,
            keyFrame1,
            keyFrame2,
            keyFrame3
            )
            val objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view_avatar,propertyValuesHolder)
            objectAnimator.startDelay = 1000
            objectAnimator.duration = 2000
            objectAnimator.start()
             **/

            //差值器/
            /**
            val animator = ObjectAnimator.ofFloat(view_avatar,"topFlip",-60f)
            //            animator.interpolator = DecelerateInterpolator()
            animator.startDelay = 1000
            animator.duration = 2000
            animator.start()
             **/

            //TypeEvaluator 估值器 - 计算器 对指定的类型属性计算每一刻(动画完成度)的属性值
            var argbEvaluator = ArgbEvaluator()

            //对文字使用估值器
//            val provinceEvaluator = ProvinceView.ProvinceEvaluator()
//            val animator =
//                ObjectAnimator.ofObject(material_edittext, "province", provinceEvaluator, "A", "ABC")
//            animator.startDelay = 1000
//            animator.duration = 5000
//            animator.start()
//
//            val bitmap:Bitmap = Bitmap.createBitmap(1,2,Bitmap.Config.ARGB_8888)


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
