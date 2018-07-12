package io.github.amanshuraikwar.cryptonyte.data.network

import io.github.amanshuraikwar.cryptonyte.model.Currency
import io.reactivex.Observable

/**
 * Data Manager for the content fetched from the network.
 * This is the single entry point to fetch data from the network.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 30/04/18.
 */
interface NetworkDataManager {

    /**
     * To fetch all currencies from the network.
     *
     * @param start starting rank of the currency on the remote server.
     * @param limit how many currencies to fetch starting at the start rank.
     *
     * @return list of Currencies fetched from the network.
     */
    fun getAllCurrencies(start: Int, limit: Int): List<Currency>

    /**
     * TO fetch a currency from the network given it's id.
     *
     * @param id id of the currency to be fetched from the network.
     * @return Currency object for the given id.
     */
    fun getCurrency(id: String): Currency
}