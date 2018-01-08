package tuannv007.com.gamecsdn.main

import android.annotation.SuppressLint
import android.os.AsyncTask
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import tuannv007.com.gamecsdn.model.Item

/**
 * Created by Adminis on 1/8/2018.
 */
class MainPresenter(var view: MainView.View) : MainView.Presenter {
    private val itemList: ArrayList<Item> = ArrayList()
    override fun getVideo(url: String) {
        LoadImageTask().execute(url)
    }

    fun getDataFromGameTV(url: String?) {
        val document: Document = Jsoup.connect(url).get() as Document
        val sub = document.select("figure.video")
        for (e in sub) {
            val titleSubject = e.getElementsByTag("a").first()
            val imgSubject = e.getElementsByTag("img").first()
            if (imgSubject != null || titleSubject != null) {
                val src = imgSubject.attr("src")
                val alt = imgSubject.attr("alt")
                val title = titleSubject.attr("href")
                itemList.add(Item(src, alt, title))
            }

        }

    }

    @SuppressLint("StaticFieldLeak")
    inner class LoadImageTask : AsyncTask<String, Void, ArrayList<Item>>() {
        override fun doInBackground(vararg p0: String?): ArrayList<Item>? {
            getDataFromGameTV(p0[0])
            return get()
        }


        override fun onPostExecute(result: ArrayList<Item>?) {
            super.onPostExecute(result)
            view.updateAdapter(result!!)
        }

    }
}