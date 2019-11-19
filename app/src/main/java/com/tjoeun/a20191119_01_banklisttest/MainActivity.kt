package com.tjoeun.a20191119_01_banklisttest

import android.os.Bundle
import android.util.Log
import com.tjoeun.a20191114_01_okhttp.utils.ServerUtil
import com.tjoeun.a20191119_01_banklisttest.adapter.BankListAdapter
import com.tjoeun.a20191119_01_banklisttest.data.BankData
import org.json.JSONObject

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
        getBanksFromServer()
    }

    fun getBanksFromServer(){
        ServerUtil.getRequestBankInfo(mContext,object : ServerUtil.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {

                var data = json.getJSONObject("data")
                var bankArray = data.getJSONArray("banks")
                Log.d("로그 : bankArray","${bankArray.length()}")

            }

        })
    }
}
