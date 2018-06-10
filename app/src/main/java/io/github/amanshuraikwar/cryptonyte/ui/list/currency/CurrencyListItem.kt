package io.github.amanshuraikwar.cryptonyte.ui.list.currency

import io.github.amanshuraikwar.cryptonyte.model.Currency
import io.github.amanshuraikwar.cryptonyte.ui.list.ListItem
import io.github.amanshuraikwar.cryptonyte.ui.list.ListItemTypeFactory
import io.github.amanshuraikwar.cryptonyte.ui.list.SimpleListItemOnClickListener

/**
 * Created by amanshuraikwar on 11/03/18.
 */
class CurrencyListItem(val currency: Currency)
    : ListItem<SimpleListItemOnClickListener>() {

    override fun type(typeFactory: ListItemTypeFactory): Int {
        return typeFactory.type(this)
    }
}