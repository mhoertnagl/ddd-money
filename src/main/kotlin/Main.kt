import money.*
import money.currency.Currency.*
import money.forex.*

// TODO: Currency to division and vice versa conversion

fun main(args: Array<String>) {

    val table = ForexTable()
        .add(EUR, USD, 1.094546456)

    val forex = TableForex(table)
    val rate = forex.getRate(EUR, USD)
    val amount = 5000000.EUR() + 6000000.EUR()

    println(amount)

    rate.map { it.convert(amount) }
        .ifPresentOrElse(
            { println(it) },
            { println("Cannot exchange your money.") }
        )
}
