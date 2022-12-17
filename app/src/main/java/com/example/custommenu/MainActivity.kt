package com.example.custommenu

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.custommenu.model.MenuItem
import com.example.custommenu.ui.menuAdapter.MenuAdapter
import com.example.custommenu.ui.menuAdapter.MenuClickListener
import com.example.custommenu.util.MenuList.MENU_LIST
import com.example.spicyanimation.SpicyAnimation

class MainActivity : AppCompatActivity(), MenuClickListener {

    lateinit var menuIcon: ImageView
    lateinit var leftMenuView: View
    lateinit var listMenu: RecyclerView
    private lateinit var menuAdapter: MenuAdapter

    lateinit var menuLayout: ConstraintLayout

    private lateinit var navController: NavController

    companion object {
        lateinit var activityInstance: MainActivity
        var currentDestinationId: Int = 0
        var menuIsHidden = true

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
        listMenu = findViewById(R.id.menu_list)

        menuAdapter = MenuAdapter(applicationContext, MENU_LIST, this)

        listMenu.apply {
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = menuAdapter
        }

        menuIcon.setOnClickListener {
            showMenu()
            menuIsHidden = false
        }

        leftMenuView.setOnClickListener {
            hideMenu()
        }
    }

    fun hideMenu() {
        menuIsHidden = true
        menuIcon.isEnabled = true
        menuLayout.visibility = View.GONE
    }

    fun showMenu() {
        menuLayout.visibility = View.VISIBLE
        menuIcon.isEnabled = false
        SpicyAnimation().fadeToRight(menuLayout, 50F, 300)
    }

    override fun onMenuChosen(index: Int, menuItem: MenuItem) {
        MENU_LIST.forEach {
            hideMenu()
            if (it.indexItem.equals(index)) it.isSelected = true
            else it.isSelected = false
            Log.d("TEstApp", "index = " + index)
            Log.d("TEstApp", "selection = " + it.isSelected)
        }
        menuAdapter.notifyDataSetChanged()
        navigateToDestination(index)
    }

    fun navigateToDestination(index: Int){
        when(index){
            0 -> navController.navigate(R.id.dashboardFragment)
            1 -> navController.navigate(R.id.favouriteFragment)
            2 -> navController.navigate(R.id.settingFragment)
        }
    }

}
