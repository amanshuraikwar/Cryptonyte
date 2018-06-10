package io.github.amanshuraikwar.cryptonyte.data

import io.github.amanshuraikwar.cryptonyte.data.cache.CacheDataManager
import io.github.amanshuraikwar.cryptonyte.data.network.NetworkDataManager

/**
 * Created by amanshuraikwar on 06/03/18.
 */
interface DataManager : NetworkDataManager, CacheDataManager