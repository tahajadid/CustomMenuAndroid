package com.example.custommenu

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation

class MainActivity : AppCompatActivity() {

    lateinit var menuIcon: ImageView
    lateinit var leftMenuView: View

    lateinit var menuLayout: ConstraintLayout
    var menuIsHidden = true

    private lateinit var navController: NavController

    companion object {
        lateinit var activityInstance: MainActivity
        var currentDestinationId: Int = 0

        /**
         * Return initialization state of the instance
         * onCreate
         */
        fun activityIsInitialized() = ::activityInstance.isInitialized
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main)

        activityInstance = this

        navController.addOnDestinationChangedListener { _, destination, _ ->
            currentDestinationId = destination.id
        }

        initCoponents()
    }

    private fun initCoponents() {
        menuIcon = findViewById(R.id.menu_icon)
        menuLayout = findViewById(R.id.menu_layout)
        leftMenuView = findViewById(R.id.left_menu_bg)

        menuIcon.setOnClickListener {
            if (menuIsHidden) showMenu()
            else hideMenu()
        }

        leftMenuView.setOnClickListener {
            hideMenu()
        }
    }

    fun hideMenu() {
        menuLayout.visibility = View.GONE
    }

    fun showMenu() {
        menuLayout.visibility = View.VISIBLE
    }
}
