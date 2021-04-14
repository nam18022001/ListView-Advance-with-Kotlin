package com.example.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.sinhvien_item.*
import kotlinx.android.synthetic.main.sinhvien_item.view.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var arraysv : ArrayList<SinhVien> = ArrayList()
        arraysv.add(SinhVien("https://media.travelmag.vn/files/thuannguyen/2020/04/25/cach-chup-anh-dep-tai-da-lat-1-2306.jpeg", "Nam", "21"))
        arraysv.add(SinhVien("https://i.pinimg.com/736x/81/12/29/8112296c722cbf2168857d8756743567.jpg", "Chức", "20"))
        arraysv.add(SinhVien("https://i.pinimg.com/564x/5f/ce/6a/5fce6ae6738a4722d8d2e8a3e2d9fdce.jpg", "Long", "20"))

        var adapter = SinhVienAdapter(this, arraysv)
        var inputAvatarImg = inputAvatar.text
        var inputName = inputTen.text
        var inputAGe = inputTuoi.text

        listView.adapter = SinhVienAdapter(this@MainActivity, arraysv)
        btnInsert.setOnClickListener {
            if (inputName.isEmpty() || inputAGe.isEmpty() || inputAvatarImg.isEmpty()){
                Toast.makeText(this@MainActivity, "Nhập đủ tất cả các trường pls", Toast.LENGTH_SHORT).show()
            }else{
                arraysv.add(SinhVien(inputAvatarImg.toString(), inputName.toString(), inputAGe.toString()))
                adapter.notifyDataSetChanged()
                listView.adapter = SinhVienAdapter(this@MainActivity, arraysv)
            }

        }
        listView.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->


            inputTen.setText("ahihi")
//            val selectedItem = parent.getItemAtPosition(position)


//            btnDetail.setOnClickListener {
//                Toast.makeText(this, "$selectedItem", Toast.LENGTH_SHORT).show()
//
//            }
        }
    }

}