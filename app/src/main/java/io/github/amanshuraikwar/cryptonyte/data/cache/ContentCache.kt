package io.github.amanshuraikwar.cryptonyte.data.cache

import io.reactivex.Completable
import io.reactivex.Observable

/**
 * Created by amanshuraikwar on 30/04/18.
 */
interface ContentCache<DataModel> {

    fun getMoreContent(): Observable<List<DataModel>>
    fun getCachedContent(): Observable<List<DataModel>>
    fun resetCache()
    fun isCacheEmpty(): Boolean
    fun isCacheBusy(): Boolean
    fun isCacheReachedEnd(): Boolean
}