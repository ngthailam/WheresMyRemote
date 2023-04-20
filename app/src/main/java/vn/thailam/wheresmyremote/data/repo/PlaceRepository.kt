package vn.thailam.wheresmyremote.data.repo

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import vn.thailam.wheresmyremote.data.dao.PlaceDao
import vn.thailam.wheresmyremote.data.entity.PlaceEntity
import vn.thailam.wheresmyremote.data.entity.PlaceItemEntity
import vn.thailam.wheresmyremote.di.IoDispatcher
import javax.inject.Inject
import javax.inject.Named

interface PlaceRepository {
    fun getAllFlow(): Flow<List<PlaceEntity>>

    fun getPlaceWithItemsFlow(placeId: Int): Flow<PlaceItemEntity>

    suspend fun insert(placeEntity: PlaceEntity)
}

class PlaceRepositoryImpl @Inject constructor(
    @IoDispatcher
    private val ioDispatcher: CoroutineDispatcher,
    private val placeDao: PlaceDao,
) : PlaceRepository {
    override fun getAllFlow(): Flow<List<PlaceEntity>> {
        return placeDao.getAllFlow()
    }

    override fun getPlaceWithItemsFlow(placeId: Int): Flow<PlaceItemEntity> {
        return placeDao.getPlaceWithItemsFlow(placeId = placeId)
    }

    override suspend fun insert(placeEntity: PlaceEntity) = withContext(ioDispatcher) {
        placeDao.insert(placeEntity)
    }
}
