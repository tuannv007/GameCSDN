package tuannv007.com.gamecsdn.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import tuannv007.com.gamecsdn.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mainFragment = MainFragment()
        supportFragmentManager.beginTransaction().replace(R.id.main_activity, mainFragment).commit()
    }
}
