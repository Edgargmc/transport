package transport.travel

import transport.Size


class Containers {
    private val containers = mutableListOf<Container>()

    fun add(container: Container) {
        containers.add(container)
    }

    fun addAll(containers: Containers) {
        this.containers.addAll(containers.containers)
    }

    fun size(): Size {
        return Size(this.containers.size)
    }
}

class Container(WarehouseB: Location)
