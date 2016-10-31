package explored.stubbing;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsNull;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.internal.stubbing.answers.CallsRealMethods;
import org.mockito.internal.stubbing.answers.DoesNothing;
import org.mockito.internal.stubbing.answers.Returns;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;

public class MockStubbing {

    @Test
    public void stubbedMethodsDefaultBehavior() {

        List mockedList = mock(List.class);

        assertThat(mockedList.isEmpty(), Is.is(false));
        assertThat(mockedList.size(), Is.is(0));
        assertThat(mockedList.subList(0, 10).size(), Is.is(0));
        assertThat(mockedList.iterator(), IsNull.nullValue());
    }

    @Test
    public void stubbedMethodsOverridingDefaultBehavior() {

        List mockedList = mock(List.class, Mockito.RETURNS_DEFAULTS);
        assertThat(mockedList.iterator(), IsNull.nullValue());

        mockedList = mock(List.class, Mockito.RETURNS_SMART_NULLS);
        assertThat(mockedList.iterator(), IsNull.notNullValue());
    }

    @Test
    public void stubbingOfNonVoidMethodsUsingMockedInterface() {

        List mockedList = mock(List.class);

        // then - using implementations of Answer
        when(mockedList.isEmpty()).then(new Returns(true));
        // thenAnswer - using implementations of Answer
        when(mockedList.isEmpty()).thenAnswer(new Returns(true));

        // thenReturn
        when(mockedList.isEmpty()).thenReturn(true);
        when(mockedList.isEmpty()).thenReturn(true, false, true, false);

        // thenThrow
        when(mockedList.isEmpty()).thenThrow(new RuntimeException(), new NullPointerException());
    }

    @Test
    public void stubbingOfNonVoidMethodsUsingMockedConcreteClass() {

        List mockedList = mock(ArrayList.class);

        when(mockedList.isEmpty()).thenCallRealMethod();
        when(mockedList.isEmpty()).then(new CallsRealMethods());
    }

    @Test
    public void stubbingOfVoidMethods() {

        List mockedList = mock(ArrayList.class);

        doNothing().when(mockedList).clear();
        doAnswer(new DoesNothing()).when(mockedList).clear();
        doCallRealMethod().when(mockedList).clear();
        doThrow(new NullPointerException()).when(mockedList).clear();
    }
}
