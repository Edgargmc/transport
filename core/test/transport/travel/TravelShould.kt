package transport.travel

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class TravelShould {
    @Test
    fun `start with 0 hours`() {
        assertThat(Travel(location, containers).hours).isEqualTo(Hours(0))
    }

    @Test
    fun `start in Factory Location`() {
        assertThat(Travel(location, containers).location).isEqualTo(Location.Factory)
    }

    @ParameterizedTest
    @CsvSource(
        "B, B",
        "A, Port",
    )
    fun `can changes your location to next`(destiny: Location, nextLocation: Location) {
        val travel = Travel(destiny, containers)

        travel.nextLocation()

        assertThat(travel.location).isEqualTo(nextLocation)
    }

    private val location = Location.A
    private val containers = Containers()
}