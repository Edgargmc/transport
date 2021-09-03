package transport

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TruckShould {

    @Test
    fun `Takes an hour to the Port`() {
        val containers = Containers().add(Container())
        val travel = Travel(Destiny.A, containers)
        Truck(travel).go()

        assertThat(travel.time).isEqualTo(1)
    }
}