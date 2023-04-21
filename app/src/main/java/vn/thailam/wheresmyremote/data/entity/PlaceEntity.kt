package vn.thailam.wheresmyremote.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

typealias PlaceIdType = Int

@Entity(tableName = PlaceEntity.TBL_NAME)
data class PlaceEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_ID)
    var id: Int? = null,

    @ColumnInfo(name = COL_NAME)
    val name: String,
) {
    companion object {
        const val TBL_NAME = "places"
        const val COL_ID = "id"
        const val COL_NAME = "name"
    }
}
