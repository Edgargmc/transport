package newKata

import domain.Container
import domain.Destination
import domain.Wharehouses
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class ContainerTest {
    @Test
    fun `verify correct delivered when delivery in Whare House B`() {
        val container = Container(Wharehouses.B)
        container.delivered(Destination.WHAREHOUSEB)

        assertThat(container.isDelivered()).isTrue()
    }

    @Test
    fun `verify correct delivered when delivery in Port`() {
        val container = Container(Wharehouses.A)
        container.delivered(Destination.PORT)

        assertThat(container.isDelivered()).isFalse()
    }

    @Test
    fun `verify correct delivered when delivery in Whare House A`() {
        val container = Container(Wharehouses.A)
        container.delivered(Destination.WHAREHOUSEA)

        assertThat(container.isDelivered()).isTrue()
    }
}
