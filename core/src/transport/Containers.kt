package transport

class Containers {
    private val containers = mutableListOf<Container>()

    fun add(container: Container) {
        containers.add(container)
    }
}

class Container
