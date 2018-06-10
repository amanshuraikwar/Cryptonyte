package io.github.amanshuraikwar.cryptonyte.data.network

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by amanshuraikwar on 30/04/18.
 */
@Module
abstract class NetworkDataManagerModule {

    @Singleton @Binds
    abstract fun getNetworkDataManager(impl: NetworkDataDataManagerImpl): NetworkDataManager
}