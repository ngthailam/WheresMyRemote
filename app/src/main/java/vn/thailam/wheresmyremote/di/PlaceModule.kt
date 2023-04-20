package vn.thailam.wheresmyremote.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import vn.thailam.wheresmyremote.data.repo.PlaceRepository
import vn.thailam.wheresmyremote.data.repo.PlaceRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
interface PlaceModule {
    @Binds
    fun bindPlaceRepository(placeRepositoryImpl: PlaceRepositoryImpl): PlaceRepository
}
