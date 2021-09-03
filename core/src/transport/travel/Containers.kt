package transport.travel

import transport.Size


class Containers {
    var size: Size = Size(0)
    private val containers = mutableListOf<Container>()

    fun add(container: Container) {
        containers.add(container)
        size = size.incremented()
    }
}

class Container
