package io.github.amanshuraikwar.cryptonyte.ui.main

import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.github.amanshuraikwar.cryptonyte.R
import io.github.amanshuraikwar.cryptonyte.model.Currency
import io.github.amanshuraikwar.cryptonyte.ui.base.BaseActivity
import io.github.amanshuraikwar.cryptonyte.ui.list.ListItem
import io.github.amanshuraikwar.cryptonyte.ui.list.ListItemTypeFactory
import io.github.amanshuraikwar.cryptonyte.ui.list.RecyclerViewAdapter
import io.github.amanshuraikwar.cryptonyte.util.Util
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_currency.view.*

class MainActivity : BaseActivity<MainContract.View, MainContract.Presenter>(), MainContract.View {

    private val TAG = Util.getTag(this)

    private val adapter = RecyclerViewAdapter(this, ListItemTypeFactory())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initUi()
    }

    private fun initUi() {
        mainActivityRv.layoutManager = LinearLayoutManager(this)
        mainActivityRv.adapter = adapter

        setSupportActionBar(mainActivityToolbar)

        mainActivitySrl.setOnRefreshListener { presenter.onSwipeRefresh() }

        mainActivityMainPb.show()
    }

    //region view methods
    override fun clearList() {
        adapter.clearList()
    }

    override fun displayItems(listItems: List<ListItem<*>>) {
        adapter.addListItems(listItems)
    }

    override fun showMainError() {

        Log.d(TAG, "showMainError:called")

        mainActivityLoadingLl.visibility = View.VISIBLE
        mainActivityRetryBtn.visibility = View.VISIBLE
        mainActivityProgressIconIv.visibility = View.VISIBLE

        mainActivityMainPb.hide()
        mainActivityProgressTextTv.text = getString(R.string.error_message)

        mainActivityRetryBtn.setOnClickListener{ presenter.onRetryBtnClick() }
    }

    override fun showError() {

        Log.d(TAG, "showError:called")
    }

    override fun showMainLoading() {

        Log.d(TAG, "showMainLoading:called")

        mainActivityLoadingLl.visibility = View.VISIBLE
        mainActivityRetryBtn.visibility = View.GONE
        mainActivityProgressIconIv.visibility = View.GONE

        mainActivityMainPb.show()
        mainActivityProgressTextTv.text = getString(R.string.loading_message)
    }

    override fun hideMainLoading() {

        Log.d(TAG, "hideMainLoading:called")

        mainActivityLoadingLl.visibility = View.GONE
    }

    override fun showLoading() {

        Log.d(TAG, "showLoading:called")

        mainActivitySrl.isRefreshing = true
    }

    override fun hideLoading() {

        Log.d(TAG, "hideLoading:called")

        mainActivitySrl.isRefreshing = false
    }
    //endregion
}
