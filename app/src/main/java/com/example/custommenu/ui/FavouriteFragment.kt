package com.example.custommenu.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.custommenu.MainActivity
import com.example.custommenu.R
import com.example.custommenu.util.MenuList

class FavouriteFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        MainActivity.activityInstance.menuIcon.visibility = View.VISIBLE

        changeIndexOfMenu()

        return inflater.inflate(R.layout.fragment_favourite, container, false)
    }

    /**
     * function that change the selected tem on the Menu
     */
    private fun changeIndexOfMenu() {
        MenuList.MENU_LIST.forEach {
            if (it.indexItem.equals(1)) it.isSelected = true
            else it.isSelected = false
        }
    }
}
