package transport

class Size(var value: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Size

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

    fun incremented() = Size(++value)
}
