package useCase

import domain.Factory
import domain.Locations
import domain.Truck

class SendCargosToWarehouses(private val trucks: List<Truck>) {
    fun execute(containerDestinations: List<Locations>): Int {
        val factory = Factory(containerDestinations)
        var hours = 0
        while (!factory.allContainersDelivered()) {
            for (truck in trucks) {
                if (truck.isInFactory() && factory.hasContainerToSend()) {
                    truck.sendContainer(factory.getContainerToSend())
                }
                truck.hourPassed()
            }
            hours++
        }
        return hours
    }
}
