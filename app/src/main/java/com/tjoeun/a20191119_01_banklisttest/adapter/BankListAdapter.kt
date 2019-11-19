package com.tjoeun.a20191119_01_banklisttest.adapter

import android.content.Context
import android.widget.ArrayAdapter
import com.tjoeun.a20191119_01_banklisttest.data.BankData

class BankListAdapter(context: Context, res:Int, list:ArrayList<BankData>) : ArrayAdapter<BankData>(context, res, list){
}