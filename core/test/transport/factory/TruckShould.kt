package transport.factory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import transport.travel.*

class TruckShould {
    @Test
    fun `Takes an hour to the Port`() {
        val containers = Containers()
        containers.add(Container())
        val travel = Travel(Location.A, containers)

        Truck(travel).go()

        assertThat(travel.hours).isEqualTo(Hours(1))
    }

}