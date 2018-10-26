package jp.ac.ibaraki.kotlinresponseproject

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_main_list.*

class MainActivity : AppCompatActivity(), RecyclerViewHolder.ItemClickListener {
    private val transaction = supportFragmentManager.beginTransaction()
    var count = 1
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> { //　リストを呼ぶ
                val mutableList = mutableListOf("a", "i", "u")
                var list: List<String> = mutableList
                mutableList.add("e")

                mainRecyclerView.adapter = RecyclerAdapter(this, this, list) // リストを入れる
                mainRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> { // 空のフラグメントを呼ぶ
                message.setText(R.string.title_dashboard)
                //transaction.remove(MainListFragment())
                transaction.replace(R.id.fragmentLayout, MainListFragment.getInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> { // フラグメントを呼ぶ
                message.setText(R.string.title_notifications)
                //transaction.remove(MainListFragment())
                transaction.replace(R.id.fragmentLayout, MainListFragment.createInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mutableList = mutableListOf("a", "i", "u")
        var list: List<String> = mutableList
        mutableList.add("e")

        mainRecyclerView.adapter = RecyclerAdapter(this, this, list) // リストを入れる

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        transaction.commit()
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(applicationContext, "position $position was tapped", Toast.LENGTH_SHORT).show()
    }

}
