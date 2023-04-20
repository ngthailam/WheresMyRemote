package vn.thailam.wheresmyremote.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

typealias ItemIdType = Int

@Entity(tableName = ItemEntity.TBL_NAME)
data class ItemEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COL_ID)
    var id: Int? = null,

    @ColumnInfo(name = COL_NAME)
    val name: String,

    @ColumnInfo(name = COL_DESC)
    val desc: String? = null,

    @ColumnInfo(name = COL_IMG_PATH)
    val imgPath: String? = null,

    @ColumnInfo(name = COL_PLACE_ID)
    val placeId: Int,
) {
    companion object {
        const val TBL_NAME = "items"
        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_DESC = "desc"
        const val COL_IMG_PATH = "image_path"
        const val COL_PLACE_ID = "place_id"
    }
}
