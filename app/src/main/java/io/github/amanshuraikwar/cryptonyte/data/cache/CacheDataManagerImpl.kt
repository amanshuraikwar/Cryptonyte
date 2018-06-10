package io.github.amanshuraikwar.cryptonyte.data.cache

import io.github.amanshuraikwar.cryptonyte.model.Currency
import javax.inject.Inject

/**
 * Created by amanshuraikwar on 03/05/18.
 */
class CacheDataManagerImpl @Inject constructor(
        private val allCurrenciesCache: AllCurrenciesCache) : CacheDataManager {

    override fun getAllCurrenciesCache(): ContentCache<Currency> {
        return allCurrenciesCache
    }
}