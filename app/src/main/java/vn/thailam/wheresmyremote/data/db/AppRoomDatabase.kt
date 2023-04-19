package vn.thailam.wheresmyremote.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import vn.thailam.wheresmyremote.data.dao.PlaceDao
import vn.thailam.wheresmyremote.data.entity.PlaceEntity


@Database(
    entities = [PlaceEntity::class],
    version = AppRoomDatabase.VERSION,
    exportSchema = false
)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun placeDao(): PlaceDao

    companion object {
        const val VERSION = 1
        const val NAME = "app_db"
    }
}