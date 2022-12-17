package com.example.custommenu.util

import com.example.custommenu.model.MenuItem

object MenuList {

    val MENU_LIST = mutableListOf(
        MenuItem(0, "Dashboard", false),
        MenuItem(1, "Favourite", true),
        MenuItem(2, "Setting", false)
    )
}
