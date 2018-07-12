package io.github.amanshuraikwar.cryptonyte.data.network

import android.util.Log
import io.github.amanshuraikwar.cryptonyte.model.Currency
import io.github.amanshuraikwar.cryptonyte.util.Util
import javax.inject.Inject

/**
 * Implementation of Network Data Manager.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 30/04/18.
 */
class NetworkDataManagerImpl @Inject constructor(private val apiInterface: ApiInterface) : NetworkDataManager {

    private val TAG = Util.getTag(this)

    override fun getAllCurrencies(start: Int, limit: Int): List<Currency> {
        Log.d(TAG, "getAllCurrencies:called")
        Log.i(TAG, "getAllCurrencies:start:$start;limit:$limit")
        return apiInterface.getAllCurrencies(start, limit)
    }

    override fun getCurrency(id: String): Currency {
        Log.d(TAG, "getCurrency:called")
        Log.i(TAG, "getCurrency:id:$id")
        return apiInterface.getCurrency(id)
    }
}