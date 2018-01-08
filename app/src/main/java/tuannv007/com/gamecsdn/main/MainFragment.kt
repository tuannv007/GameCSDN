package tuannv007.com.gamecsdn.main


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_main.*

import tuannv007.com.gamecsdn.R
import tuannv007.com.gamecsdn.base.BaseAdapter
import tuannv007.com.gamecsdn.model.Item


/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), MainView.View {
    private var url: String = "http://gametv.vn/tag/chim-se-di-nang"
    private var presenter: MainView.Presenter = MainPresenter(this)
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        presenter.getVideo(url)
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun updateAdapter(list: ArrayList<Item>) {
        val myAdapter = VideoAdapter(list)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = myAdapter
        myAdapter.setOnClickListener(object : BaseAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Log.e("Ta", list[position].toString())
            }
        })
    }

}
