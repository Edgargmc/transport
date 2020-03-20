package domain

class Container(val destination: Locations) {
    var currentLocation = Locations.FACTORY
        private set

    fun delivered() {
        currentLocation = destination
    }

    fun isDelivered() = currentLocation == destination
}
