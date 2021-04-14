package com.example.listview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.sinhvien_item.view.*

class SinhVienAdapter(var context:Context, var mangSinhVien:ArrayList<SinhVien>) : BaseAdapter() {


    class ViewHolder(row:View ){
        var avatar = row.hinhanhavatar
        var tenSinhVien = row.txtName
        var tuoiSinhVien = row.txtTuoi

    }

    override fun getCount(): Int {
        return mangSinhVien.size
    }

    override fun getItem(position: Int): Any {
        return mangSinhVien.get(position)
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder

        if (convertView == null){
            var layoutinflater: LayoutInflater = LayoutInflater.from(context)
            view = layoutinflater.inflate(R.layout.sinhvien_item, null)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = convertView.tag as ViewHolder

        }
        var sinhvien : SinhVien = getItem(position) as SinhVien

        Picasso.get().load(sinhvien.hinhanh).into(viewHolder.avatar)
        viewHolder.tenSinhVien.text = sinhvien.ten
        viewHolder.tuoiSinhVien.text = sinhvien.tuoi

        return view as View
    }
}