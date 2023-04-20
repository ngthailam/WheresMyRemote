package vn.thailam.wheresmyremote.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import vn.thailam.wheresmyremote.data.db.AppRoomDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideAppRoomDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        AppRoomDatabase::class.java,
        AppRoomDatabase.NAME
    )
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    fun providePlaceDao(db: AppRoomDatabase) = db.placeDao()

    @Provides
    fun provideItemDao(db: AppRoomDatabase) = db.itemDao()
}
