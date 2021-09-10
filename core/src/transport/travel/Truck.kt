package transport.travel

import transport.Factory

class Truck(private val travel: Travel? = null, private val factory: Factory) {
    var location =  Location.Factory

    fun go() {
        var hours = 1
        if (travel!!.destination == Location.WarehouseB) hours = 5
        travel.incrementHours(Hours(hours))
        travel.nextLocation()
    }

    fun tick() {
        TODO("Not yet implemented")
    }
}
