package transport.factory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import transport.Factory
import transport.travel.*
import transport.travel.Location.*

class TruckShould {
    @Test
    fun `starts at Factory`() {
        val truck = Truck()

        assertThat(truck.location).isEqualTo(Factory)
    }

    @Test
    fun `starts trip to WarehouseB when container is available in Factory`() {
        val factory = Factory()
        factory.add(Container(WarehouseB))
        val truck = Truck(factory = factory)

        truck.tick()

        assertThat(truck.location).isEqualTo(OnTheRoad)
    }

    @Test
    fun `Takes an hour to the Port`() {
        val travel = createTravel(WarehouseA)

        Truck(travel).go()

        assertThat(travel.hours).isEqualTo(Hours(1))
    }

    @Test
    fun `Takes five hours to B`() {
        val travel = createTravel(WarehouseB)

        Truck(travel).go()

        assertThat(travel.hours).isEqualTo(Hours(5))
    }

    private fun createTravel(destination: Location, containers: Int = 1): Travel {
        val containersList = Containers()
        repeat(containers) {
            containersList.add(Container(WarehouseB))
        }
        return Travel(destination, containersList)
    }
}
