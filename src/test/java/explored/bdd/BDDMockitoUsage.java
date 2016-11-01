package explored.bdd;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class BDDMockitoUsage {

    @Mock
    private BigDecimal bigDecimal;

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @Test
    public void givenWhenThen() {

        // given
        given(bigDecimal.abs()).willReturn(BigDecimal.ONE);

        // when
        bigDecimal.abs();

        // then
        then(bigDecimal).should(times(1)).abs();
    }
}
