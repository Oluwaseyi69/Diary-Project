package com.olofofo.services;

import com.olofofo.data.repositories.DiaryRepo;
import com.olofofo.dtos.request.request.CreateEntryRequest;
import com.olofofo.dtos.request.request.LoginRequest;
import com.olofofo.dtos.request.request.RegisterUserRequest;
import com.olofofo.exception.IncorrectDetailsException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class DiaryServiceImplTest {
    @Autowired
    private DiaryRepo diaryRepo;
    @Autowired
    private EntryServices entryServices;
    @Autowired
    private DiaryServices diaryServices;
    @BeforeEach
    public void startWith(){
        diaryRepo.deleteAll();
    }


    @Test
    public void testToRegister() {
        RegisterUserRequest registerUserRequest =new RegisterUserRequest();
        registerUserRequest.setUsername("Seyi");
        registerUserRequest.setPassword("password");

        diaryServices.register(registerUserRequest);
        assertThat(diaryRepo.count(), is(1L));

        RegisterUserRequest registerUserRequest1 =new RegisterUserRequest();
        registerUserRequest1.setUsername("akeeem");
        registerUserRequest1.setPassword("password");

        diaryServices.register(registerUserRequest1);
        assertThat(diaryRepo.count(), is(2L));
    }

    @Test
    public void testToRegisteredUserCanLockDiary(){
        RegisterUserRequest registerUserRequest =new RegisterUserRequest();
        registerUserRequest.setUsername("Tobi");
        registerUserRequest.setPassword("password");
        diaryServices.register(registerUserRequest);
        assertThat(diaryRepo.count(), is(1L));

        assertTrue(diaryServices.lock("Tobi"));

    }
    @Test
    public void testThatUserCanUnlockDiary(){
        RegisterUserRequest registerUserRequest =new RegisterUserRequest();
        registerUserRequest.setUsername("Tobi");
        registerUserRequest.setPassword("password");
        diaryServices.register(registerUserRequest);
        assertThat(diaryRepo.count(), is(1L));

        assertTrue(diaryServices.lock("Tobi"));
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Tobi");
        loginRequest.setPassword("password");
        assertTrue(diaryServices.unlock(loginRequest));

    }

    @Test
    public void testThatUserCannotUnlockDiaryWithWrongPassword(){
        RegisterUserRequest registerUserRequest =new RegisterUserRequest();
        registerUserRequest.setUsername("Tobi");
        registerUserRequest.setPassword("password");
        diaryServices.register(registerUserRequest);
        assertThat(diaryRepo.count(), is(1L));

        assertTrue(diaryServices.lock("Tobi"));

        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("Tobi");
        loginRequest.setPassword("pasword");
        assertThrows(IncorrectDetailsException.class,()->diaryServices.unlock(loginRequest));

    }


//    @Test
//    public void saveMoreThanOneDiary(){
//        diaryServices.register(registerUserRequest);
//        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
//        diaryServices.register(registerUserRequest1);
//        assertEquals(2,diaryServices.count());
//
//    }
//
//    @Test
//    public void testForUniqueUsername(){
//        diaryServices.register(registerUserRequest);
//
//        assertThrows(IllegalArgumentException.class,
//                ()->{diaryServices.register(registerUserRequest);});
//        assertEquals(1,diaryServices.count());
//
//    }
//    @Test
//    public void testThatUserCanBeCreatedAndFound(){
//        diaryServices.register(registerUserRequest);
//        assertEquals("Username", diaryServices.findBy("Username").getUsername());
//    }
//    @Test
//    public void testThatUserCanBeDeleted(){
//        diaryServices.register(registerUserRequest);
//        diaryServices.delete("Username", "Password");
//        assertEquals(0,diaryServices.count());
//
//
//    }
//    @Test
//    public void testToSearch_A_DeletedDiary(){
//        diaryServices.register(registerUserRequest);
//        RegisterUserRequest registerUserRequest1 = new RegisterUserRequest();
//        diaryServices.register(registerUserRequest1);
//
//        diaryServices.delete("Username", "Password");
//        assertEquals(1, diaryServices.count());
//
//    }
//
//    @Test
//    public void testToDeleteDiaryWithWrongPassword(){
//        diaryServices.register(registerUserRequest);
//        assertThrows(IllegalArgumentException.class,
//                ()-> diaryServices.delete("Seyi", "passwo"));
//
//    }
//
//    @Test
//    public void testToChangePassword(){
//        diaryServices.register(registerUserRequest);
//        diaryServices.update("Username", "Password", "newPassword");
//        assertThrows(IllegalArgumentException.class,
//                ()-> diaryServices.delete("Username", "Password"));
//        assertEquals(1, diaryServices.count());
//
//
//    }





}