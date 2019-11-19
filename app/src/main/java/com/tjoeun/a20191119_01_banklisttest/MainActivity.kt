package com.tjoeun.a20191119_01_banklisttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tjoeun.a20191114_01_okhttp.utils.ServerUtil
import com.tjoeun.a20191119_01_banklisttest.adapter.BankListAdapter
import com.tjoeun.a20191119_01_banklisttest.data.BankData
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class MainActivity : BaseActivity() {

    var bankList = ArrayList<BankData>()
    var bankAdapter : BankListAdapter? = null
    var BASE_URL = "http://192.168.0.26:5000"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

    }

    fun getBanksFromServer(){
        var client = OkHttpClient()
        var urlBuilder = HttpUrl.parse("${BASE_URL}/info/bank")!!.newBuilder()

        //URL 최종 확정
        var requestUrl = urlBuilder.build().toString()

        var request = Request.Builder().url(requestUrl).build()

        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                Log.e("로그 : 서버통신에러",e.localizedMessage)
            }

            override fun onResponse(call: Call, response: Response) {
                Log.e("로그 : onResponse",response.toString())
                val json = JSONObject(response.body().toString())
                handler?.onResponse(json)
            }

        })
    }
}
