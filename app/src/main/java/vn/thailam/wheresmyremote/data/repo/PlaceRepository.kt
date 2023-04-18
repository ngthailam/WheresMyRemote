package vn.thailam.wheresmyremote.data.repo

import kotlinx.coroutines.flow.Flow
import vn.thailam.wheresmyremote.data.dao.PlaceDao
import vn.thailam.wheresmyremote.data.entity.PlaceEntity
import javax.inject.Inject

interface PlaceRepository {
    fun getAllFlow(): Flow<List<PlaceEntity>>
}

class PlaceRepositoryImpl @Inject constructor(
    private val placeDao: PlaceDao,
): PlaceRepository {

    override fun getAllFlow(): Flow<List<PlaceEntity>> {
        return placeDao.getAllFlow()
    }
}
