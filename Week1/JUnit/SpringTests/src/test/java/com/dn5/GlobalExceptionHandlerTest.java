package com.dn5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import java.util.NoSuchElementException;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
public class GlobalExceptionHandlerTest {
    @Autowired
    MockMvc mockMvc;

    @MockBean
    UserService userService;

    @Test
    public void testNotFoundHandler() throws Exception {
        when(userService.getUserOrThrow(99L))
            .thenThrow(new NoSuchElementException("User not found"));

        mockMvc.perform(get("/users/99"))
               .andExpect(status().isNotFound())
               .andExpect(content().string("User not found"));
    }
}