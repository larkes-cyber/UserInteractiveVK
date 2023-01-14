package com.example.vkcupsteptwo.ui.screen.compare_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vkcupsteptwo.ui.component.TitleHeaderComponent
import com.example.vkcupsteptwo.ui.screen.compare_screen.component.CompareFormComponent
import com.example.vkcupsteptwo.ui.theme.BackgroundColor
import com.example.vkcupsteptwo.ui.theme.SelectedNavItemColor

@Composable
fun CompareScreen() {

    val viewModel = viewModel<CompareViewModel>()
    val state = viewModel.state



    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColor)
    ){
        item {
            TitleHeaderComponent("Сопоставление")
        }

        items(state.items.size){i ->
            val item = state.items[i]
            if(i >= state.items.size - 1 && !state.endReached && !state.isLoading){
                viewModel.loadNextItem()
            }
            Spacer(modifier = Modifier.height(10.dp))
            CompareFormComponent(item)
        }

        item {
            if(state.isLoading){
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    horizontalArrangement = Arrangement.Center
                ) {
                    CircularProgressIndicator(
                        color = SelectedNavItemColor
                    )
                }
            }
        }
        item {
            Spacer(modifier = Modifier.height(70.dp))
        }



    }
}