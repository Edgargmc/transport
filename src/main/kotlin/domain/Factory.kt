package domain

import java.util.*

class Factory(private val trucks: List<Truck>) {
    private val containersInFactory = Stack<Container>()

    private fun hasContainerToSend() = containersInFactory.isNotEmpty()
    private fun getContainerToSend() = containersInFactory.pop()
    fun sendContainers(containers: List<Container>) {
        containersInFactory.addAll(containers.reversed())
    }
// crear un stack de camiones, para usar los disponibles
    fun hourPassed() {
        for (truck in trucks) {
            if (truck.isInFactory() && hasContainerToSend()) {
                truck.sendContainer(getContainerToSend())
            }
        }
    }
}
