package explored.capture;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentCaptorUsage {

    @Mock
    private BigDecimal mockedBigDecimal;

    @Captor
    private ArgumentCaptor<BigDecimal> bigDecimalCaptor;

    private ArgumentCaptor<Integer> intCaptor = ArgumentCaptor.forClass(Integer.class);

    @Test
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createdWithFactoryMethod() {

        // given
        when(mockedBigDecimal.pow(anyInt())).thenReturn(BigDecimal.TEN);

        // when
        mockedBigDecimal.pow(5);

        // then
        verify(mockedBigDecimal).pow(intCaptor.capture());
        assertThat(intCaptor.getValue(), Is.is(5));
    }

    @Test
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void createdWithAnnotation() {

        // given
        when(mockedBigDecimal.add(any(BigDecimal.class))).thenReturn(BigDecimal.TEN);

        // when
        mockedBigDecimal.add(BigDecimal.ONE);

        // then
        verify(mockedBigDecimal).add(bigDecimalCaptor.capture());
        assertThat(bigDecimalCaptor.getValue(), Is.is(BigDecimal.ONE));
    }
}
