package io.github.amanshuraikwar.cryptonyte.data

import android.content.Context
import io.github.amanshuraikwar.cryptonyte.data.DataManager
import io.github.amanshuraikwar.cryptonyte.data.cache.CacheDataManager
import io.github.amanshuraikwar.cryptonyte.data.cache.ContentCache
import io.github.amanshuraikwar.cryptonyte.data.network.NetworkDataManager
import io.github.amanshuraikwar.cryptonyte.di.ApplicationContext
import io.github.amanshuraikwar.cryptonyte.model.Currency
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

/**
 * Implementation of the Data Manager for the app.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 07/03/18.
 */
class DataManagerImpl @Inject constructor(
        @ApplicationContext val context: Context,
        private val networkDataManager: NetworkDataManager,
        private val cacheDataManager: CacheDataManager) : DataManager {

    override fun getAllCurrenciesCache() = cacheDataManager.getAllCurrenciesCache()

    override fun getAllCurrencies(start: Int, limit: Int)
            = networkDataManager.getAllCurrencies(start, limit)

    override fun getCurrency(id: String)
            = networkDataManager.getCurrency(id)

}