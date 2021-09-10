package transport

import transport.travel.Container
import transport.travel.Containers

class Factory {
    val containers = Containers()

    fun add(containers: Containers) {
        this.containers.addAll(containers)
    }

    fun add(container: Container) {
        TODO("Not yet implemented")
    }
}
