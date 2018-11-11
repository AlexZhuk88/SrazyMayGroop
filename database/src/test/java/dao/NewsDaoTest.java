package dao;

import dao.newsprofile.NewsDao;
import dao.newsprofile.NewsDaoImpl;
import dao.userprofile.UserDao;
import dao.userprofile.UserDaoImpl;
import model.TheNew;
import model.Timing;
import model.User;
import org.junit.Test;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class NewsDaoTest {


    @Test
    public void checkGetById() {
        NewsDao newsDao = new NewsDaoImpl();
        TheNew newsTest = newsDao.find(8L);
        assertEquals(newsTest.getNewsname(), "TestNews3");
    }

    @Test
    public void checkGetByNewsname() {
        NewsDaoImpl newsDao = new NewsDaoImpl();
        TheNew newsTest = newsDao.getByUsername("TestNews2");
        assertEquals(newsTest.getDiscription(), "new Discription");
    }

    @Test
    public void checkSave() {
        UserDao userDao = new UserDaoImpl();
        User userTest = userDao.find(1L);

        NewsDao newsDao = new NewsDaoImpl();

        TheNew newsCorrect = TheNew.builder().newsname("MegaTestNews").discription("Test Discription").timing(Timing.of(LocalDate.now(), LocalTime.now())).user(userTest).build();
        Serializable id = newsDao.save(newsCorrect);
        assertNotNull(id);
        newsDao.delete(newsCorrect);
    }

    @Test
    public void checkDelete() {
        NewsDaoImpl newsDao = new NewsDaoImpl();
        TheNew newsDelete = TheNew.builder().newsname("TestForDelete").build();
        newsDao.save(newsDelete);
        TheNew newsTest = newsDao.getByUsername("TestForDelete");
        newsDao.delete(newsTest);
    }

    @Test
    public void checkFindAll() {
        NewsDao newsDao = new NewsDaoImpl();
        List<TheNew> list = newsDao.findAll();
        assertNotNull(list);
    }

    @Test
    public void checkUpdate() {
        NewsDao newsDao = new NewsDaoImpl();
        TheNew newsTest = newsDao.find(7L);
        newsTest.setDiscription("new Discription");
        newsDao.update(newsTest);
        assertEquals(newsTest.getDiscription(), "new Discription");
    }
}