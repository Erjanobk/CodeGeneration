package Model;

import io.swagger.model.UserToCreate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

class UserToCreateTest {

        private UserToCreate userToCreate;
        @BeforeEach
        private void newUser() {
            userToCreate = new UserToCreate();
        }
        @Test
        private void UserToCreateCanNotBeNull(){
            assertNotNull(userToCreate);
        }

}