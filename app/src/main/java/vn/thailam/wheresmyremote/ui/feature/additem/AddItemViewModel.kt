package vn.thailam.wheresmyremote.ui.feature.additem

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import vn.thailam.wheresmyremote.domain.usecase.item.InsertItemUseCase
import vn.thailam.wheresmyremote.ui.feature.base.NavigatorState
import vn.thailam.wheresmyremote.ui.feature.base.RouteNavigator
import vn.thailam.wheresmyremote.ui.utils.DestinationArg
import javax.inject.Inject

@HiltViewModel
class AddItemViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle,
    private val insertItemUseCase: InsertItemUseCase,
    private val routeNavigator: RouteNavigator,
) : ViewModel(), RouteNavigator by routeNavigator {

    private val placeId: Int =
        checkNotNull(savedStateHandle.get(DestinationArg.PLACE_ID))

    var name: String = ""
    fun onNameChanged(text: String) {
        name = text
    }

    fun confirmInsert() = viewModelScope.launch {
        try {
            val input = InsertItemUseCase.Input(
                placeId = placeId,
                name = name,
            )
            insertItemUseCase(input)
            println("ZZLL confirmInser....")
            navigate(NavigatorState.Up)
        } catch (t: Throwable) {
            //
        }
    }
}
