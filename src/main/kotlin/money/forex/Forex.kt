package money.forex

import money.currency.ConversionRate
import money.currency.Currency
import java.util.*

interface Forex {

    fun <C1, C2> getRate(source: C1, target: C2)
            : Optional<ConversionRate<C1, C2>>
            where C1 : Currency,
                  C2 : Currency
}
