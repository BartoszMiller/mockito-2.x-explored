package explored.verification;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MockVerificationInOrder {

    @Test
    public void multipleMocksInOrder() {

        List mockedList = mock(List.class);
        Set mockedSet = mock(Set.class);

        mockedList.clear();
        mockedSet.isEmpty();

        InOrder inOrder = Mockito.inOrder(mockedList, mockedSet);

        inOrder.verify(mockedList).clear();
        inOrder.verify(mockedSet).isEmpty();
    }

    @Test
    public void withoutOrder() {

        List mockedList = mock(List.class);

        mockedList.clear();
        mockedList.isEmpty();

        // verification order and duplicates don't matter
        verify(mockedList).isEmpty();
        verify(mockedList).clear();
        verify(mockedList).clear();
    }
}
