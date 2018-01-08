package tuannv007.com.gamecsdn.main

import tuannv007.com.gamecsdn.model.Item

/**
 * Created by Adminis on 1/8/2018.
 */
interface MainView {
    interface View {
        fun updateAdapter(list: ArrayList<Item>)
    }

    interface Presenter {
        fun getVideo(url: String)
    }
}