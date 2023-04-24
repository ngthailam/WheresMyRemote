package vn.thailam.wheresmyremote.domain.usecase.place

import vn.thailam.wheresmyremote.data.entity.PlaceEntity
import vn.thailam.wheresmyremote.data.repo.PlaceRepository
import vn.thailam.wheresmyremote.domain.usecase.BaseSuspendUseCaseNoOutput
import javax.inject.Inject

class InsertPlaceUseCase @Inject constructor(
    private val placeRepository: PlaceRepository,
) : BaseSuspendUseCaseNoOutput<InsertPlaceUseCase.Input>() {

    override suspend operator fun invoke(input: Input) {
        return placeRepository.insert(input.toPlaceEntity())
    }

    data class Input(
        val name: String,
        val desc: String = "",
        val imgUriPath: String = "",
    ) {
        fun toPlaceEntity(): PlaceEntity {
            return PlaceEntity(
                name = name,
                desc = desc,
                imgUriPath = imgUriPath,
            )
        }
    }
}
