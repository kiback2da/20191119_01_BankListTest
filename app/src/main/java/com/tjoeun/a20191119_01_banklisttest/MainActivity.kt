package com.tjoeun.a20191119_01_banklisttest

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tjoeun.a20191114_01_okhttp.utils.ServerUtil
import com.tjoeun.a20191119_01_banklisttest.adapter.BankListAdapter
import com.tjoeun.a20191119_01_banklisttest.data.BankData
import kotlinx.android.synthetic.main.activity_main.*
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
        bankAdapter = BankListAdapter(mContext,bankList)
        mainBankListView.adapter = bankAdapter
    }

    fun getBanksFromServer(){
        ServerUtil.getRequestBankInfo(mContext,object : ServerUtil.jsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                Log.d("로그 : getBank","getBank")
                var code = json.getInt("code")

                if(code == 200){
                    val data = json.getJSONObject("data")
                    val bankArray = data.getJSONArray("banks")

                    for(i in 0..bankArray.length()-1){
                        val bankDetail = bankArray.getJSONObject(i)
                        val bankDetailData = BankData.getBankFromJsonObject(bankDetail)
                        bankList.add(bankDetailData)
                    }

                }else{
                    Toast.makeText(mContext,"서버 통신에 문제가 있습니다.",Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}
