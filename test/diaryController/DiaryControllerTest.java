package diaryController;

import controllers.DiaryController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DiaryControllerTest {
    private DiaryController diaryController;

    @BeforeEach
    public void startWith(){
        diaryController = new DiaryController();
    }
    @Test
    public void testToRegister(){
        String actual = diaryController.registerUser("Seyi", "Password");
        assertEquals("Registered Successful", actual);
    }

    @Test
    public void testThatDiaryIsLocked(){
       diaryController.registerUser("Seyi", "Password");
        String name = diaryController.lockDiary("Seyi");
        assertEquals("Locked", name);
    }

    @Test
    public void testThat_I_CanUnlockDiary(){
        diaryController.registerUser("Seyi", "Password");
        String unlock = diaryController.unlockDiary("Seyi", "Password");
        assertEquals("Diary Unlocked", unlock);
    }
}
