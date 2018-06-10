package io.github.amanshuraikwar.cryptonyte.ui.main

import io.github.amanshuraikwar.cryptonyte.model.Currency
import io.github.amanshuraikwar.cryptonyte.ui.base.BasePresenter
import io.github.amanshuraikwar.cryptonyte.ui.base.BaseView
import io.github.amanshuraikwar.cryptonyte.ui.list.ListItem

/**
 * Created by amanshuraikwar on 30/04/18.
 */
interface MainContract {

    interface View : BaseView {
        fun clearList()
        fun displayItems(listItems: List<ListItem<*>>)
        fun showMainError()
        fun showError()
        fun showMainLoading()
        fun hideMainLoading()
        fun showLoading()
        fun hideLoading()
    }
    interface Presenter : BasePresenter<View> {
        fun onSwipeRefresh()
        fun onRetryBtnClick()
    }
}