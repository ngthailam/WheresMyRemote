package vn.thailam.wheresmyremote.ui.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import vn.thailam.wheresmyremote.data.entity.PlaceEntity
import vn.thailam.wheresmyremote.data.repo.PlaceRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val placeRepository: PlaceRepository,
): ViewModel() {

    private val _places = MutableStateFlow<List<PlaceEntity>>(emptyList())
    val places: StateFlow<List<PlaceEntity>> = _places.asStateFlow()

    fun observePlaces() = viewModelScope.launch(Dispatchers.IO) {
        placeRepository.getAllFlow().collect {
            _places.value = it
        }
    }
}