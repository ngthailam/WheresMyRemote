package vn.thailam.wheresmyremote.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import vn.thailam.wheresmyremote.data.entity.ItemEntity

@Dao
interface ItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(place: ItemEntity)

    @Query("DELETE FROM ${ItemEntity.TBL_NAME} WHERE ${ItemEntity.COL_ID}=:itemId")
    suspend fun delete(itemId: Int)
}
