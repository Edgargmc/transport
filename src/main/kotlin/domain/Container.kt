package domain

class Container(val location: ContainerLocation) {
    var currentLocation = ContainerLocation.FACTORY
        private set

    fun delivered(destination: ContainerLocation) {
        currentLocation = destination
    }

    fun isDelivered() = currentLocation == location
}
