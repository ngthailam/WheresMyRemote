package vn.thailam.wheresmyremote.data.dao

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import vn.thailam.wheresmyremote.data.entity.PlaceEntity

@Dao
interface PlaceDao {

    @Query("SELECT * FROM ${PlaceEntity.TBL_NAME} WHERE ${PlaceEntity.COL_ID}=:placeId")
    suspend fun get(placeId: Int): PlaceEntity

    @Query("SELECT * FROM ${PlaceEntity.TBL_NAME}")
    fun getAllFlow(): Flow<List<PlaceEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(place: PlaceEntity)

    @Delete
    suspend fun delete(place: PlaceEntity)
}