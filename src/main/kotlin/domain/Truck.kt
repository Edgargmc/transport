package domain

class Truck(val truckDestinationService: TruckDestinationService) {
    var container: Container? = null
    private var remainingTimeToDestination = 0
    private var destination = Destination.NONE

    fun sendContainer(container: Container) {
        this.container = container
        this.destination = this.truckDestinationService.route(container.destination)
        this.remainingTimeToDestination = this.truckDestinationService.timeToDestinationFromFactory(this.destination)
    }

    fun hourPassed() {
        if (!isTraveling()) { return }

        remainingTimeToDestination--

        if (isInWarehouse()) {
            deliverContainer()
            timeToFactory()
        }
    }

    private fun timeToFactory() {
        this.remainingTimeToDestination = truckDestinationService.timeToFactoryFromDestination(destination)
    }

    private fun deliverContainer() {
        this.container!!.delivered(this.destination)
        this.container = null
    }

    fun isInFactory() = container == null && remainingTimeToDestination == 0

    private fun isInWarehouse() = remainingTimeToDestination == 0 && this.container != null

    private fun isTraveling() = remainingTimeToDestination > 0
}
