package com.tjoeun.a20191119_01_banklisttest.data

import org.json.JSONObject

class DeliveryCompanyData {

    var id:Int = 0
    var name:String = ""
    var logo:String = ""

    companion object{
        fun getDeliveryCompanyListFromServer(json:JSONObject) : DeliveryCompanyData{
            var deliveryCompanyList = DeliveryCompanyData()

            deliveryCompanyList.id = json.getInt("id")
            deliveryCompanyList.name = json.getString("name")
            deliveryCompanyList.logo = json.getString("logo")

            return deliveryCompanyList
        }
    }

}