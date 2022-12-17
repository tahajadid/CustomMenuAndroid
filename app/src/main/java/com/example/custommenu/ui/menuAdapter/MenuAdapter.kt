package com.example.custommenu.ui.menuAdapter

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.custommenu.R
import com.example.custommenu.model.MenuItem

/**
 *class for Adapter list Archive
 */
class MenuAdapter(
    val context: Context?,
    private var listOfItems: List<MenuItem>,
    private val menuClickListener: MenuClickListener
) : RecyclerView.Adapter<MenuAdapter.ViewHolder>() {

    /**
     * Find all the views of the list item
     */
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        lateinit var title: TextView

        /**
         * Show the data in the views
         */
        @SuppressLint("ResourceAsColor")
        fun bindView(item: MenuItem, position: Int, menuClickListener: MenuClickListener) {
            title = itemView.findViewById(R.id.menu_title)
            title.text = item.nameItem

            if (item.isSelected) {
                title.setBackgroundResource(R.drawable.selected_bg)
                title.setTextColor(Color.parseColor("#FFFFFF"))
            } else {
                title.setBackgroundResource(R.drawable.unselected_bg)
                title.setTextColor(Color.parseColor("#FF018786"))
            }

            itemView.setOnClickListener {
                menuClickListener.onMenuChosen(position, item)
            }
        }
    }

    override fun getItemCount(): Int = listOfItems.size

    /**
     * Inside this method data will be displayed at the specified position
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listOfItems[position]
        holder.bindView(item, position, menuClickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View =
            LayoutInflater.from(context).inflate(R.layout.custom_menu_item, parent, false)
        return ViewHolder(itemView)
    }
}