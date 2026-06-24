import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class VoidMethodTest {
    @Test
    public void testVoidMethod() {
        NotificationService mockService = mock(NotificationService.class);

        doNothing().when(mockService).sendNotification("Hello Asmet Ranjan Sahoo");

        mockService.sendNotification("Hello Asmet Ranjan Sahoo");

        verify(mockService).sendNotification("Hello Asmet Ranjan Sahoo");
    }
}