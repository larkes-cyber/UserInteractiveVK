package com.example.vkcupsteptwo.ui.screen.drag_text_variants_screen

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.vkcupsteptwo.ui.component.TitleHeaderComponent
import com.example.vkcupsteptwo.ui.screen.drag_text_variants_screen.component.DragVariantsFormComponent
import com.example.vkcupsteptwo.ui.theme.BackgroundColor
import com.example.vkcupsteptwo.ui.theme.SelectedNavItemColor

@Composable
fun DragTextVariantsScreen() {

    val viewModel = viewModel<DragTextVariantsViewModel>()
    val state = viewModel.state



    LazyColumn(modifier = Modifier
        .fillMaxSize()
        .background(BackgroundColor)
    ){

        item{
            TitleHeaderComponent("Вставить")
        }

        items(state.items.size){ i ->
            Log.d("item_item","item.toString()")
            val item = state.items[i]
            Log.d("item_item",item.toString())
            if(i >= state.items.size - 1 && !state.endReached && !state.isLoading){
                viewModel.loadNextItem()
            }
            Spacer(modifier = Modifier.height(10.dp))
            DragVariantsFormComponent(textFormWithVariants = item)

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