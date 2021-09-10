package transport.factory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import transport.Factory
import transport.travel.Container
import transport.travel.Locations.*
import transport.travel.Truck

class TruckShould {
    @Test
    fun `starts at Factory`() {
        val truck = Truck(Factory())

        assertThat(truck.location).isEqualTo(Factory)
    }

    @Test
    fun `when container destination is Warehouse B and an hour passed, it is on the road`() {
        val factory = Factory()
        factory.add(Container(destination = WarehouseB))
        val truck = Truck(factory)

        truck.hourPassed()

        assertThat(truck.location).isEqualTo(OnTheRoad)
    }

    @Test
    fun `when container destination is Warehouse B and 5 hours has passed, it is on Warehouse B`() {
        val factory = Factory()
        factory.add(Container(destination = WarehouseB))
        val truck = Truck(factory)

        repeat(5) { truck.hourPassed() }

        assertThat(truck.location).isEqualTo(WarehouseB)
    }
}
