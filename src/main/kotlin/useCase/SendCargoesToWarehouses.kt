package useCase

import domain.Factory
import domain.Truck
import domain.Wharehouses

class SendCargoesToWarehouses(private val trucks: List<Truck>, private val factory: Factory) {
    fun execute(containers: List<Wharehouses>): Int {
        factory.registerContainers(containers)
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
