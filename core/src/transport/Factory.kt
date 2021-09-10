package transport

import transport.travel.Container
import transport.travel.Containers

class Factory {
    val containers = Containers()
    private val containerList = mutableListOf<Container>()

    fun add(containers: Containers) {
        this.containers.addAll(containers)
    }

    fun add(container: Container) {
        containerList.add(container)
    }
}
