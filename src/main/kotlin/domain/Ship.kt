package domain

class Ship {
    var container: Container? = null
    private var remainingTimeToDestination = 0
    private var destination = Locations.FACTORY

    fun sendContainer(container: Container) {
        this.container = container
        this.destination = container.destination
        this.remainingTimeToDestination = destination.hours
    }

    fun hourPassed() {
        if (!isTraveling()) { return }

        remainingTimeToDestination--

        if (isInWarehouse()) {
            deliverContainer()
        }
    }

    private fun deliverContainer() {
        val timeToFactory = this.container!!.destination.hours
        this.remainingTimeToDestination = timeToFactory
        this.container!!.delivered(this.destination)
        this.container = null
    }

    private fun isInWarehouse() = remainingTimeToDestination == 0 && this.container != null

    private fun isTraveling() = remainingTimeToDestination > 0
}
