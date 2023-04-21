package vn.thailam.wheresmyremote.ui.feature.placedetail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import vn.thailam.wheresmyremote.data.entity.ItemEntity
import vn.thailam.wheresmyremote.ui.utils.toAddItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PlaceDetailScreen(
    navController: NavController,
    placeId: Int,
    viewModel: PlaceDetailViewModel = hiltViewModel(),
) {
    val place = viewModel.place.collectAsState()
    val items = place.value?.items ?: emptyList()

    Box(modifier = Modifier.fillMaxSize()) {
        Text(text = "Name: ${place.value?.place?.name}")

        if (items.isNotEmpty()) {
            LazyVerticalStaggeredGrid(
                modifier = Modifier.padding(all = 16.dp),
                columns = StaggeredGridCells.Fixed(2),
                verticalItemSpacing = 16.dp,
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items.size) { count ->
                    Item(items[count])
                }
            }
        }


        ExtendedFloatingActionButton(
            modifier = Modifier
                .padding(all = 16.dp)
                .align(alignment = Alignment.BottomEnd),
            elevation = FloatingActionButtonDefaults.elevation(0.dp, 0.dp),
            text = {
                Text(text = "Add Item")
            },
            icon = {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "Add Item FAB",
                )
            },
            onClick = {
                navController.toAddItem(placeId = placeId)
            },
        )
    }
}

@Composable
fun Item(item: ItemEntity) {
    Text(text = item.name)
}
