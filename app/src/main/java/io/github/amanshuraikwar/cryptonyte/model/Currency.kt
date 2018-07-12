package io.github.amanshuraikwar.cryptonyte.model

import com.google.gson.annotations.SerializedName

/**
 * Model class that represents a CryptoCurrency.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 30/04/18.
 */
class Currency(
        @SerializedName("id") val id: String,
        @SerializedName("name") val name: String,
        @SerializedName("symbol") val symbol: String,
        @SerializedName("rank") val rank: String,
        @SerializedName("price_usd") val priceUsd: String,
        @SerializedName("price_btc") val priceBtc: String,
        @SerializedName("percent_change_1h") val percentageChange1h: String,
        @SerializedName("percent_change_24h") val percentageChange24h: String,
        @SerializedName("percent_change_7d") val percentageChange7d: String,
        @SerializedName("last_updated") val lastUpdated: String) {

    override fun toString(): String {
        return "Currency(id='$id', name='$name', symbol='$symbol', rank='$rank'," +
                " priceUsd='$priceUsd', priceBtc='$priceBtc'," +
                " percentageChange1h='$percentageChange1h'," +
                " percentageChange24h='$percentageChange24h'," +
                " percentageChange7d='$percentageChange7d'," +
                " lastUpdated='$lastUpdated')"
    }

}