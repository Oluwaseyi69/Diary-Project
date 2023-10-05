import data.models.Diary;
import data.repositories.DiaryRepo;
import data.repositories.DiaryRepoImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class DiaryRepoImplTest {
    private DiaryRepo diaryRepo;
    @BeforeEach
    public void diary(){
        diaryRepo = new DiaryRepoImplementation();
    }
    @Test
    public void testThatICanSaveDiary(){
        Diary diary = new Diary();
        diaryRepo.save(diary);
        Assertions.assertEquals(1, diaryRepo.count());
    }

    @Test
    public void testToSearchSavedDiary(){
        Diary diary = new Diary();
        diary.setUsername("Seyi");
        diary.setPassword("password");
        diaryRepo.save(diary);
        Assertions.assertEquals(1, diaryRepo.count());
        Assertions.assertEquals("Seyi",diaryRepo.getBy(1).getUsername());
    }

    @Test
    public void testToDiaryCanBeUpdated(){
        Diary diary = new Diary();
        diary.setUsername("Seyi");
        diary.setPassword("password");
        diaryRepo.save(diary);
        Assertions.assertEquals(1, diaryRepo.count());
        Assertions.assertEquals("Seyi",diaryRepo.getBy(1).getUsername());

        Diary diary1 = new Diary();
        diary1.setUsername("Seyi");
        diary1.setPassword("password");
        diaryRepo.save(diary1);
        Assertions.assertEquals(2,diaryRepo.count());
        System.out.println(diary1);
        Assertions.assertEquals("Seyi",diaryRepo.getBy(2).getUsername());

    }

    @Test
    public void testToDiaryCanBeDeleted(){
        Diary diary = new Diary();
        diary.setUsername("Seyi");
        diary.setPassword("password");
        diaryRepo.save(diary);
        Assertions.assertEquals(1, diaryRepo.count());
        Assertions.assertEquals("Seyi",diaryRepo.getBy(1).getUsername());

        Diary diary1 = new Diary();
        diary1.setUsername("Seyi");
        diary1.setPassword("password");
        diaryRepo.save(diary1);
        Assertions.assertEquals(2,diaryRepo.count());
        Assertions.assertEquals("Seyi",diaryRepo.getBy(2).getUsername());

        diaryRepo.delete(diary1);
        Assertions.assertNotNull(diaryRepo.getBy(1));

    }


}
