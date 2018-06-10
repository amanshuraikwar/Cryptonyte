package io.github.amanshuraikwar.cryptonyte.ui.list.currency

import android.content.res.ColorStateList
import android.support.annotation.LayoutRes
import android.support.v4.app.FragmentActivity
import android.support.v4.content.ContextCompat
import android.view.View
import io.github.amanshuraikwar.cryptonyte.R
import io.github.amanshuraikwar.cryptonyte.model.Currency
import io.github.amanshuraikwar.cryptonyte.ui.list.ViewHolder
import kotlinx.android.synthetic.main.item_currency.view.*

/**
 * Created by amanshuraikwar on 11/03/18.
 */
class CurrencyViewHolder(itemView: View) : ViewHolder<CurrencyListItem>(itemView) {

    companion object {
        @LayoutRes
        val LAYOUT = R.layout.item_currency
    }

    override fun bind(listItem: CurrencyListItem,
                      host: FragmentActivity) {

        val currency = listItem.currency

        itemView.itemCurrencySymbolTv.text = currency.symbol
        itemView.itemCurrencyNameTv.text = currency.name
        itemView.itemCurrencyExchangeRateTv.text =
                StringBuilder(host.getString(R.string.dollar_sign)+""+currency.priceUsd).toString()
        itemView.itemCurrency24hTv.text = StringBuffer("${currency.percentageChange24h}%").toString()
        itemView.itemCurrency7dTv.text = StringBuffer("${currency.percentageChange7d}%").toString()

        if (currency.percentageChange1h.toDouble() < 0) {

            itemView
                    .itemCurrencyTrendIv
                    .setImageDrawable(host.getDrawable(R.drawable.ic_arrow_drop_down_black_24dp))

            itemView
                    .itemCurrencyTrendIv
                    .imageTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(host, R.color.red))
        } else {

            itemView
                    .itemCurrencyTrendIv
                    .setImageDrawable(host.getDrawable(R.drawable.ic_arrow_drop_up_black_24dp))

            itemView
                    .itemCurrencyTrendIv
                    .imageTintList =
                    ColorStateList.valueOf(ContextCompat.getColor(host, R.color.green))
        }

        try {

            if (currency.percentageChange24h.toDouble() < 0) {

                itemView
                        .itemCurrency24hTv
                        .setTextColor(ContextCompat.getColor(host, R.color.red))

                itemView
                        .itemCurrency24hTv
                        .setBackgroundColor(ContextCompat.getColor(host, R.color.veryLightRed))
            } else {

                itemView
                        .itemCurrency24hTv
                        .setTextColor(ContextCompat.getColor(host, R.color.green))

                itemView
                        .itemCurrency24hTv
                        .setBackgroundColor(ContextCompat.getColor(host, R.color.veryLightGreen))
            }
        } catch (e:Exception) {

        }

        if (currency.percentageChange7d.toDouble() < 0) {

            itemView
                    .itemCurrency7dTv
                    .setTextColor(ContextCompat.getColor(host, R.color.red))

            itemView
                    .itemCurrency7dTv
                    .setBackgroundColor(ContextCompat.getColor(host, R.color.veryLightRed))
        } else {

            itemView
                    .itemCurrency7dTv
                    .setTextColor(ContextCompat.getColor(host, R.color.green))

            itemView
                    .itemCurrency7dTv
                    .setBackgroundColor(ContextCompat.getColor(host, R.color.veryLightGreen))
        }
    }
}