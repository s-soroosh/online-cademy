import com.sarabadani.commons.repository.UserRepository;
import com.sarabadani.onlinecademy.model.user.Authority;
import com.sarabadani.onlinecademy.model.user.User;
import junit.framework.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * Created by soroosh on 12/5/13.
 */
@ContextConfiguration(locations = "classpath*:data-test-context.xml")
public class UserRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    public static final String SOROOSH = "soroosh";
    public static final String PASS = "123456";
    @Autowired
    private UserRepository userRepository;

    @Test
    public void should_insert_a_user(){
        User user = new User(SOROOSH, PASS);
        userRepository.saveAndFlush(user);

       Assert.assertNotNull(userRepository.findOne(user.getId()));

    }

    @Test
    public void should_insert_a_user_with_authority(){
        User user = new User(SOROOSH, PASS);
        User user2 = new User("mehdi", PASS);
        user.addAuthority("ADMIN");
        user2.addAuthority("ADMIN");

        userRepository.saveAndFlush(user);
        userRepository.saveAndFlush(user2);

        User gotUser = userRepository.findOne(user.getId());
        Assert.assertTrue(gotUser.getAuthorities().size() == 1);

    }

    @Test
    public void should_find_user_with_all_authority(){
        User user = new User(SOROOSH, PASS);
        user.addAuthority("ADMIN");

        userRepository.saveAndFlush(user);

        User gotUser = userRepository.findOne(user.getId());
        Assert.assertTrue(gotUser.getAuthorities().size() == 1);
    }

    @Test

    public void should_remove_authority_of_user(){
        User user = new User(SOROOSH, PASS);
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
