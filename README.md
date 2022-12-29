# CustomMenuAndroid

This project implement the idea of setting a custom menu where Burger Menu that can be hidden in the Fragment without any impact of the Navigation of the App.

## Screenshots

In this Main Fragment (DashBoardFragment) we hide the icon of burger menu and we don't impact the backStack of the Fragments Navigation 

<img src="https://github.com/tahajadid/CustomMenuAndroid/blob/develop/demo/dashboard_screen.png" width="150" height="280"/>

In the other Fragments we need to show the icon of Burger Menu and just modify the MENU_LIST with the following function

```groovy
/**
* function that change the selected item on the Menu
*/    
private fun changeIndexOfMenu() {
  MenuList.MENU_LIST.forEach {
    if (it.indexItem.equals(2)) it.isSelected = true
    else it.isSelected = false
  }
}
```
<img src="https://github.com/tahajadid/CustomMenuAndroid/blob/develop/demo/favourite_screen.png.png" width="150" height="280"/>
<img src="https://github.com/tahajadid/CustomMenuAndroid/blob/develop/demo/menu_screen.png.png" width="150" height="280"/>
