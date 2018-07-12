package io.github.amanshuraikwar.cryptonyte.ui.list;

import android.view.View;

import io.github.amanshuraikwar.cryptonyte.ui.list.currency.CurrencyListItem;
import io.github.amanshuraikwar.cryptonyte.ui.list.currency.CurrencyViewHolder;

/**
 * List item type factory responsible for getting layout id and ViewHolder instance.
 *
 * @author Amanshu Raikwar
 * Created by amanshuraikwar on 20/12/17.
 */

public class ListItemTypeFactory {

    public int type(CurrencyListItem item) {
        return 0;
    }

    /**
     * To get layout file id (R.layout.*) for a corresponding list item/view type.
     *
     * @param viewType list item/view type.
     * @return layout file id corresponding to list item/view type.
     */
    int getLayout(int viewType) {
        switch (viewType) {
            case 0:
                return CurrencyViewHolder.Companion.getLAYOUT();
            default:
                return 0;
        }
    }

    /**
     * To get ViewHolder instance for corresponding list item/view type.
     *
     * @param parent parent view instance to instantiate corresponding ViewHolder instance.
     * @param type list item/view type of which the ViewHolder instance is needed.
     * @return ViewHolder instance for the given list item/view type.
     */
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
