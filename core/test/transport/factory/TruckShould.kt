package transport.factory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import transport.travel.*

class TruckShould {
    @Test
    fun `starts at Factory`() {
        val truck = Truck()

        assertThat(truck.currentLocation).isEqualTo(Location.Factory)
    }


    @Test
    fun `Takes an hour to the Port`() {
        val travel = createTravel(Location.A)

        Truck(travel).go()

        assertThat(travel.hours).isEqualTo(Hours(1))
    }

    @Test
    fun `Takes five hours to B`() {
        val travel = createTravel(Location.B)

        Truck(travel).go()

        assertThat(travel.hours).isEqualTo(Hours(5))
    }

    private fun createTravel(destination: Location, containers: Int = 1): Travel {
        val containersList = Containers()
        repeat(containers) {
            containersList.add(Container())
        }
        return Travel(destination, containersList)
    }
}
