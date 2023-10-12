package services;

import dtos.request.CreateEntryRequest;
import dtos.request.LoginRequest;
import dtos.request.RegisterUserRequest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryServiceImplTest {
    private DiaryServices diaryServices;
    private RegisterUserRequest registerUserRequest;
    private LoginRequest loginRequest;
    private CreateEntryRequest createEntryRequest;

    @BeforeEach
    public void startWith(){
        diaryServices = new DiaryServiceImpl();

        registerUserRequest = new RegisterUserRequest();
        registerUserRequest.setUsername("Username");
        registerUserRequest.setPassword("Password");

        loginRequest = new LoginRequest();
        loginRequest.setUsername("Username");
        loginRequest.setPassword("Password");

        createEntryRequest = new CreateEntryRequest();
        createEntryRequest.setOwnerName("OwnerName");
        createEntryRequest.setBody("Body");
        createEntryRequest.setTitle("Title");
    }


    @Test
    public void testToRegister() {
        diaryServices.register(registerUserRequest);
        assertEquals(1,diaryServices.count());
    }

    @Test
    public void saveMoreThanOneDiary(){
        diaryServices.register(registerUserRequest);
        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
        diaryServices.register(registerUserRequest1);
        assertEquals(2,diaryServices.count());

    }

    @Test
    public void testForUniqueUsername(){
        diaryServices.register(registerUserRequest);

        assertThrows(IllegalArgumentException.class,
                ()->{diaryServices.register(registerUserRequest);});
        assertEquals(1,diaryServices.count());

    }
    @Test
    public void testThatUserCanBeCreatedAndFound(){
        diaryServices.register(registerUserRequest);
        assertEquals("Username", diaryServices.findBy("Username").getUsername());
    }
    @Test
    public void testThatUserCanBeDeleted(){
        diaryServices.register(registerUserRequest);
        diaryServices.delete("Username", "Password");
        assertEquals(0,diaryServices.count());


    }
    @Test
    public void testToSearch_A_DeletedDiary(){
        diaryServices.register(registerUserRequest);
        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
        diaryServices.register(registerUserRequest1);

        diaryServices.delete("Username", "Password");
        assertEquals(1, diaryServices.count());

    }

    @Test
    public void testToDeleteDiaryWithWrongPassword(){
        diaryServices.register(registerUserRequest);
        assertThrows(IllegalArgumentException.class,
                ()-> diaryServices.delete("Seyi", "passwo"));

    }

    @Test
    public void testToChangePassword(){
        diaryServices.register(registerUserRequest);
        diaryServices.update("Username", "Password", "newPassword");
        assertThrows(IllegalArgumentException.class,
                ()-> diaryServices.delete("Username", "Password"));
        assertEquals(1, diaryServices.count());


    }





}