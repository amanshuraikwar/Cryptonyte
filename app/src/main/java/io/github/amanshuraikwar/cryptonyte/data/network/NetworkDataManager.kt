package io.github.amanshuraikwar.cryptonyte.data.network

import io.github.amanshuraikwar.cryptonyte.model.Currency
import io.reactivex.Observable

/**
 * Created by amanshuraikwar on 30/04/18.
 */
interface NetworkDataManager {

    fun getAllCurrencies(start: Int, limit: Int): List<Currency>
    fun getCurrency(id: String): Currency
}