package transport

class Truck(private val travel: Travel) {
    fun go() {
        travel.time = 1
    }
}
