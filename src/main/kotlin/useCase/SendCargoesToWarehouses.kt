package useCase

import domain.Factory
import domain.Truck
import domain.Wharehouses

class SendCargoesToWarehouses(private val trucks: List<Truck>, private val factory: Factory) {
    fun execute(warehouses: List<Wharehouses>): Int {
        factory.sendContainers(warehouses)
        var hours = 0
        while (!factory.allContainersDelivered()) {
            factory.hourPassed()
            for (truck in trucks) {
                truck.hourPassed()
            }
            hours++
        }
        return hours
    }
}
