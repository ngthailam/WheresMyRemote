package vn.thailam.wheresmyremote.domain.usecase.item

import vn.thailam.wheresmyremote.data.entity.ItemEntity
import vn.thailam.wheresmyremote.data.repo.ItemRepository
import vn.thailam.wheresmyremote.domain.usecase.BaseSuspendUseCaseNoOutput
import javax.inject.Inject

class InsertItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
) : BaseSuspendUseCaseNoOutput<InsertItemUseCase.Input>() {

    override suspend operator fun invoke(input: Input) {
        return itemRepository.insert(input.toItemEntity())
    }

    data class Input(
        val name: String,
        val placeId: Int,
    ) {
        fun toItemEntity(): ItemEntity {
            return ItemEntity(
                name = name,
                placeId = placeId,
            )
        }
    }
}
