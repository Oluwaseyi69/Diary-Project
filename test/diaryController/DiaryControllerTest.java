package diaryController;

import controllers.DiaryController;
import dtos.request.LoginRequest;
import dtos.request.RegisterUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DiaryControllerTest {
    private DiaryController diaryController;
    private RegisterUserRequest registerUserRequest;
    private LoginRequest loginRequest;

    @BeforeEach
    public void startWith(){
        diaryController = new DiaryController();

        registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("Username");
        registerUserRequest.setPassword("Password");

        loginRequest = new LoginRequest();
        loginRequest.setUsername("Username");
        loginRequest.setPassword("Password");

    }
    @Test
    public void testToRegister(){
        String actual = diaryController.registerUser(registerUserRequest);
        assertEquals("Registered Successful", actual);
    }

    @Test
    public void testThatDiaryIsLocked(){
       diaryController.registerUser(registerUserRequest);
        String actual = diaryController.registerUser(registerUserRequest);
        assertEquals("Registered Successful", actual);

        String name = diaryController.lockDiary("Username");
        assertEquals("Locked", name);
    }

    @Test
    public void testThat_I_CanUnlockDiary(){
        diaryController.registerUser(registerUserRequest);
        String unlock = diaryController.unlockDiary(loginRequest);
        assertEquals("Diary Unlocked", unlock);
    }
}
