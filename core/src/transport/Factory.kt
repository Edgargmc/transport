package transport

import transport.travel.Containers

class Factory {
    val containers = Containers()

    fun add(containers: Containers) {
        this.containers.addAll(containers)
    }
}
