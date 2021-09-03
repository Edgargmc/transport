package transport.factory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import transport.Size
import transport.travel.Container
import transport.travel.Containers

class ContainersShould {
    @Test
    fun `start without containers`() {
        val containers = Containers()

        assertThat(containers.size).isEqualTo(Size(0))
    }

    @Test
    fun `add containers`() {
        val containers = Containers()

        containers.add(Container())

        assertThat(containers.size).isEqualTo(Size(1))
    }
}