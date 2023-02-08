package money.currency

import money.Money
import org.jetbrains.annotations.NotNull
import java.math.BigDecimal
import java.math.BigInteger

data class ConversionRate<C1, C2>(
    @NotNull val source: C1,
    @NotNull val target: C2,
    @NotNull val factor: BigDecimal
) where C1 : Currency, C2 : Currency {

    constructor(
        @NotNull source: C1,
        @NotNull target: C2,
        @NotNull factor: Int
    ) : this(source, target, factor.toBigDecimal())

    constructor(
        @NotNull source: C1,
        @NotNull target: C2,
        @NotNull factor: Long
    ) : this(source, target, factor.toBigDecimal())

    constructor(
        @NotNull source: C1,
        @NotNull target: C2,
        @NotNull factor: Float
    ) : this(source, target, factor.toBigDecimal())

    constructor(
        @NotNull source: C1,
        @NotNull target: C2,
        @NotNull factor: Double
    ) : this(source, target, factor.toBigDecimal())

    constructor(
        @NotNull source: C1,
        @NotNull target: C2,
        @NotNull factor: BigInteger
    ) : this(source, target, factor.toBigDecimal())

    fun convert(@NotNull money: Money<C1>) =
        Money(money.amount * factor, target)
}
