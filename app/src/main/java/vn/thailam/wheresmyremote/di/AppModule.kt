package vn.thailam.wheresmyremote.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import vn.thailam.wheresmyremote.ui.feature.base.RouteNavigator
import vn.thailam.wheresmyremote.ui.feature.base.RouteNavigatorImpl
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface AppModule {
    companion object {
        @Provides
        @IoDispatcher
        fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO
    }

    @Binds
    @Singleton
    fun bindRouteNavigator(routeNavigatorImpl: RouteNavigatorImpl): RouteNavigator
}
