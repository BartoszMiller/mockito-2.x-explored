package explored.capture;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ArgumentCaptorUsage {

    @Mock
    private BigDecimal mockedBigDecimal;

    @Test
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public void captureArgument() {

        when(mockedBigDecimal.pow(anyInt())).thenReturn(BigDecimal.TEN);

        mockedBigDecimal.pow(5);

        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(mockedBigDecimal).pow(argumentCaptor.capture());

        assertThat(argumentCaptor.getValue(), Is.is(5));
    }
}
