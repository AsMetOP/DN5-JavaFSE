package com.dn5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindByName() {
        User user = new User();
        user.setId(1L);
        user.setName("Aryan Samantray");
        userRepository.save(user);

        List<User> result = userRepository.findByName("Aryan Samantray");
        assertEquals(1, result.size());
        assertEquals("Aryan Samantray", result.get(0).getName());
    }
}