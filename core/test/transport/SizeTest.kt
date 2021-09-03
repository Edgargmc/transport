package transport

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SizeTest {
    @Test
    fun `equals returns true with equal values`() {
        assertThat(Size(0)).isEqualTo(Size(0))
    }

    @Test
    fun `increments a size on one`() {
        assertThat(Size(0).incremented()).isEqualTo(Size(1))
    }
}