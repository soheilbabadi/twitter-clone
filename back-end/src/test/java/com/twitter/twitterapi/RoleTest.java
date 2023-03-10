package com.twitter.twitterapi;

import com.twitter.twitterapi.model.Role;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import jakarta.persistence.EntityManager;

@ExtendWith(MockitoExtension.class)
public class RoleTest {

    @Mock
    private EntityManager entityManager;

    @InjectMocks
    private Role role;

    @Test
    public void testRoleEntity() {
        role.setId(1L);
        role.setAuthority("ADMIN");

        when(entityManager.find(Role.class, 1L)).thenReturn(role);

        Role foundRole = entityManager.find(Role.class, 1L);

        assertEquals(role, foundRole);
        assertEquals("ADMIN", foundRole.getAuthority());
    }
}
