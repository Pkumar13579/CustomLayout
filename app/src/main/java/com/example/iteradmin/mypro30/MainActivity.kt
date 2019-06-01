package com.example.iteradmin.mypro30

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.security.AccessControlContext

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview = findViewById<ListView>(R.id.listview)
        val avenger = arrayOf("ant man","hawkeye","black panther","black widow","captain america",
                "captain marvel","hulk","Iron man","spider man","thor")
        val real_name= arrayOf("Paul Rudd","barton","chandwick","scarlet","Chris Evans","brie larson"
                ,"Edward","robert","tom holland","Chris Hemsworth")
        val images = arrayOf(R.drawable.ant_man,R.drawable.barton,R.drawable.black_panther,R.drawable.black_widow,
                R.drawable.captain_america,R.drawable.captain_marvel,R.drawable.hulk,R.drawable.iron_man,
                R.drawable.spyder_man,R.drawable.thor)

        listview.adapter = MyAdapter(this,avenger,real_name,images)


    }
    class MyAdapter(context:Context,n:Array<String>,o:Array<String>,p:Array<Int>):BaseAdapter(){
        private val mContext:Context
        private val name:Array<String>
        private val real:Array<String>
        private val img:Array<Int>


        init {
            mContext = context
            name=n
            real=o
            img=p
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val layout:LayoutInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val rootview = layout.inflate(R.layout.item,null,true)

            val imv = rootview.findViewById<ImageView>(R.id.icon)
            val txt = rootview.findViewById<TextView>(R.id.title)
            val subtxt = rootview.findViewById<TextView>(R.id.subtitle)

            imv.setImageResource(img[position])
            txt.text = name[position]
            subtxt.text = real[position]
            return rootview
        }

        override fun getItem(position: Int): Any {
            return "anything"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
        return name.size
        }

    }
}
