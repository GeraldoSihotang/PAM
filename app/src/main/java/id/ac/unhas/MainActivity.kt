package id.ac.unhas.mem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import id.ac.unhas.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, ListFragment())
                .commit()
        }
    }
}