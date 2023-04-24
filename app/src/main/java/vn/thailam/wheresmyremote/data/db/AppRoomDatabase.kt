package vn.thailam.wheresmyremote.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import vn.thailam.wheresmyremote.data.dao.ItemDao
import vn.thailam.wheresmyremote.data.dao.PlaceDao
import vn.thailam.wheresmyremote.data.entity.ItemEntity
import vn.thailam.wheresmyremote.data.entity.PlaceEntity


@Database(
    entities = [PlaceEntity::class, ItemEntity::class],
    version = AppRoomDatabase.VERSION,
    exportSchema = true,
    autoMigrations = [
        AutoMigration(from = 1, to = 2),
    ]
)
abstract class AppRoomDatabase : RoomDatabase() {
    abstract fun placeDao(): PlaceDao

    abstract fun itemDao(): ItemDao

    companion object {
        const val VERSION = 3
        const val NAME = "app_db"
    }
}
