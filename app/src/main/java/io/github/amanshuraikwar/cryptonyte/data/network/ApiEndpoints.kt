package io.github.amanshuraikwar.cryptonyte.data.network

/**
 * API endpoints for the remote coinmarketcap api.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 30/04/18.
 */
interface ApiEndpoints {

    companion object {
        const val  BASE_URL = "https://api.coinmarketcap.com/v1/"
        const val  TICKER = "ticker?"
        const val  TICKER_CURRENCY = "ticker/{id}"
    }
}