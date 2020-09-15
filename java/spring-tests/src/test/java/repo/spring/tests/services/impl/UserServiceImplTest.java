package repo.spring.tests.services.impl;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import repo.spring.tests.domain.User;
import repo.spring.tests.domain.UserStatus;
import repo.spring.tests.repositories.UserRepository;
import repo.spring.tests.services.UserGroupService;
import repo.spring.tests.services.UserService;
import repo.spring.tests.services.UserServiceImpl;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    private UserServiceImpl userService;

    @Test
    void doReturnCase() {
        UserGroupService userGroupService = Mockito.mock(UserGroupService.class);

        Mockito.doReturn("Jacek").when(userGroupService).getAdminName();

        assertEquals("Jacek", userGroupService.getAdminName());
    }

    @Test
    void doVoid() {
        User user = Mockito.mock(User.class);

        // Nie zastosujemy when w przypadku metod, które nic nie zwracają ponieważ when wymaga aby metoda
        // coś zwracała
        // Mockito.when(user.validatePermissio("A")).thenThrow(new RuntimeException("No permission"));
        //              ^^^^^^^^^^^^^^^^^^^^^^^^^^^

        // Możemy ro rozwiązać za pomodą doXXX
        Mockito.doThrow(new RuntimeException("No permission")).when(user).validatePermissio("A");

        assertThrows(RuntimeException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                user.validatePermissio("A");
            }
        });
    }

    @Test
    void doThrowCase() {
        UserGroupService userGroupService = Mockito.mock(UserGroupService.class);

        Mockito.doThrow(new IllegalArgumentException()).when(userGroupService).getAdminRole(null);

        assertThrows(IllegalArgumentException.class, () -> userGroupService.getAdminRole(null));
    }

    @Test
    void find() {
        Set<User> users = new HashSet<User>() {{
            add(new User("1", "Paweł", "Kowalski", UserStatus.ACTIVE));
        }};

        Mockito.when(userRepository.findAll()).thenReturn(users);

        Set<User> result = userService.find();

        assertEquals(1, result.size());

        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

    @BeforeEach
    void setUp() {
        // Inicjujemy makity na postawie adnotacji.
        MockitoAnnotations.initMocks(this);

        userService = new UserServiceImpl(userRepository);
    }

    @Test()
    void verifyArgumentCaptor() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);
        UserService userService = new UserServiceImpl(userRepository);

        User user = new User("1", "Paweł", "Kowalsk", UserStatus.DEACTIVE);

        ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);

        userService.active(user);

        Mockito.verify(userRepository, Mockito.times(1)).save(userArgumentCaptor.capture());

        assertEquals(UserStatus.ACTIVE, userArgumentCaptor.getValue().getStatus());
    }

    @Test()
    void verifyTimes() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        userRepository.findAll();

        Mockito.verify(userRepository, Mockito.times(1)).findAll();
    }

    @Test()
    void whenCaseThenAnswer() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        final Set<User> users = new HashSet<User>() {{
            add(new User("967a0a57-ba3e-4276-b2fe-1e340582bca2", "Paweł", "Kowalski", UserStatus.ACTIVE));
            add(new User("46fb231f-c323-4332-a195-0bc9b93b91b9", "Justyna", "Iksińska", UserStatus.ACTIVE));
            add(new User("1950af9b-9c89-4d9b-8813-00f2ff8ee690", "Kasia", "Wrona", UserStatus.ACTIVE));
        }};

        Mockito.when(userRepository.findById(Mockito.anyString())).thenAnswer(new Answer<User>() {
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

    @Test
    void whenCaseThenReturn() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        Mockito.when(userRepository.findAll()).thenReturn(new HashSet<User>() {{
            add(new User("1", "Paweł", "Kowalski", UserStatus.ACTIVE));
            add(new User("2", "Krystyna", "Iksińska", UserStatus.ACTIVE));
            add(new User("3", "Daniel", "Kotyła", UserStatus.ACTIVE));
        }});
    }

    @Test()
    void whenCaseThenThrow() {
        UserRepository userRepository = Mockito.mock(UserRepository.class);

        Mockito.when(userRepository.findAll()).thenAnswer(new Answer<String>() {
            @Override
            public String answer(InvocationOnMock invocationOnMock) throws Throwable {
                return null;
            }
        });

        Mockito.when(userRepository.findAll()).thenThrow(new RuntimeException("Method not implemented"));

        RuntimeException runtimeException = null;

        try {
            userRepository.findAll();
        } catch (RuntimeException e) {
            runtimeException = e;
        }

        assertNotNull(runtimeException);
    }
}