package domain

import java.util.*

class Port {
    private val containersInPort = Stack<Container>()

    fun registerContainer(container: Container?) {
        this.containersInPort.add(container)
    }

    fun hasContainerToSend() = containersInPort.isNotEmpty()

    fun getContainerToSend() = containersInPort.pop()!!
}
