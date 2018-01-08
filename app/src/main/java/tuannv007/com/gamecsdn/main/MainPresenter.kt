package tuannv007.com.gamecsdn.main

import android.annotation.SuppressLint
import android.os.AsyncTask
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import tuannv007.com.gamecsdn.model.Item

/**
 * Created by Adminis on 1/8/2018.
 */
class MainPresenter(val fagment: MainFragment) : MainView.Presenter {
    private var url: String = ""
    override fun getVideo(url: String) {
        this.url = url
        LoadImageTask().execute()
    }

    fun testData(list: ArrayList<Item>): ArrayList<Item> {
        var document: Document = Jsoup.connect(url).get() as Document
        val sub = document.select("figure.video")
        for (e in sub) {
            val titleSubject = e.getElementsByTag("a").first()
            val imgSubject = e.getElementsByTag("img").first()
            if (imgSubject != null || titleSubject != null) {
                val src = imgSubject.attr("src")
                val alt = imgSubject.attr("alt")
                val title = titleSubject.attr("href")
                list.add(Item(src, alt, title))
            }

        }
        return list
    }

    @SuppressLint("StaticFieldLeak")
    inner class LoadImageTask : AsyncTask<Void, Void, ArrayList<Item>>() {
        override fun doInBackground(vararg p0: Void?): ArrayList<Item>? {
            val listData: ArrayList<Item> = ArrayList()
            return testData(listData)
        }

        override fun onPostExecute(result: ArrayList<Item>?) {
            super.onPostExecute(result)
            fagment.updateAdapter(result)
        }

    }
}