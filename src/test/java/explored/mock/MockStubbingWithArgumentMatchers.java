package explored.mock;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.internal.matchers.GreaterThan;

import java.math.BigDecimal;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockStubbingWithArgumentMatchers {

    @Test
    public void anything() {

        BigDecimal mockedBigDecimal = mock(BigDecimal.class);

        when(mockedBigDecimal.pow(ArgumentMatchers.any(Integer.class))).thenReturn(BigDecimal.ONE);
        when(mockedBigDecimal.pow(ArgumentMatchers.anyInt())).thenReturn(BigDecimal.ONE);

        assertThat(mockedBigDecimal.pow(5), Is.is(BigDecimal.ONE));
    }

    @Test
    @SuppressWarnings("ConstantConditions")
    public void argumentThat() {

        BigDecimal mockedBigDecimal = mock(BigDecimal.class);

        when(mockedBigDecimal.pow(ArgumentMatchers.intThat(new GreaterThan<>(10)))).thenReturn(BigDecimal.ONE);
        when(mockedBigDecimal.add(ArgumentMatchers.argThat(new GreaterThan<>(BigDecimal.TEN)))).thenReturn(BigDecimal.ONE);

        assertThat(mockedBigDecimal.pow(50), Is.is(BigDecimal.ONE));
        assertThat(mockedBigDecimal.pow(1), IsNull.nullValue());

        assertThat(mockedBigDecimal.add(BigDecimal.valueOf(50)), Is.is(BigDecimal.ONE));
        assertThat(mockedBigDecimal.add(BigDecimal.ONE), IsNull.nullValue());
    }

    @Test
    public void equal() {

        BigDecimal mockedBigDecimal = mock(BigDecimal.class);

        when(mockedBigDecimal.pow(ArgumentMatchers.eq(1))).thenReturn(BigDecimal.ONE);

        assertThat(mockedBigDecimal.pow(1), Is.is(BigDecimal.ONE));
        assertThat(mockedBigDecimal.pow(2), IsNull.nullValue());
    }
}
