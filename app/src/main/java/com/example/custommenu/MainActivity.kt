package com.example.custommenu

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var menuIcon: ImageView
    lateinit var mainFragment: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initCoponents()
    }

    private fun initCoponents() {
        menuIcon = findViewById(R.id.menu_icon)
        mainFragment = findViewById(R.id.main_fragment)
    }
}
