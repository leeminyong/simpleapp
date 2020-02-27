package com.example.admin.kotlinlistexample

import android.graphics.Color

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aiden.andmodule.R
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_main.view.*


open class MainRecyclerAdapter: RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>() {
    private var datas: ArrayList<DummyData>? = null
    var clickListener: OnClickListener? = null
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.item_main_text.text = datas?.get(position)?.title?:"null"
        if(datas?.get(position)?.isSelect == true){
            holder.itemView.setBackgroundColor(Color.GRAY)
        }else{
            holder.itemView.setBackgroundColor(Color.WHITE)
        }
        holder.itemView.setOnClickListener { v ->
            datas?.get(position)?.isSelect = !(datas?.get(position)?.isSelect?:false)
            if(datas?.get(position)?.isSelect == true){
                holder.itemView.setBackgroundColor(Color.GRAY)
            }else{
                holder.itemView.setBackgroundColor(Color.WHITE)
            }

            clickListener?.onClick(position)
        }
        Glide.with(holder.itemView.context).load("http://www.reactiongifs.com/r/hsk.gif").into(holder.itemView.item_main_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_main,parent,false))
    }

    override fun getItemCount(): Int = datas?.size?:0

    fun setOnClickListener(listener: (Int) -> Unit){
        this.clickListener = object: OnClickListener{
            override fun onClick(position: Int) {
                listener(position)
            }
        }
    }
    fun addData(datas :ArrayList<DummyData>){
        this.datas = datas
        notifyDataSetChanged()
    }
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    interface OnClickListener{
        fun onClick(position: Int)
    }
}
