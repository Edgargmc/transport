package transport.factory

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import transport.Factory
import transport.travel.Containers

class FactoryShould {

    @Test
    fun `receive list of containers`() {
        val containers = Containers()

        val factory = Factory()

        assertThat(factory.containers.size).isEqualTo(1)
    }
}