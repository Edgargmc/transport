package transport.travel

class Truck(private val travel: Travel) {
    fun go() {
        travel.incrementHours(Hours(1))
        travel.nextLocation()
    }
}
