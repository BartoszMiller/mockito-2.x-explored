package explored.stubbing;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.hamcrest.MockitoHamcrest;

import java.math.BigDecimal;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockStubbingWithHamcrestMatchers {

    @Test
    public void withHamcrest() {

        BigDecimal mockedBigDecimal = mock(BigDecimal.class);

        when(mockedBigDecimal.pow(MockitoHamcrest.intThat(Is.is(1)))).thenReturn(BigDecimal.ONE);

        assertThat(mockedBigDecimal.pow(1), Is.is(BigDecimal.ONE));
        assertThat(mockedBigDecimal.pow(2), IsNull.nullValue());
    }
}
