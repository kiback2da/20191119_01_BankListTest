package com.tjoeun.a20191119_01_banklisttest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tjoeun.a20191114_01_okhttp.utils.ServerUtil
import com.tjoeun.a20191119_01_banklisttest.adapter.DeliveryCompanyListAdapter
import com.tjoeun.a20191119_01_banklisttest.data.DeliveryCompanyData
import kotlinx.android.synthetic.main.activity_delivery_list.*
import org.json.JSONObject

class DeliveryListActivity : BaseActivity() {

    var deliveryList = ArrayList<DeliveryCompanyData>()
    var deliveryAdapter : DeliveryCompanyListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery_list)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        getRequestDeliveryList()

        deliveryAdapter = DeliveryCompanyListAdapter(mContext, deliveryList)
        deliveryListView.adapter = deliveryAdapter
    }

    fun getRequestDeliveryList(){
        ServerUtil.getRequestDeliveryListInfo(mContext,object : ServerUtil.jsonResponseHandler{
            override fun onResponse(json: JSONObject) {
                var code = json.getInt("code")

                if(code == 200){
                    var data = json.getJSONObject("data")
                    var dataArray = data.getJSONArray("company")

                    for(i in 0..dataArray.length()-1){
                        var deliveryData = DeliveryCompanyData.getDeliveryCompanyListFromServer(dataArray.getJSONObject(i))
                        deliveryList.add(deliveryData)
                    }

                    runOnUiThread {
                        deliveryAdapter?.notifyDataSetChanged()
                    }
                }

            }
        })
    }
}
