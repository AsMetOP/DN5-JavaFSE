import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.atMost;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ArgumentMatchingTest {
    @Test
    public void testArgumentMatching() {
        ExternalApi mockApi = Mockito.mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("Mock Data");

        UserService service = new UserService(mockApi);
        service.processData("Asmet");
        service.processData("Keshi");

        verify(mockApi, times(2)).getData();
        verify(mockApi, atLeastOnce()).getData();
        verify(mockApi, atMost(3)).getData();
    }
}