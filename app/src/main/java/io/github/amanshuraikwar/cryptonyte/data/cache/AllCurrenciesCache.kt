package io.github.amanshuraikwar.cryptonyte.data.cache

import android.util.Log
import io.github.amanshuraikwar.cryptonyte.data.network.NetworkDataManager
import io.github.amanshuraikwar.cryptonyte.model.Currency
import io.github.amanshuraikwar.cryptonyte.util.Util
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Cache implementation for all Currencies fetched from the remote api.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 30/04/18.
 */
class AllCurrenciesCache @Inject constructor(private val networkDataManager: NetworkDataManager)
    : ContentCache<Currency> {

    private val TAG = Util.getTag(this)

    //region attributes
    private val cachedContent: MutableList<Currency> = mutableListOf()
    private var perPage: Int = 20

    @Volatile private var state: State = State.NORMAL
    //endregion

    private enum class State {
        NORMAL, FETCHING, REACHED_END
    }

    override fun getMoreContent(): Observable<List<Currency>> {

        Log.d(TAG, "getMoreContent:called")

        if (state == State.NORMAL) {

            return Observable.create {
                emitter ->
                try {
                    setState(State.FETCHING)

                    val newList = networkDataManager.getAllCurrencies(cachedContent.size, perPage)

                    @Synchronized
                    if (newList.isEmpty()) {
                        if (state == State.FETCHING) {
                            setState(State.REACHED_END)
                            emitter.onComplete()
                        }
                    } else {
                        if (state == State.FETCHING) {
                            setState(State.NORMAL)
                            addToCache(newList)
                            emitter.onNext(newList)
                            emitter.onComplete()
                        }
                    }
                } catch (e: Exception) {
                    if (state == State.FETCHING) {
                        setState(State.NORMAL)
                    }
                    emitter.tryOnError(e)
                }
            }
        }

        return Observable.fromCallable{ listOf<Currency>() }
    }

    override fun getCachedContent(): Observable<List<Currency>>
            = Observable.fromCallable { cachedContent }

    @Synchronized
    override fun resetCache() {
        Log.d(TAG, "resetCache:called")
        setState(State.NORMAL)
        cachedContent.clear()
    }

    @Synchronized
    override fun isCacheEmpty() = cachedContent.isEmpty()

    @Synchronized
    override fun isCacheReachedEnd() = state == State.REACHED_END

    @Synchronized
    override fun isCacheBusy() = state == State.FETCHING

    @Synchronized
    private fun setState(state: State) {
        this.state = state
    }

    @Synchronized
    private fun addToCache(newContent: List<Currency>) {
        cachedContent.addAll(newContent)
    }
}