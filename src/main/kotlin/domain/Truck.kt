package domain

class Truck {
    private var container: Container? = null
    private var remainingTimeToDestination = 0

    fun sendContainer(container: Container) {
        this.container = container
        this.remainingTimeToDestination = container.destination.hours
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
        this.container!!.delivered()
        this.container = null
    }

    fun isInFactory() = container == null && remainingTimeToDestination == 0

    private fun isInWarehouse() = remainingTimeToDestination == 0 && this.container != null

    private fun isTraveling() = remainingTimeToDestination > 0
}
