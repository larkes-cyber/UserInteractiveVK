package com.example.vkcupsteptwo.ui.screen.compare_screen.component

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.saveable.listSaver
import androidx.compose.runtime.saveable.mapSaver
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import com.example.vkcupsteptwo.model.ActionsInfo
import com.example.vkcupsteptwo.model.CompareForm
import com.example.vkcupsteptwo.model.CompareItems
import com.example.vkcupsteptwo.ui.component.TitlePostComponent
import com.example.vkcupsteptwo.ui.component.WrapperPostComponent
import com.example.vkcupsteptwo.ui.theme.SelectedNavItemColor
import androidx.compose.runtime.saveable.rememberSaveable as rememberSaveable

@SuppressLint("MutableCollectionMutableState")
@Composable
fun CompareFormComponent(
    compareForm: CompareForm
) {



    val comparableLinesState = remember{
        mutableStateListOf<CompareItems>()
    }

    val selectedFirstCompareButton = remember {
        mutableStateOf<Pair<Int,Float>?>(null)
    }


    fun selectFirstComparableButton(number:Int, width:Float){
        selectedFirstCompareButton.value = Pair(number, width)
    }

    fun removeCompare(index:Int){
        val node = comparableLinesState.filter { it.firstComparable.first == index }
        if(node.isEmpty()) return

        comparableLinesState.remove(node[0])
    }

    var columnWidthPx by remember {
        mutableStateOf(0f)
    }

    fun selectSecondComparableButton(number:Int, width:Float){

        val checkNode = comparableLinesState.filter { it.secondComparable.first == number}



        if(checkNode.isNotEmpty()) return


        comparableLinesState.add(
            CompareItems(
                Pair(selectedFirstCompareButton.value!!.first, selectedFirstCompareButton.value!!.second),
                Pair(number, width),
            )
        )

        selectedFirstCompareButton.value = null
    }



      WrapperPostComponent(
          group = compareForm.group,
          actionsInfo = compareForm.actionsInfo,
          postComment = compareForm.postData.comment
      ) {
          //Offset(272f, 240f)
          //
          Column(
              Modifier
                  .fillMaxWidth()
                  .onGloballyPositioned { coordinates ->
                      columnWidthPx = coordinates.size.width.toFloat()
                  }
                  .drawBehind {
                      comparableLinesState.forEach {
                          drawLine(
                              color = SelectedNavItemColor,
                              start = Offset(it.firstComparable.second + 20.dp.toPx(),
                                  86.dp.toPx() + (it.firstComparable.first * 50.dp.toPx())),
                              end = Offset(columnWidthPx - it.secondComparable.first - 65.dp.toPx(),
                                  86.dp.toPx() + (it.secondComparable.first * 50.dp.toPx())),
                              strokeWidth = 3.dp.toPx()
                          )
                      }
                  }
          ) {
              Box(Modifier
                  .align(Alignment.CenterHorizontally)
                  .padding(top = 21.dp)) {
                  TitlePostComponent(compareForm.postData.title)
              }
              Spacer(modifier = Modifier.height(15.dp))
              Column(Modifier
                  .fillMaxWidth()
                  .padding(vertical = 10.dp, horizontal = 30.dp)
              ) {
                  compareForm.compareItems.forEachIndexed { index, pair ->
                      Row(
                          modifier = Modifier.fillMaxWidth(),
                          horizontalArrangement = Arrangement.SpaceBetween
                      ) {
                          FirstComparableButtonComponent(title = pair.first, index = index, callback = ::selectFirstComparableButton, removeCompareCallback = ::removeCompare, isSelected = if(selectedFirstCompareButton.value != null) selectedFirstCompareButton.value!!.first == index else false)
                          SecondComparableButtonComponent(title = pair.second, callback = if(selectedFirstCompareButton.value != null) ::selectSecondComparableButton else null, index = index)
                      }
                  }
              }
          }
      }
    
}