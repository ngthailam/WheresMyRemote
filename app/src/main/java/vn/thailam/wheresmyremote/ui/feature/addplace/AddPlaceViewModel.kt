package vn.thailam.wheresmyremote.ui.feature.addplace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import vn.thailam.wheresmyremote.domain.usecase.place.InsertPlaceUseCase
import javax.inject.Inject

@HiltViewModel
class AddPlaceViewModel @Inject constructor(
    private val insertPlaceUseCase: InsertPlaceUseCase,
) : ViewModel() {

    var name: String = ""

    fun confirmInsert() = viewModelScope.launch {
        if (name.isEmpty()) {
            //
            return@launch
        }

        try {
            val input = InsertPlaceUseCase.Input(name = name)
            insertPlaceUseCase(input)
        } catch (t: Throwable) {
            //
        }
    }

    fun onNameChanged(text: String) {
        name = text
    }
}
