package domain

class TransportTycoon(private val trucks: List<Truck>, private val factory: Factory, private val containers: List<Container>) {
    fun sendContainers(): Int {
        factory.sendContainers(containers)
        var hours = 0
        while (!allContainersDelivered()) {
            factory.hourPassed()
            for (truck in trucks) {
                truck.hourPassed()
            }
            hours++
            if (hours > 50) break
        }
        return hours
    }
    private fun allContainersDelivered() = containers.all { it.isDelivered() }
}
