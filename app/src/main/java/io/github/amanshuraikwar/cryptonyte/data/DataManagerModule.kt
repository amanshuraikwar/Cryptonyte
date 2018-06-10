package io.github.amanshuraikwar.cryptonyte.data

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Created by amanshuraikwar on 07/03/18.
 */
@Module
abstract class DataManagerModule {

    @Singleton
    @Binds
    abstract fun dataManager(dataManager: DataManagerImpl): DataManager
}