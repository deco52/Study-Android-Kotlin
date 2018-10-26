package jp.ac.ibaraki.kotlinresponseproject

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

/**
 * RecyclerViewにはOnItemClickイベントがセットできない？のでここで作る
 */
class RecyclerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    interface ItemClickListener {
        fun onItemClick(view: View, position: Int)
    }

    val itemTextVIew: TextView = view.findViewById(R.id.itemTextView)

    init {
        // 初期設定
    }
}