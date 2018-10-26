package jp.ac.ibaraki.kotlinresponseproject

import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_main_list.*

class MainListFragment : Fragment(), RecyclerViewHolder.ItemClickListener {

    companion object {
        fun getInstance(): MainListFragment {
            return MainListFragment()
        }

        fun createInstance(): MainListFragment {
            val mainListFragment = MainListFragment()
            val args = Bundle()
            return mainListFragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.fragment_main_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val mutableList = mutableListOf("a", "i", "u")
        var list: List<String> = mutableList
        mutableList.add("e")
        fragmentRecyclerView.adapter = RecyclerAdapter(view.context, this, list) // リストを入れる
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onItemClick(view: View, position: Int) {
        Toast.makeText(view.context, "position $position was tapped", Toast.LENGTH_SHORT).show()
    }
}