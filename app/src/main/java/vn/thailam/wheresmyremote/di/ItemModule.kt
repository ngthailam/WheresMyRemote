package vn.thailam.wheresmyremote.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import vn.thailam.wheresmyremote.data.repo.ItemRepository
import vn.thailam.wheresmyremote.data.repo.ItemRepositoryImpl

@Module
@InstallIn(ViewModelComponent::class)
interface ItemModule {
    @Binds
    fun bindItemRepository(itemRepositoryImpl: ItemRepositoryImpl): ItemRepository
}
