package com.damars.damardjati_submissiondicodingke1

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import de.hdodenhof.circleimageview.CircleImageView

class MainAdapterUser(private val context: Context, private val listUser : ArrayList<ForDataUser>) : BaseAdapter() {
    override fun getCount(): Int { return listUser.size }
    override fun getItem(thisposition : Int): Any { return listUser[thisposition]}
    override fun getItemId(thisposition: Int): Long { return thisposition.toLong() }

    @SuppressLint("InflateParams")
    override fun getView(position: Int, view: View?, viewgroup: ViewGroup?): View {
        var itemView = view
        if(itemView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            itemView = inflater.inflate(R.layout.list_user_card, null, true) }
        val forViewHolder = ViewHolder(itemView as View)
        val toUser = getItem(position) as ForDataUser
        forViewHolder.onbinding(toUser)
        return itemView
    }
    private inner class ViewHolder(view: View){
        private val tv_name: TextView = view.findViewById(R.id.tv_name)
        private val tv_company: TextView = view.findViewById(R.id.tv_company)
        private val tv_location: TextView = view.findViewById(R.id.tv_location)
        private val item_avatar_img: CircleImageView = view.findViewById(R.id.img_item_avatar)

        fun onbinding(toUser: ForDataUser) {
            tv_name.text = toUser.this_name
            tv_company.text = toUser.this_company
            toUser.avatar?.let{
                item_avatar_img.setImageResource(it)
            }
            tv_location.text = toUser.this_location
        }
    }
}