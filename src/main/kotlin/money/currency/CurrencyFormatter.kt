package money.currency

import misc.downToZero
import java.math.BigDecimal
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

// A currency can have multiple currency symbols.
// see https://en.wikipedia.org/wiki/Currency_symbol
// A currency can have a symbol for a singular and a plural value.
//
// $0.00 | $ 0.00 | ###,##0.00$ | 0+(\.0*)? | (0*\.)?0+
// 0$00 | 0 $ 00

// https://stackoverflow.com/questions/45592109/how-can-i-convert-numbers-to-currency-format-in-android
// var formatter = DecimalFormat("###,###,##0.00")

class CurrencyFormatter(private val currency: Currency) {

    private val regex = Regex("[0#,.]")
    private val symbols = DecimalFormatSymbols.getInstance(currency.locale)

    fun format(amount: BigDecimal): String {
        val pattern = regex.find(currency.patterns[0])!!.value
        val formatter = DecimalFormat(pattern, symbols)
        return formatter.format(amount)
    }

//    private val regex = Regex("[0#,.]")
//    private val numPattern = regex.find(currency.pattern)!!.value
//    private val formatter = DecimalFormat(numPattern, DecimalFormatSymbols.getInstance(Locale.FRANCE))
//
//    fun format(amount: BigDecimal) = currency.pattern
//        .let { formatSymbol("$", it) }
//        .let { formatSymbol("¤", it) }
//        .let { formatNumber(amount, it) }
//
//    private fun formatSymbol(symbol: String, pattern: String) =
//        downToZero(currency.symbols.size).fold(pattern) { p, i ->
//            p.replace(symbol.repeat(i), currency.symbols[i])
//        }
//
//    private fun formatNumber(amount: BigDecimal, pattern: String) =
//        pattern.replace(numPattern, formatter.format(amount))
}
