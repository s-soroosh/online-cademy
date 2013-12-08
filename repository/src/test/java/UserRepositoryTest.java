import com.sarabadani.commons.repository.UserRepository;
import com.sarabadani.onlinecademy.model.student.Grade;
import com.sarabadani.onlinecademy.model.user.Authority;
import com.sarabadani.onlinecademy.model.user.User;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.util.Date;

/**
 * Created by soroosh on 12/5/13.
 */
@ContextConfiguration(locations = "classpath*:data-test-context.xml")
public class UserRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    public static final String SOROOSH = "soroosh";
    public static final String PASS = "123456";
    public static final String NAME = "name";
    public static final String LAST_NAME = "lastName";
    public static final String EMAIL = "email";
    public static final Date BIRTH_DATE = new Date();
    public static final Grade ASSOCIATE = Grade.ASSOCIATE;
    @Autowired
    private UserRepository userRepository;

    @Test
    public void should_insert_a_user(){
        User user = new User(SOROOSH, PASS, NAME, LAST_NAME, EMAIL, BIRTH_DATE, ASSOCIATE);
        userRepository.saveAndFlush(user);

       Assert.assertNotNull(userRepository.findOne(user.getId()));

    }

    @Before
    public void before(){
        userRepository.deleteAllInBatch();
    }

    @Test
    public void should_insert_a_user_with_authority(){
        User user = new User(SOROOSH, PASS, NAME, LAST_NAME, EMAIL, BIRTH_DATE, ASSOCIATE);
        User user2 = new User("mehdi", PASS, NAME, LAST_NAME, "mehdi@yyy.com", BIRTH_DATE, ASSOCIATE);
        user.addAuthority("ADMIN");
        user2.addAuthority("ADMIN");

        userRepository.saveAndFlush(user);
        userRepository.saveAndFlush(user2);

        User gotUser = userRepository.findOne(user.getId());
        Assert.assertTrue(gotUser.getAuthorities().size() == 1);

    }

    @Test
    public void should_find_user_with_all_authority(){
        User user = new User(SOROOSH, PASS, NAME, LAST_NAME, EMAIL, BIRTH_DATE, ASSOCIATE);
        user.addAuthority("ADMIN");

        userRepository.saveAndFlush(user);

        User gotUser = userRepository.findOne(user.getId());
        Assert.assertTrue(gotUser.getAuthorities().size() == 1);
    }

    @Test

    public void should_remove_authority_of_user(){
        User user = new User(SOROOSH, PASS, NAME, LAST_NAME, EMAIL, BIRTH_DATE, ASSOCIATE);
        user.addAuthority("ADMIN");
        user.addAuthority("G");
        userRepository.saveAndFlush(user);

        User gotUser = userRepository.findOne(user.getId());
        gotUser.getAuthorities().remove(new Authority("ADMIN"));

        userRepository.saveAndFlush(gotUser);

        gotUser.addAuthority("STUDENT");


    }


    @Test
    public void should_return_null_when_user_does_not_exist(){
        final User usr = userRepository.findByUsername(SOROOSH);

        Assert.assertNull(usr);
    }
}
