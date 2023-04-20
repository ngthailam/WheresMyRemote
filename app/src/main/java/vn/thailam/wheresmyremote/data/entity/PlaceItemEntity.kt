package vn.thailam.wheresmyremote.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class PlaceItemEntity(
    @Embedded val place: PlaceEntity,
    @Relation(
        parentColumn = PlaceEntity.COL_ID,
        entityColumn = ItemEntity.COL_PLACE_ID,
        entity = ItemEntity::class
    )
    val items: List<ItemEntity>
)
