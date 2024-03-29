package transport.factory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import transport.Size
import transport.travel.Container
import transport.travel.Containers
import transport.travel.Locations

class ContainersShould {
    @Test
    fun `start without containers`() {
        val containers = Containers()

        assertThat(containers.size()).isEqualTo(Size(0))
    }

    @Test
    fun `add containers`() {
        val containers = Containers()

        containers.add(Container(Locations.WarehouseB))

        assertThat(containers.size()).isEqualTo(Size(1))
    }
}