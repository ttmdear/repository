package com.ttmdear.repository.tests.services.impl;

import com.ttmdear.repository.tests.domain.User;
import com.ttmdear.repository.tests.domain.UserStatus;
import com.ttmdear.repository.tests.repositories.UserRepository;
import com.ttmdear.repository.tests.services.UserService;
import com.ttmdear.repository.tests.services.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserServiceImplTest {

    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        // Inicjujemy makity na postawie adnotacji.
        MockitoAnnotations.initMocks(this);

        userService = new UserServiceImpl(userRepository);
    }

    @Test
    void find() {
        Set<User> users = new HashSet<User>() {{
            add(new User("1", "Paweł", "Kowalski", UserStatus.ACTIVE));
        }};

        when(userRepository.findAll()).thenReturn(users);

        Set<User> result = userService.find();

        assertEquals(1, result.size());

        verify(userRepository, times(1)).findAll();
    }

    @Test
    void whenCaseThenReturn() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        when(userRepository.findAll()).thenReturn(new HashSet<User>(){{
            add(new User("1", "Paweł", "Kowalski", UserStatus.ACTIVE));
            add(new User("2", "Krystyna", "Iksińska", UserStatus.ACTIVE));
            add(new User("3", "Daniel", "Kotyła", UserStatus.ACTIVE));
        }});

        Set<User> users = userRepository.findAll();

    }

    @Test()
    void whenCaseThenThrow() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        when(userRepository.findAll()).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                return null;
            }
        });

        when(userRepository.findAll()).thenThrow(new RuntimeException("Method not implemented"));
        // doThrow(new RuntimeException("Method not implemented")).when(userRepository).findAll();

        RuntimeException runtimeException = null;

        try {
            userRepository.findAll();
        } catch (RuntimeException e) {
            runtimeException = e;
        }

        assertNotNull(runtimeException);
    }

    @Test()
    void whenCaseThenAnswer() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        final Set<User> users = new HashSet<User>(){{
            add(new User("967a0a57-ba3e-4276-b2fe-1e340582bca2", "Paweł", "Kowalski", UserStatus.ACTIVE));
            add(new User("46fb231f-c323-4332-a195-0bc9b93b91b9", "Justyna", "Iksińska", UserStatus.ACTIVE));
            add(new User("1950af9b-9c89-4d9b-8813-00f2ff8ee690", "Kasia", "Wrona", UserStatus.ACTIVE));
        }};

        when(userRepository.findById(anyString())).thenAnswer(new Answer<User>() {
            @Override
            public User answer(InvocationOnMock invocationOnMock) throws Throwable {
                String id = (String) invocationOnMock.getArguments()[0];

                Optional<User> result = users.stream().filter(u -> u.getId().equals(id)).findFirst();

                if (result.isPresent()) {
                    return result.get();
                } else {
                    return null;
                }
            }
        });

        assertNotNull(userRepository.findById("967a0a57-ba3e-4276-b2fe-1e340582bca2"));
        assertNotNull(userRepository.findById("46fb231f-c323-4332-a195-0bc9b93b91b9"));
        assertNotNull(userRepository.findById("1950af9b-9c89-4d9b-8813-00f2ff8ee690"));
        assertNull(userRepository.findById("1950af9b-9c89-4d9b-8813-00f2ff8ee691"));
    }

    @Test()
    void verifyTimes() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        userRepository.findAll();

        verify(userRepository, times(1)).findAll();
    }

    @Test()
    void verifyArgumentCaptor() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserServiceImpl(userRepository);

        User user = new User("1", "Paweł", "Kowalsk", UserStatus.DEACTIVE);

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

        userService.active(user);

        verify(userRepository, times(1)).save(userArgumentCaptor.capture());

        assertEquals(UserStatus.ACTIVE, userArgumentCaptor.getValue().getStatus());
    }
}