package vn.thailam.wheresmyremote.ui.feature.placedetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vn.thailam.wheresmyremote.domain.usecase.item.DeleteItemUseCase
import vn.thailam.wheresmyremote.domain.usecase.item.InsertItemUseCase
import javax.inject.Inject

@HiltViewModel
class PlaceDetailViewModel @Inject constructor(
    private val insertItemUseCase: InsertItemUseCase,
    private val deleteItemUseCase: DeleteItemUseCase,
): ViewModel() {
    fun insertItem() {
        //
    }

    fun deleteItem(id: Int) = viewModelScope.launch(Dispatchers.IO) {
        try {
            deleteItemUseCase(id)
        } catch (t : Throwable) {
            // show error
        }
    }
}
