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

    @ColumnInfo(name = COL_DESC, defaultValue = "")
    val desc: String = "",

    @ColumnInfo(name = COL_IMG_URI, defaultValue = "")
    val imgUriPath: String = "",
) {
    companion object {
        const val TBL_NAME = "places"
        const val COL_ID = "id"
        const val COL_NAME = "name"
        const val COL_DESC = "desc"
        const val COL_IMG_URI = "img_uri"
    }
}
