package io.github.amanshuraikwar.cryptonyte.ui.list;

import android.view.View;

import io.github.amanshuraikwar.cryptonyte.ui.list.currency.CurrencyListItem;
import io.github.amanshuraikwar.cryptonyte.ui.list.currency.CurrencyViewHolder;

/**
 * Created by amanshuraikwar on 20/12/17.
 */

public class ListItemTypeFactory {

    public int type(CurrencyListItem item) {
        return 0;
    }

    int getLayout(int viewType) {
        switch (viewType) {
            case 0:
                return CurrencyViewHolder.Companion.getLAYOUT();
            default:
                return 0;
        }
    }

    ViewHolder createViewHolder(View parent, int type) {

        ViewHolder viewHolder = null;

        switch (type) {
            case 0:
                viewHolder = new CurrencyViewHolder(parent);
                break;
        }

        return viewHolder;
    }
}
