package dev.mourao.movies.services;

import dev.mourao.movies.domain.User;
import dev.mourao.movies.domain.UserRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Autowired
    private UserService userService;
    private AutoCloseable autoCloseable;
    private final MongoTemplate templateMock = mock(MongoTemplate.class);

    @BeforeEach
    void setupEach() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        userService = new UserService(userRepository, templateMock);
    }

    @AfterEach
    void tearDownEach() throws Exception {
        autoCloseable.close();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetAll() {
        userService.getAll();
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetById() {
        userService.getById(ObjectId.get());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testGetByName() {
        userService.getByName("Name");
    }

    @Test
    void testCreate() {
        var user = new User("Name", "example@email.com", "pass123", "Roles");
        userService.create(user);
        ArgumentCaptor<User> userArgCaptor = ArgumentCaptor.forClass(User.class);
        verify(userRepository).insert(userArgCaptor.capture());
        User capturedUser = userArgCaptor.getValue();
        assertThat(capturedUser).isEqualTo(user);
    }

    @Test
    void testThrowException() {
        //given(userService.getThrow()).willReturn(false);

        assertThatThrownBy(() -> userService.getThrow())
                .isInstanceOf(IllegalStateException.class)
                .hasMessage("Bad operation executed");
    }
    @Test
    @Disabled("TODO: Complete this test")
    void testUpdate() {

        userService.update(ObjectId.get(), "Name", "jane.doe@example.org", "iloveyou", "Roles");
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testDelete() {

        userService.delete(ObjectId.get());
    }
}

