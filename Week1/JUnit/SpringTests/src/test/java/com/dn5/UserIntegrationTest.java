package com.dn5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class UserIntegrationTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    UserRepository userRepository;

    @Test
    public void testFullFlow() throws Exception {
        User user = new User();
        user.setId(10L);
        user.setName("Asmet Ranjan Sahoo");
        userRepository.save(user);

        mockMvc.perform(get("/users/10"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("Asmet Ranjan Sahoo"));
    }
}