package io.github.amanshuraikwar.cryptonyte.data.network

import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Dagger Module to provide Network Data Manager related instances.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 03/05/18.
 */
@Module
class NetworkManagerProvides {

    @Singleton
    @Provides
    fun getRetrofitClient()
            = Retrofit
            .Builder()
            .baseUrl(ApiEndpoints.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Singleton
    @Provides
    fun getApiInterface(retrofit: Retrofit)
            = retrofit.create(ApiInterface::class.java)
}