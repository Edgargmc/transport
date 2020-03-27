package useCase

import domain.*

class SendCargosToWarehouses(private val trucks: List<Truck>, private val ships: List<Ship>) {
    fun execute(containerDestinations: List<Locations>): Int {
        val factory = Factory(containerDestinations)
        var hours = 0
        while (!factory.allContainersDelivered()) {

            for (truck in trucks) {
                if (truck.isInFactory() && factory.hasContainerToSend()) {
                    val container = factory.getContainerToSend()
                    truck.sendContainer(container, resolveTruckDestination(container))
                }
                if (truck.isInPort()) {
                    port.registerContainer(truck.container)
                }
                truck.hourPassed()
            }

            for (ship in ships) {
                if (port.hasContainerToSend()) {
                    val container = port.getContainerToSend()
                    ship.sendContainer(container)
                }
                ship.hourPassed()
            }
            hours++
            if(hours == 50) break
        }
        return hours
    }

    private fun resolveTruckDestination(container: Container): Locations {
        if (container.destination == Locations.WAREHOUSE_B) return Locations.WAREHOUSE_B
        if (container.destination == Locations.WAREHOUSE_A) return Locations.PORT
        return Locations.FACTORY
    }
}
