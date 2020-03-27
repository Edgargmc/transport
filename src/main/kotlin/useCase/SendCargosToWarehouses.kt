package useCase

import domain.*

class SendCargosToWarehouses(private val trucks: List<Truck>) {
    fun execute(containerLocations: List<ContainerLocation>): Int {
        val factory = Factory(containerLocations)
        var hours = 0
        while (!factory.allContainersDelivered()) {

            for (truck in trucks) {
                if (truck.isInFactory() && factory.hasContainerToSend()) {
                    val container = factory.getContainerToSend()
                    truck.sendContainer(container, resolveTruckDestination(container))
                }
                truck.hourPassed()
            }

            hours++
            if(hours == 50) break
        }
        return hours
    }

    private fun resolveTruckDestination(container: Container): Locations {
        if (container.location == Locations.WAREHOUSE_B) return Locations.WAREHOUSE_B
        if (container.location == Locations.WAREHOUSE_A) return Locations.PORT
        return Locations.FACTORY
    }
}
