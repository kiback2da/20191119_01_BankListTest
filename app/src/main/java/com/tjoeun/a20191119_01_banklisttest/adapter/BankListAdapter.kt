package com.tjoeun.a20191119_01_banklisttest.adapter

import android.content.Context
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import com.tjoeun.a20191119_01_banklisttest.R
import com.tjoeun.a20191119_01_banklisttest.data.BankData

class BankListAdapter(context: Context, res:Int, list:ArrayList<BankData>) : ArrayAdapter<BankData>(context, res, list){

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null){
            tempRow = inf.inflate(R.layout.bank_list_item,null)
        }

        var row = tempRow!!
        var dataList = mList.get(position)
        var name = row.findViewById<TextView>(R.id.bankListTxtName)
        var img = row.findViewById<ImageView>(R.id.bankListImgMainImg)

        name.text = dataList.name
        Log.d("로그 : URI","${dataList.logoUrl}")
        img.setImageURI(dataList.logoUrl.toUri())


        return row
    }

    constructor(context: Context, list : ArrayList<BankData>) : this(context, R.layout.bank_list_item, list)
}