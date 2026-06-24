import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class VoidMethodExceptionTest {
    @Test
    public void testVoidMethodThrowsException() {
        NotificationService mockService = mock(NotificationService.class);

        doThrow(new RuntimeException("Notification failed for Asmet Ranjan Sahoo"))
            .when(mockService).sendNotification("Asmet Ranjan Sahoo");

        RuntimeException ex = assertThrows(RuntimeException.class, () ->
            mockService.sendNotification("Asmet Ranjan Sahoo")
        );

        assertEquals("Notification failed for Asmet Ranjan Sahoo", ex.getMessage());
        verify(mockService).sendNotification("Asmet Ranjan Sahoo");
    }
}