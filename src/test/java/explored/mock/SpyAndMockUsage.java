package explored.mock;

import org.hamcrest.core.IsNull;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

public class SpyAndMockUsage {

    @Mock
    private List mockedList;

    @Spy
    private Set spiedSet = new HashSet<>();

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void initializationTest() {

        assertNotNull(mockedList);
        assertNotNull(spiedSet);

        assertThat(mockedList.toArray(), IsNull.nullValue()); // default Mock behaviour
        assertThat(spiedSet.toArray(), IsNull.notNullValue()); // calling real method
    }
}
