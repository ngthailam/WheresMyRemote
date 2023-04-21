package vn.thailam.wheresmyremote.domain.usecase.place

import kotlinx.coroutines.flow.Flow
import vn.thailam.wheresmyremote.data.entity.PlaceIdType
import vn.thailam.wheresmyremote.data.entity.PlaceItemEntity
import vn.thailam.wheresmyremote.data.repo.PlaceRepository
import vn.thailam.wheresmyremote.domain.usecase.BaseFlowUseCase
import javax.inject.Inject

class GetPlaceWithItemsFlowUseCase @Inject constructor(
    private val placeRepository: PlaceRepository,
) : BaseFlowUseCase<PlaceIdType, PlaceItemEntity>() {
    override fun invoke(input: PlaceIdType): Flow<PlaceItemEntity> {
        return placeRepository.getPlaceWithItemsFlow(input)
    }
}
