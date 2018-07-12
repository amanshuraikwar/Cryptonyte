package io.github.amanshuraikwar.cryptonyte.data.cache

import io.reactivex.Observable

/**
 * Abstraction over Cached content.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 30/04/18.
 */
interface ContentCache<DataModel> {

    /**
     * To get more content into the cache from the source.
     * @return Observable of List of fetched DataModel
     */
    fun getMoreContent(): Observable<List<DataModel>>

    /**
     * To get already cached content into the cache from the source.
     * @return Observable of List of cached DataModel
     */
    fun getCachedContent(): Observable<List<DataModel>>

    /**
     * To reset the cache.
     */
    fun resetCache()

    /**
     * To determine if the cache is empty.
     * @return a boolean determining the same.
     */
    fun isCacheEmpty(): Boolean

    /**
     * To determine if the cache is busy fetching data from the source.
     * @return a boolean determining the same.
     */
    fun isCacheBusy(): Boolean

    /**
     * To determine if the cache has reached the end of content on the source.
     * @return a boolean determining the same.
     */
    fun isCacheReachedEnd(): Boolean
}