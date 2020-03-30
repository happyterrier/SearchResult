package com.ourincheon.searchresult

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<View>(R.id.listView) as ListView

        var fruitList = ArrayList<FruitItem>()
        var resultList = ArrayList<FruitItem>()
        fruitList.add(FruitItem("190906", "","",true,R.drawable.c))
        fruitList.add(FruitItem("190907", "","",true,R.drawable.h))
        fruitList.add(FruitItem("190831", "","",true,R.drawable.a))
        val adapter = FruitAdapter(fruitList)
        listView.adapter = adapter

        val btnListener=View.OnClickListener {
            if(editText2.text==null) {
                resultList.addAll(fruitList)

            }else{
                for (i in fruitList!!.indices) {

                    if (fruitList!![i].name.contains(editText2.text)) {
                        resultList!!.add(fruitList!![i])
                    }
                }

            }
            val adapter = FruitAdapter(resultList)
            listView.adapter = adapter

        }
        imageButton.setOnClickListener(btnListener)

    }

    inner class FruitAdapter(items: ArrayList<FruitItem>) : BaseAdapter() {
        val itemList : ArrayList<FruitItem>  = items
        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var fruitItemView : FruitItemView

            if (convertView != null) {
                fruitItemView = convertView as FruitItemView
            } else {
                fruitItemView = FruitItemView(applicationContext)
            }

            var item = itemList[position]
            fruitItemView.txtView.text = item.name
            fruitItemView.imgView.setImageResource(item.resId)
            return fruitItemView
        }
        override fun getItem(position: Int): Any {
            return itemList[position]
        }
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        override fun getCount(): Int {
            return itemList.size
        }
    }
}