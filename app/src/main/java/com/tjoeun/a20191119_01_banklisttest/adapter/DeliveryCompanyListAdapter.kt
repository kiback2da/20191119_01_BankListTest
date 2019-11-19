package com.tjoeun.a20191119_01_banklisttest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.tjoeun.a20191119_01_banklisttest.R
import com.tjoeun.a20191119_01_banklisttest.data.DeliveryCompanyData

class DeliveryCompanyListAdapter(context: Context, res:Int, list:ArrayList<DeliveryCompanyData>) : ArrayAdapter<DeliveryCompanyData>(context, res, list){

    var mContext = context
    var mList = list
    var inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        if(tempRow == null){
            tempRow = inf.inflate(R.layout.delivery_list_item,null)
        }

        var row = tempRow!!
        var dataList = mList.get(position)
        var name = row.findViewById<TextView>(R.id.deliveryListTxtName)
        var img = row.findViewById<ImageView>(R.id.deliveryListImgMainImg)

        name.text = dataList.name
        Glide.with(mContext).load(dataList.logo).into(img)

        return row
    }

    constructor(context: Context, list:ArrayList<DeliveryCompanyData>):this(context, R.layout.bank_list_item, list)
}