package com.tjoeun.a20191119_01_banklisttest.data

import org.json.JSONObject


class BankData() {
    var id:Int = 0
    var code:String=""
    var name:String=""
    var logoUrl:String=""

    companion object{
        fun getBankFromJsonObject(json:JSONObject) : BankData{
            val bank = BankData()

            bank.id = json.getInt("id")
            bank.code = json.getString("code")
            bank.name = json.getString("name")
            bank.logoUrl = json.getString("logo")

            return bank
        }
    }
}