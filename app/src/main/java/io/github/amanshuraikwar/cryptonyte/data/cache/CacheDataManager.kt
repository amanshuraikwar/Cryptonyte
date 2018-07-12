package io.github.amanshuraikwar.cryptonyte.data.cache

import io.github.amanshuraikwar.cryptonyte.model.Currency

/**
 * Data Manager for the cached content.
 * This is the single entry point to access/modify cached data.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 03/05/18.
 */
interface CacheDataManager {

    fun getAllCurrenciesCache(): ContentCache<Currency>
}