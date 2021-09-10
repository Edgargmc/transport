package transport.travel

class Truck(private val travel: Travel) {
    fun go() {
        var hours = 1
        if (travel.destination == Location.B) hours = 5
        travel.incrementHours(Hours(hours))
        travel.nextLocation()
    }
}
