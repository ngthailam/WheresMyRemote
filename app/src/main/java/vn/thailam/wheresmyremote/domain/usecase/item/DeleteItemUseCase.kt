package vn.thailam.wheresmyremote.domain.usecase.item

import vn.thailam.wheresmyremote.data.entity.ItemIdType
import vn.thailam.wheresmyremote.data.repo.ItemRepository
import vn.thailam.wheresmyremote.domain.usecase.BaseSuspendUseCaseNoOutput
import javax.inject.Inject

class DeleteItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository,
): BaseSuspendUseCaseNoOutput<ItemIdType>() {
    override suspend operator fun invoke(input: ItemIdType) {
        return itemRepository.delete(input)
    }
}
