package vn.thailam.wheresmyremote.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = PlaceEntity.TBL_NAME)
data class PlaceEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_ID)
    var id: Int? = null
) {
    companion object {
        const val TBL_NAME = "places"
        const val COL_ID = "id"
    }
}
