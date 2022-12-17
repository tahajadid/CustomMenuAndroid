package com.example.custommenu.util

import com.example.custommenu.model.MenuItem

object MenuList {

    val MENU_LIST = mutableListOf(
        MenuItem(0, "Dashboard", true),
        MenuItem(1, "Favourite", false),
        MenuItem(2, "Profile", false),
        MenuItem(3, "Setting", false)
    )
}
