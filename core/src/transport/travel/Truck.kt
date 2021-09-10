package transport.travel

import transport.Factory

class Truck(private val factory: Factory) {
    var location =  Locations.Factory
        private set

    fun hourPassed() {
//        timeTraveled++
//        val travelDuration = map.travelDuration(from = location, to = cargo.destination)
//        if(travelDuration == timeTraveled) location = cargo.destination
//        else location = ontheroad
        location = Locations.OnTheRoad
    }
}
