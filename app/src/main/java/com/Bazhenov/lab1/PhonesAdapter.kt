package com.Bazhenov.lab1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PhonesAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var mPhonesList: ArrayList<PhoneModel> = ArrayList()

    fun setupPhones(phonesList: ArrayList<PhoneModel>, from: Int, to: Int){
        mPhonesList.clear()
        //mPhonesList.addAll(phonesList)
        phonesList.forEach { item ->
            if (item.scope.toInt() in from..to)
                mPhonesList.add(item)
        }

        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.recyclerview_item, parent, false)
        return PhonesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is PhonesViewHolder){
            holder.bind(mPhones = mPhonesList[position])
        }
    }

    override fun getItemCount(): Int {
        return mPhonesList.count()
    }

    inner class PhonesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)  {

        fun bind(mPhones: PhoneModel){

            itemView.findViewById<TextView>(R.id.phone_name).text = mPhones.name
            itemView.findViewById<TextView>(R.id.lauch_price).text = mPhones.price
            itemView.findViewById<TextView>(R.id.lauch_date).text = mPhones.date
            itemView.findViewById<TextView>(R.id.camera_scope).text = mPhones.scope
        }
    }
}


