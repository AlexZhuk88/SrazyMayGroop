package dao.concertprofile;

import dao.baseprofile.BaseDaoImpl;
import lombok.Cleanup;
import model.Concert;
import org.hibernate.Session;

import static connection.ConnectionManager.getSession;

public class ConcertDaoImpl extends BaseDaoImpl<Long, Concert> implements ConcertDao {
    private static final ConcertDao INSTANCE = new ConcertDaoImpl();

    public Concert getByConcertNname(String concertName) {
        @Cleanup Session session = getSession();
        return session.createQuery("select c from Concert c where c.concertName = :concertName", Concert.class)
                .setParameter("concertName", concertName).getSingleResult();
    }

    public static ConcertDao getInstance() {
        return INSTANCE;
    }
}
