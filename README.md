# ddd-money
An experimental type-safe implementation of a money type in Kotlin Inspired by [[1]](#1). 

The basic idea is to facilitate generics to specify the actual currency of the money type:

```kotlin
data class Money<C>(
    @NotNull val amount: BigDecimal,
    @NotNull val currency: C
) where C : Currency
```

where the currencies are defined as:

```kotlin
abstract class Currency {
    object CHF : Currency
    object CNY : Currency
    object EUR : Currency
    object GBP : Currency
    object JPY : Currency
    object KRW : Currency
    object USD : Currency
}
```

This prohibits operations on money with different currencies.

## References
<a id="1">[1]</a> Mathias Verraes. *Emergent Contexts through Refinement*. [Domain-Driven Design: The First 15 Years](http://leanpub.com/ddd_first_15_years).