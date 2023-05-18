package cwaliimran.ext.kotlinextensions

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ext.logcat.LogHelper.logD

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        logD("")
    }
}