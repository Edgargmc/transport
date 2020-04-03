package useCase

import domain.*

class SendCargoesToWarehouses(private val trucks: List<Truck>, private val factory: Factory) {
    fun execute(warehouses: List<Wharehouses>): Int {
        val containers = warehouses.map { Container(it) }
        val system = TransportTycoon(this.trucks, this.factory, containers)
        return system.sendContainers()
    }
}
