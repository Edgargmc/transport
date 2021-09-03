package transport.travel

class Hours(private val value: Int) {
    fun increment(quantity: Hours): Hours {
        return Hours(value + quantity.value)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Hours

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }


}
