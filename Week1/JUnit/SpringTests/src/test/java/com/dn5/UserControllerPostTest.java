package com.dn5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class UserControllerPostTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    public void testCreateUser() throws Exception {
        User user = new User();
        user.setId(2L);
        user.setName("Keshi Jain");
        when(userService.saveUser(any(User.class))).thenReturn(user);

        mockMvc.perform(post("/users")
               .contentType(MediaType.APPLICATION_JSON)
               .content("{\"id\":2,\"name\":\"Keshi Jain\"}"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("Keshi Jain"));
    }
}