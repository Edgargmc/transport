package domain

class Truck(val truckDestinationService: TruckDestinationService) {
    var container: Container? = null
    private var remainingTimeToDestination = 0
    private var destination = TruckDestination.NONE

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
        }
    }

    private fun deliverContainer() {
        val timeToFactory = this.truckDestinationService.timeToFactoryFromDestination(this.destination)
        this.remainingTimeToDestination = timeToFactory
        this.container!!.delivered()
        this.container = null
    }

    fun isInFactory() = container == null && remainingTimeToDestination == 0

    private fun isInWarehouse() = remainingTimeToDestination == 0 && this.container != null

    private fun isTraveling() = remainingTimeToDestination > 0
}
