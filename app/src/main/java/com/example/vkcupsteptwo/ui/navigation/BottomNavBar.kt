package com.example.vkcupsteptwo.ui.navigation

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.clipRect
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.vkcupsteptwo.ui.theme.BottomNavColor
import com.example.vkcupsteptwo.ui.theme.SelectedNavItemColor
import com.example.vkcupsteptwo.ui.theme.UnSelectedNavItemColor
import com.example.vkcupsteptwo.ui.theme.roboto

@SuppressLint("SuspiciousIndentation")
@Composable
fun BottomNavBar(
    items:List<BottomNavItem>,
    navController: NavController,
    onClick: (BottomNavItem) -> Unit
) {

    val backStackEntry = navController.currentBackStackEntryAsState()

        BottomNavigation(
            backgroundColor = BottomNavColor,
            modifier = Modifier.height(65.dp)
        ) {
            items.forEach { item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                Log.d("destination","${item.route} ${backStackEntry.value?.destination?.route}")
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onClick(item)},
                    selectedContentColor = SelectedNavItemColor,
                    unselectedContentColor = UnSelectedNavItemColor,
                    icon = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(painterResource(id = item.icon), contentDescription = "")
                            Text(
                                text = item.name,
                                fontSize = 10.sp,
                                color = if(selected) SelectedNavItemColor else UnSelectedNavItemColor,
                                fontFamily = roboto,
                                fontWeight = FontWeight.Medium
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                        }
                    }
                )
            }
        }


}