package transport.factory

import GPS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import transport.Route
import transport.travel.Hours
import transport.travel.Locations

class MapTest {
    @Test
    fun `travel duration from Factory to Warehouse B is 5 hours`() {
        val route = Route(Locations.Factory, Locations.WarehouseB, Hours(5))
        val gps = GPS()
        gps.add(route)
        val duration = gps.duration(beginning = Locations.Factory, destination = Locations.Port)

        assertThat(duration).isEqualTo(Hours(5))
    }

    @Test
    fun `travel duration from Factory to Port is 1 hour`() {
        val gps = GPS()

        val duration = gps.duration(beginning = Locations.Factory, destination = Locations.Port)

        assertThat(duration).isEqualTo(Hours(1))
    }
}
