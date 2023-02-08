package money.currency

import java.util.Locale

// TODO: Handle precision in the format string.
// https://fastspring.com/blog/how-to-format-30-currencies-from-countries-all-over-the-world/

abstract class Currency(val locale: Locale, vararg val patterns: String) {

    override fun toString() = this.javaClass.simpleName

    object CHF : Currency(
        Locale.GERMAN,
        "fr. ###,##0.00",
        "Fr ###,##0.00",
        "CHF ###,##0.00",
    )

    object CNY : Currency(
        Locale.CHINA,
        "¥ ###,##0.00",
        "###,##0.00 元",
        "CNY ###,##0.00",
    )

    object EUR : Currency(
        Locale.GERMAN,
        "###,##0.00 €",
        "###,##0.00 €",
        "EUR ###,##0.00",
    )

    object GBP : Currency(
        Locale.UK,
        "£###,##0.00",
        "£###,##0.00",
        "GBP ###,##0.00",
    )

    object JPY : Currency(
        Locale.JAPAN,
        "###,##0.## 円",
        "¥ ###,##0.##",
        "JPY ###,##0.##",
    )

    object KRW : Currency(
        Locale.KOREA,
        "####,##0.## 원",
        "₩ ####,##0.##",
        "KRW ####,##0.##",
    )

    object USD : Currency(
        Locale.US,
        "$###,##0.00",
        "US$ ###,##0.00",
        "USD ###,##0.00",
    )
}