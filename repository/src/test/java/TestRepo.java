import com.sarabadani.commons.repository.StudentRepository;
import com.sarabadani.onlinecademy.model.student.Grade;
import com.sarabadani.onlinecademy.model.student.Student;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.Date;
import java.util.List;

/**
 * Author: Soroosh Sarabadani
 * Date: 12/26/12
 * Time: 3:58 PM
 */
@ContextConfiguration(locations = "classpath*:data-test-context.xml")
public class TestRepo extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    StudentRepository studentRepository;


/*    @Test
    @Rollback(false)
    @Ignore
    public void t() {
        Student student = new Student("soroosh","sarabadani","soroosh.sarabadani@gmail.com",new Date(), Grade.MASTER);
        sessionFactory.getCurrentSession().merge(student);
        ;
        BigInteger result = (BigInteger) sessionFactory.getCurrentSession().createSQLQuery("SELECT count(*) from student").uniqueResult();
        System.out.println(result);
    }*/

    @Test
    @Rollback(false)
    public void v() {
        studentRepository.save(new Student("soroosh", "sarabadani", "soroosh.sarabadani@gmail.com", new Date(), Grade.MASTER));
        List<Student> all = studentRepository.findAll();
        System.out.println(all.size());
    }

    @Test
    @Rollback(false)
    public void p() {
        List<Student> all = studentRepository.findAll();
        System.out.println(all.size());
    }

}
