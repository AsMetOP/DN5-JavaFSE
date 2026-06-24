import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MultipleReturnsTest {
    @Test
    public void testMultipleReturnValues() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData())
            .thenReturn("First Call - Asmet Ranjan Sahoo")
            .thenReturn("Second Call - Keshi Jain");

        MyService service = new MyService(mockApi);

        assertEquals("First Call - Asmet Ranjan Sahoo", service.fetchData());
        assertEquals("Second Call - Keshi Jain", service.fetchData());
    }
}