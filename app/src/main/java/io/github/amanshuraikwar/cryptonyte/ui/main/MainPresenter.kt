package io.github.amanshuraikwar.cryptonyte.ui.main

import android.util.Log
import io.github.amanshuraikwar.cryptonyte.bus.AppBus
import io.github.amanshuraikwar.cryptonyte.data.DataManager
import io.github.amanshuraikwar.cryptonyte.model.Currency
import io.github.amanshuraikwar.cryptonyte.ui.base.BasePresenterImpl
import io.github.amanshuraikwar.cryptonyte.ui.list.ListItem
import io.github.amanshuraikwar.cryptonyte.ui.list.currency.CurrencyListItem
import io.github.amanshuraikwar.cryptonyte.util.Util
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by amanshuraikwar on 30/04/18.
 */
class MainPresenter @Inject constructor(appBus: AppBus, dataManager: DataManager)
    : BasePresenterImpl<MainContract.View>(appBus, dataManager), MainContract.Presenter {

    private val TAG = Util.getTag(this)

    override fun onAttach(wasViewRecreated: Boolean) {
        super.onAttach(wasViewRecreated)

        if (wasViewRecreated) {
            getAllContent()
        }
    }

    private fun getAllContent() {

        when {
            getDataManager().getAllCurrenciesCache().isCacheBusy() -> getView()?.showMainLoading()
            getDataManager().getAllCurrenciesCache().isCacheEmpty() -> getMoreContent()
            else -> getCachedContent()
        }
    }

    private fun getCachedContent() {

        getDataManager()
                .getAllCurrenciesCache()
                .getCachedContent()
                .map{currencies -> getListItems(currencies)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterNext {
                    currencies ->
                    for (currency in currencies) {
                        Log.d(TAG, "onAttach:$currency")
                    }
                }
                .subscribe (
                        {
                            getView()?.displayItems(it)
                        },
                        {
                            getView()?.showMainError()
                        },
                        {
                            getView()?.hideMainLoading()
                        },
                        {
                            getView()?.showMainLoading()
                        }
                )
                .addToCleanup()
    }

    private fun getMoreContent() {

        getDataManager()
                .getAllCurrenciesCache()
                .getMoreContent()
                .map{currencies -> getListItems(currencies)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterNext {
                    currencies ->
                    for (currency in currencies) {
                        Log.d(TAG, "onAttach:$currency")
                    }
                }
                .subscribe (
                        {
                            getView()?.displayItems(it)
                        },
                        {
                            getView()?.showMainError()
                        },
                        {
                            getView()?.hideMainLoading()
                        },
                        {
                            getView()?.showMainLoading()
                        }
                )
                .addToCleanup()
    }

    override fun onSwipeRefresh() {
        Log.d(TAG, "onSwipeRefresh:called")

        getDataManager()
                .getAllCurrenciesCache()
                .let {
                    it.resetCache()
                    it.getMoreContent()
                            .map{currencies -> getListItems(currencies)}
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doAfterNext {
                                currencies ->
                                for (currency in currencies) {
                                    Log.d(TAG, "onAttach:$currency")
                                }
                            }
                            .subscribe (
                                    {
                                        getView()?.clearList()
                                        getView()?.displayItems(it)
                                    },
                                    {
                                        Log.d(TAG, "onSwipeRefresh:onError")
                                        getView()?.showError()
                                    },
                                    {
                                        Log.d(TAG, "onSwipeRefresh:hideLoading")
                                        getView()?.hideLoading()
                                    },
                                    {
                                        Log.d(TAG, "onSwipeRefresh:showLoading")
                                        getView()?.showLoading()
                                    }
                            )
                            .addToCleanup()
                }
    }

    override fun onRetryBtnClick() {
        getAllContent()
    }

    private fun getListItems(currencies: List<Currency>): List<ListItem<*>> {
        val listItems = mutableListOf<ListItem<*>>()
        for (currency in currencies) {
            listItems.add(CurrencyListItem(currency))
        }
        return listItems
    }
}