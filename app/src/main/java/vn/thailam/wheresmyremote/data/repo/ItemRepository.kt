package vn.thailam.wheresmyremote.data.repo

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import vn.thailam.wheresmyremote.data.dao.ItemDao
import vn.thailam.wheresmyremote.data.entity.ItemEntity
import vn.thailam.wheresmyremote.di.IoDispatcher
import javax.inject.Inject

interface ItemRepository {
    suspend fun insert(place: ItemEntity)

    suspend fun delete(itemId: Int)
}

class ItemRepositoryImpl @Inject constructor(
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    private val itemDao: ItemDao,
) : ItemRepository {
    override suspend fun insert(place: ItemEntity) = withContext(ioDispatcher) {
        itemDao.insert(place)
    }

    override suspend fun delete(itemId: Int) = withContext(ioDispatcher) {
        itemDao.delete(itemId)
    }
}
