package vn.thailam.wheresmyremote.data.repo

import vn.thailam.wheresmyremote.data.dao.ItemDao
import vn.thailam.wheresmyremote.data.entity.ItemEntity
import javax.inject.Inject

interface ItemRepository {
    suspend fun insert(place: ItemEntity)

    suspend fun delete(itemId: Int)
}

class ItemRepositoryImpl @Inject constructor(
    private val itemDao: ItemDao,
) : ItemRepository {
    override suspend fun insert(place: ItemEntity) {
        return itemDao.insert(place)
    }

    override suspend fun delete(itemId: Int) {
        return itemDao.delete(itemId)
    }
}
