package services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiaryServiceImplTest {
    private DiaryServices diaryServices;

    @BeforeEach
    public void startWith(){
        diaryServices = new DiaryServiceImpl();
    }


    @Test
    public void testToRegister() {
        diaryServices.register("Seyi", "password");
        diaryServices.register("Tomide","password");
        diaryServices.register("kevin","pass");

        assertEquals(3,diaryServices.count());

    }

    @Test
    public void testForUniqueUsername(){
        diaryServices.register("Esther", "password");

        assertThrows(IllegalArgumentException.class,
                ()->{diaryServices.register("Esther", "password");});
        assertEquals(1,diaryServices.count());

    }
    @Test
    public void testThatUserCanBeCreatedAndFound(){
        diaryServices.register("Seyi", "password");
        assertEquals("Seyi", diaryServices.findBy("Seyi").getUsername());
    }
    @Test
    public void testThatUserCanBeDeleted(){
        diaryServices.register("Esther", "password");
        assertEquals("Esther", diaryServices.findBy("Esther").getUsername());
        diaryServices.delete("Esther", "password");
        assertEquals(0,diaryServices.count());


    }
    @Test
    public void testToSearch_A_DeletedDiary(){
        diaryServices.register("Seyi", "password");
        diaryServices.register("Esther", "password");
        assertEquals(2, diaryServices.count());

        diaryServices.delete("Seyi", "password");
        assertThrows(IllegalArgumentException.class,
                ()-> diaryServices.findBy("Seyi"));
    }

    @Test
    public void testToDeleteDiaryWithWrongPassword(){
        diaryServices.register("Seyi", "password");
        assertThrows(IllegalArgumentException.class,
                ()-> diaryServices.delete("Seyi", "passwo"));

    }

    @Test
    public void testToChangePassword(){
        diaryServices.register("Seyi", "Password");
        diaryServices.update("Seyi", "Password", "newPassword");
        assertThrows(IllegalArgumentException.class,
                ()-> diaryServices.delete("Seyi", "Password"));
        assertEquals(1, diaryServices.count());


    }





}