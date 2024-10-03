package com.example.cp2_rm551534

import FirstFragment
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, FirstFragment())
                .commit()
        }

        findViewById<Button>(R.id.button_open_second).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}
