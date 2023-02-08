package money

import money.currency.Currency
import money.currency.Currency.*
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.math.BigInteger
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.NumberFormat
import java.util.Locale

data class Money<C>(
    @NotNull val amount: BigDecimal,
    @NotNull val currency: C
) where C : Currency {

    constructor(
        @NotNull amount: Int,
        @NotNull currency: C
    ) : this(amount.toBigDecimal(), currency)

    constructor(
        @NotNull amount: Long,
        @NotNull currency: C
    ) : this(amount.toBigDecimal(), currency)

    constructor(
        @NotNull amount: Float,
        @NotNull currency: C
    ) : this(amount.toBigDecimal(), currency)

    // Use toBigDecimal to avoid imprecise conversion of doubles.
    // See: https://stackoverflow.com/questions/58444837/is-there-any-elegant-ways-to-convert-int-to-bigdecimal-in-kotlin
    constructor(
        @NotNull amount: Double,
        @NotNull currency: C
    ) : this(amount.toBigDecimal(), currency)

    constructor(
        @NotNull amount: BigInteger,
        @NotNull currency: C
    ) : this(amount.toBigDecimal(), currency)

    operator fun unaryMinus() = Money(-amount, currency)

    operator fun plus(@NotNull money: Money<C>) =
        Money(amount + money.amount, currency)

    operator fun minus(@NotNull money: Money<C>) =
        Money(amount - money.amount, currency)

    operator fun times(@NotNull factor: Int) =
        Money(factor.toBigDecimal() * amount, currency)

    operator fun times(@NotNull factor: Long) =
        Money(factor.toBigDecimal() * amount, currency)

    operator fun times(@NotNull factor: Float) =
        Money(factor.toBigDecimal() * amount, currency)

    operator fun times(@NotNull factor: Double) =
        Money(factor.toBigDecimal() * amount, currency)

    operator fun times(@NotNull factor: BigInteger) =
        Money(factor.toBigDecimal() * amount, currency)

    operator fun times(@NotNull factor: BigDecimal) =
        Money(factor * amount, currency)

    // TODO: Division?
    //       Money / Num => Money
    //       Money / Money => BigDecimal

    override fun toString(): String {
//        val format = NumberFormat.getCurrencyInstance()
//        format.maximumFractionDigits = 0
//        format.currency = java.util.Currency.getInstance("EUR")
//        return format.format(amount)
        val formatter = DecimalFormat(
            "###,##0.##",
            DecimalFormatSymbols.getInstance(Locale.FRANCE)
        )
        return formatter.format(amount)
    }// = "$currency ${amount.round(MathContext(currency.precision + 2))}"
}

operator fun <C> Int.times(@NotNull money: Money<C>) where C : Currency = money * this
operator fun <C> Long.times(@NotNull money: Money<C>) where C : Currency = money * this
operator fun <C> Float.times(@NotNull money: Money<C>) where C : Currency = money * this
operator fun <C> Double.times(@NotNull money: Money<C>) where C : Currency = money * this
operator fun <C> BigInteger.times(@NotNull money: Money<C>) where C : Currency = money * this
operator fun <C> BigDecimal.times(@NotNull money: Money<C>) where C : Currency = money * this

fun Int.EUR() = Money(this, EUR)
fun Long.EUR() = Money(this, EUR)
fun Float.EUR() = Money(this, EUR)
fun Double.EUR() = Money(this, EUR)
fun BigInteger.EUR() = Money(this, EUR)
fun BigDecimal.EUR() = Money(this, EUR)