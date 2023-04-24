package vn.thailam.wheresmyremote.data.db

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

val MIGRATION_2_3 by lazy {
    object : Migration(2, 3) {
        override fun migrate(database: SupportSQLiteDatabase) {
            database.execSQL("CREATE TABLE IF NOT EXISTS `_new_places` (`id` INTEGER PRIMARY KEY AUTOINCREMENT, `name` TEXT NOT NULL, `desc` TEXT NOT NULL DEFAULT '', `img_uri` TEXT NOT NULL DEFAULT '')");
            database.execSQL("INSERT INTO `_new_places` (`id`,`name`,`desc`) SELECT `id`,`name`,`desc` FROM `places`");
            database.execSQL("DROP TABLE `places`");
            database.execSQL("ALTER TABLE `_new_places` RENAME TO `places`");
        }
    }
}
