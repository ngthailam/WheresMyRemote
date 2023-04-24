package vn.thailam.wheresmyremote.ui.feature.addplace

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import vn.thailam.wheresmyremote.domain.usecase.place.InsertPlaceUseCase
import vn.thailam.wheresmyremote.ui.feature.base.NavigatorState
import vn.thailam.wheresmyremote.ui.feature.base.RouteNavigator
import javax.inject.Inject

@HiltViewModel
class AddPlaceViewModel @Inject constructor(
    private val insertPlaceUseCase: InsertPlaceUseCase,
    private val routeNavigator: RouteNavigator,
) : ViewModel(), RouteNavigator by routeNavigator {

    var name: String = ""
    var desc: String = ""
    var imgUriPath: String = ""

    fun confirmInsert() = viewModelScope.launch {
        if (name.isEmpty()) {
            return@launch
        }

        try {
            val input = InsertPlaceUseCase.Input(name = name, desc = desc, imgUriPath = imgUriPath)
            insertPlaceUseCase(input)
            navigate(NavigatorState.Up)
        } catch (t: Throwable) {
            //
        }
    }

    fun onNameChanged(text: String) {
        name = text
    }

    fun onDescChanged(text: String) {
        desc = text
    }

    fun onImageUriPathChanged(uri: String) {
        imgUriPath = uri
    }
}
