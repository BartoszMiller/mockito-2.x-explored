package explored.mock;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.AbstractList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SpyAndMockUsage {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    // one-liner
    @Mock
    private List oneLineMock = when(mock(List.class).isEmpty()).thenReturn(Boolean.TRUE).getMock();

    @Mock
    private List mockedList;

    @Mock
    private AbstractList mockedAbstractClass;

    @Spy
    private Set spiedSet = new HashSet<>();

    @Spy
    private HashSet spiedHashSet;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // or @Rule or @RunWith
    }

    @Test
    public void initializationTest() {

        assertNotNull(mockedList);
        assertNotNull(mockedAbstractClass);
        assertNotNull(spiedSet);

        assertThat(mockedList.toArray(), IsNull.nullValue()); // default Mock behaviour
        assertThat(spiedSet.toArray(), IsNull.notNullValue()); // calling real method
    }
}
