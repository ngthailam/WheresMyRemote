package vn.thailam.wheresmyremote.data.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import vn.thailam.wheresmyremote.data.entity.PlaceEntity
import vn.thailam.wheresmyremote.data.entity.PlaceItemEntity

@Dao
interface PlaceDao {
    @Query("SELECT * FROM ${PlaceEntity.TBL_NAME}")
    fun getAllFlow(): Flow<List<PlaceEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(place: PlaceEntity)

    @Delete
    suspend fun delete(place: PlaceEntity)

    @Transaction
    @Query("SELECT * FROM ${PlaceEntity.TBL_NAME} WHERE ${PlaceEntity.COL_ID}=:placeId")
    fun getPlaceWithItemsFlow(placeId: Int): Flow<PlaceItemEntity>
}
