package explored.verification;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class MockVerification {

    @Test
    public void called() {

        List mockedList = mock(List.class);
        mockedList.clear();

        // verify(mock)
        verify(mockedList).clear();

        // verify(mock, VerificationMode)
        verify(mockedList, Mockito.atLeastOnce()).clear();
        verify(mockedList, Mockito.atLeast(1)).clear();
        verify(mockedList, Mockito.atMost(1)).clear();
        verify(mockedList, Mockito.times(1)).clear();
        verify(mockedList, Mockito.only()).clear();

        // verifyNoMoreInteractions(mock)
        verifyNoMoreInteractions(mockedList);
    }

    @Test
    public void notCalled() {

        List mockedList = mock(List.class);

        verify(mockedList, Mockito.never()).clear();
        verifyZeroInteractions(mockedList);
    }
}
