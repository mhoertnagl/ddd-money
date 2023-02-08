package money.forex

import money.currency.ConversionRate
import money.currency.Currency
import java.math.BigDecimal
import java.math.BigInteger
import java.util.*

typealias ForexTable = HashMap<Pair<Currency, Currency>, BigDecimal>

fun ForexTable.add(source: Currency, target: Currency, factor: Int): ForexTable {
    this[Pair(source, target)] = factor.toBigDecimal()
    return this
}

fun ForexTable.add(source: Currency, target: Currency, factor: Long): ForexTable {
    this[Pair(source, target)] = factor.toBigDecimal()
    return this
}

fun ForexTable.add(source: Currency, target: Currency, factor: Float): ForexTable {
    this[Pair(source, target)] = factor.toBigDecimal()
    return this
}

fun ForexTable.add(source: Currency, target: Currency, factor: Double): ForexTable {
    this[Pair(source, target)] = factor.toBigDecimal()
    return this
}

fun ForexTable.add(source: Currency, target: Currency, factor: BigInteger): ForexTable {
    this[Pair(source, target)] = factor.toBigDecimal()
    return this
}

fun ForexTable.add(source: Currency, target: Currency, factor: BigDecimal): ForexTable {
    this[Pair(source, target)] = factor
    return this
}

class TableForex(private val table: ForexTable) : Forex {

    override fun <C1 : Currency, C2 : Currency>
            getRate(source: C1, target: C2)
            : Optional<ConversionRate<C1, C2>> {

        val key = Pair(source, target)
        val factor = table[key]

        if (factor != null) {
            val rate = ConversionRate(source, target, factor)
            return Optional.of(rate)
        }
        return Optional.empty()
    }
}
