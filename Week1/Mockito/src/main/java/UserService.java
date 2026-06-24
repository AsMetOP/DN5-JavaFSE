public class UserService {
    private ExternalApi externalApi;

    public UserService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String processData(String input) {
        return externalApi.getData();
    }
}