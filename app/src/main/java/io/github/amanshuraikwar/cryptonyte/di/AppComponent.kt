package io.github.amanshuraikwar.cryptonyte.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import io.github.amanshuraikwar.cryptonyte.MyApp
import io.github.amanshuraikwar.cryptonyte.bus.AppBus
import io.github.amanshuraikwar.cryptonyte.bus.AppBusModule
import io.github.amanshuraikwar.cryptonyte.data.DataManager
import io.github.amanshuraikwar.cryptonyte.data.DataManagerModule
import io.github.amanshuraikwar.cryptonyte.data.DateManagerModuleProvides
import io.github.amanshuraikwar.cryptonyte.data.cache.CacheDataManagerModule
import io.github.amanshuraikwar.cryptonyte.data.network.NetworkDataManagerModule
import io.github.amanshuraikwar.cryptonyte.data.network.NetworkManagerProvides
import javax.inject.Singleton

/**
 * Created by amanshuraikwar on 07/03/18.
 */
@Singleton
@Component(
        modules = [
            (AppModule::class),
            (NetworkDataManagerModule::class),
            (NetworkManagerProvides::class),
            (CacheDataManagerModule::class),
            (DataManagerModule::class),
            (DateManagerModuleProvides::class),
            (AppBusModule::class),
            (ActivityBindingModule::class),
            (AndroidSupportInjectionModule::class)])
interface AppComponent : AndroidInjector<MyApp> {

    fun dataManager(): DataManager
    fun appBus(): AppBus

    @Component.Builder interface Builder {

        @BindsInstance fun application(app: Application): Builder
        fun build(): AppComponent
    }
}