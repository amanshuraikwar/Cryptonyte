package io.github.amanshuraikwar.cryptonyte.bus

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by amanshuraikwar on 07/03/18.
 */
@Module class AppBusModule {

    @Singleton @Provides fun appBus(): AppBus = AppBus()
}