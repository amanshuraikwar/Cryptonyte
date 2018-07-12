package io.github.amanshuraikwar.cryptonyte.data.network

import io.github.amanshuraikwar.cryptonyte.model.Currency
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Retrofit api interface.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 30/04/18.
 */
interface ApiInterface {

    @GET(ApiEndpoints.TICKER)
    fun getAllCurrencies(@Query("start") start: Int, @Query("limit") limit: Int)
            : List<Currency>

    @GET(ApiEndpoints.TICKER_CURRENCY)
    fun getCurrency(@Path("id") id: String): Currency
}