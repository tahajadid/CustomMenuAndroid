package com.example.custommenu.ui.menuAdapter

import com.example.custommenu.model.MenuItem

interface MenuClickListener {
    fun onMenuChosen(index: Int, menuItem: MenuItem)
}
