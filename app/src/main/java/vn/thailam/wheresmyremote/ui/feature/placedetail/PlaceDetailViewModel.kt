package vn.thailam.wheresmyremote.ui.feature.placedetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import vn.thailam.wheresmyremote.data.entity.PlaceItemEntity
import vn.thailam.wheresmyremote.domain.usecase.item.DeleteItemUseCase
import vn.thailam.wheresmyremote.domain.usecase.place.GetPlaceWithItemsFlowUseCase
import vn.thailam.wheresmyremote.ui.utils.DestinationArg
import javax.inject.Inject

@HiltViewModel
class PlaceDetailViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val getPlaceWithItemsFlowUseCase: GetPlaceWithItemsFlowUseCase,
    private val deleteItemUseCase: DeleteItemUseCase,
) : ViewModel() {

    private val placeId: Int =
        checkNotNull(savedStateHandle.get(DestinationArg.PLACE_ID))

    private val _place = MutableStateFlow<PlaceItemEntity?>(null)
    val place: StateFlow<PlaceItemEntity?> = _place

    init {
        observePlace()
    }

    private fun observePlace() = viewModelScope.launch(Dispatchers.IO) {
        getPlaceWithItemsFlowUseCase(placeId).collect {
            _place.value = it
        }
    }

    fun insertItem() {
        //
    }

    fun deleteItem(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            deleteItemUseCase(id)
        } catch (t: Throwable) {
            // show error
        }
    }
}
