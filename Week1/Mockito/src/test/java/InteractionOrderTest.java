import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InteractionOrderTest {
    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        NotificationService mockNotification = mock(NotificationService.class);

        when(mockApi.getData()).thenReturn("Data for Asmet Ranjan Sahoo");

        mockApi.getData();
        mockNotification.sendNotification("Notifying Keshi Jain");

        InOrder inOrder = inOrder(mockApi, mockNotification);
        inOrder.verify(mockApi).getData();
        inOrder.verify(mockNotification).sendNotification("Notifying Keshi Jain");
    }
}