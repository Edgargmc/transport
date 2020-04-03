package domain

import java.util.*

class Factory(private val trucks: List<Truck>) {
    private var containers = listOf<Container>()
    private val containersInFactory = Stack<Container>()

    fun allContainersDelivered() = containers.all { it.isDelivered() }
    private fun hasContainerToSend() = containersInFactory.isNotEmpty()
    private fun getContainerToSend() = containersInFactory.pop()
    fun sendContainers(destinations: List<Wharehouses>) {
        this.containers = destinations.map { Container(it) }
        containersInFactory.addAll(containers.reversed())
    }

    fun hourPassed() {
        for (truck in trucks) {
            if (truck.isInFactory() && hasContainerToSend()) {
                truck.sendContainer(getContainerToSend())
            }
        }
    }
}
