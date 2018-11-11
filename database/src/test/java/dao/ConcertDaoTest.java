package dao;

import dao.concertprofile.ConcertDao;
import dao.concertprofile.ConcertDaoImpl;
import dao.groopprofile.GroopDao;
import dao.groopprofile.GroopDaoImpl;
import model.Concert;
import model.Groop;
import model.Timing;
import org.junit.Test;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ConcertDaoTest {


    @Test
    public void checkGetById() {
        ConcertDao concertDao = new ConcertDaoImpl();
        Concert concertTest = concertDao.find(3L);
        assertEquals(concertTest.getConcertName(), "First concert");
    }

    @Test
    public void checkGetUsername() {
        ConcertDaoImpl concertDao = new ConcertDaoImpl();
        Concert concertTest = concertDao.getByConcertNname("First concert");
        assertEquals(concertTest.getDiscription(), "My discription");
    }

    @Test
    public void checkSave() {
        GroopDao groopDao = new GroopDaoImpl();
        Groop groopTest = groopDao.find(1L);
        ConcertDao concertDao = new ConcertDaoImpl();
        Concert concertCorrect = Concert.builder().concertName("Third concert").timing(Timing.of(LocalDate.now(), LocalTime.now())).groop(groopTest).build();
        Serializable id = concertDao.save(concertCorrect);
        assertNotNull(id);
        concertDao.delete(concertCorrect);
    }

    @Test
    public void checkDelete() {
//        GroopDao groopDao = new GroopDaoImpl();
//        Groop groopTest = groopDao.find(1L);
//        ConcertDaoImpl concertDao = new ConcertDaoImpl();
//        Concert concertDelete = Concert.builder().concertName("DeletedConcert").groop(groopTest).build();
//        concertDao.save(concertDelete);
//        Concert concertTest = concertDao.getByConcertNname("TestForDelete");
//        concertDao.delete(concertTest);
    }

    @Test
    public void checkFindAll() {
        ConcertDao concertDao = new ConcertDaoImpl();
        List<Concert> list = concertDao.findAll();
        assertNotNull(list);
    }

    @Test
    public void checkUpdate() {
        ConcertDao concertDao = new ConcertDaoImpl();
        Concert concertTest = concertDao.find(5L);
        concertTest.setDiscription("My discription");
        concertDao.update(concertTest);
        assertEquals(concertTest.getDiscription(), "My discription");
    }
}