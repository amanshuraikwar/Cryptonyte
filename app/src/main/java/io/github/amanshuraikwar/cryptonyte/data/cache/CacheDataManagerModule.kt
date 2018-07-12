package io.github.amanshuraikwar.cryptonyte.data.cache

import dagger.Binds
import dagger.Module
import javax.inject.Singleton

/**
 * Dagger Module to provide Cache Data Manager related instances.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 30/04/18.
 */
@Module
abstract class CacheDataManagerModule {

    @Singleton @Binds
    abstract fun getCacheDataManager(impl: CacheDataManagerImpl): CacheDataManager
}