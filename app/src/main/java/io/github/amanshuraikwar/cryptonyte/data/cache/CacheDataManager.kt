package io.github.amanshuraikwar.cryptonyte.data.cache

import io.github.amanshuraikwar.cryptonyte.model.Currency

/**
 * Created by amanshuraikwar on 03/05/18.
 */
interface CacheDataManager {

    fun getAllCurrenciesCache(): ContentCache<Currency>
}