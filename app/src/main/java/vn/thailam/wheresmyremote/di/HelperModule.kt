package vn.thailam.wheresmyremote.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import vn.thailam.wheresmyremote.ui.feature.base.RouteNavigator
import vn.thailam.wheresmyremote.ui.feature.base.RouteNavigatorImpl
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
interface HelperModule {

}
