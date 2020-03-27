package domain

import java.util.*

class Factory(containerLocations: List<ContainerLocation>) {
    private val containers = containerLocations.map { Container(it) }
    private val containersInFactory = Stack<Container>()

    init {
        containersInFactory.addAll(containers.reversed())
    }

    fun hasContainerToSend() = containersInFactory.isNotEmpty()
    fun allContainersDelivered() = containers.all { it.isDelivered() }
    fun getContainerToSend() = containersInFactory.pop()
}
