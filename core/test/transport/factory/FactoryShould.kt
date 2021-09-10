package transport.factory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import transport.Factory
import transport.Size
import transport.travel.Container
import transport.travel.Containers

class FactoryShould {

    @Test
    fun `receive list of containers`() {
        val containers = Containers()
        containers.add(Container())

        val factory = Factory()
        factory.add(containers)

        assertThat(factory.containers.size()).isEqualTo(Size(1))
    }
}