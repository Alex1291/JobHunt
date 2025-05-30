package com.example.jobseeker.component

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.jobseeker.model.NavigationItem

@Composable
fun BottomNavigationBar(
    items: List<NavigationItem>,
    currentRoute: String?,
    onClick: (NavigationItem) -> Unit,
) {
    NavigationBar(
//        containerColor= Color.Blue
    ) {
        items.forEachIndexed { index, navigationItem ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                ),
                selected = currentRoute == navigationItem.route,
                onClick = { onClick(navigationItem) },
                icon = {
                    BadgedBox(badge = {
                        if (navigationItem.badgeCount != null) {
                            if(navigationItem.badgeCount > 0 ){
                                Badge {
                                    Text(text = navigationItem.badgeCount.toString())
                                }
                            }else{

                            }
                        }
                    }) {
                        Icon(
                            imageVector = if (currentRoute == navigationItem.route) {
                                navigationItem.selectedIcon
                            } else {
                                navigationItem.unSelectedIcon
                            }, contentDescription = navigationItem.title
                        )
                    }
                }, label = {
                    Text(text = navigationItem.title)
                },
                alwaysShowLabel = true)
        }
    }
}