package domain

class Container(val destination: Wharehouses) {
    var delivered = false
        private set

    fun delivered() {
        this.delivered = true
    }

    fun isDelivered() = delivered
}
