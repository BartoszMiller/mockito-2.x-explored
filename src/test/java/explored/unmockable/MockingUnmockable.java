package explored.unmockable;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class MockingUnmockable {

    @Mock
    private Bird bird;

    @Test
    public void mockCustomFinalClass() {

        // given
        given(bird.sing()).willReturn("chirp");

        // when
        String sing = bird.sing();

        // then
        assertThat(sing, is("chirp"));
    }
}

final class Bird {

    final String sing() {
        return "tweet";
    }
}