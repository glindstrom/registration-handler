package gabriel;

import gabriel.domain.Gender;
import gabriel.domain.RegistrationRepository;
import gabriel.domain.Registration;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class ApplicationTest {

    @Autowired
    private RegistrationRepository repository;
    
    Registration registration;
    
    @Before
    public void setUp() throws ParseException {
        registration = new Registration();
        registration.setFirstName("John");
        registration.setLastName("Doe");
        registration.setDateOfBirth(dateFromString("20/03/2000"));        
        registration.setGender(Gender.MALE);
        registration.setRequest("request");
    }
    
    @Test
    public void testSaveRegistration() {
        repository.save(registration);
        Registration retrieved = repository.findOne(registration.getId());
        assertNotNull(retrieved);
    }
    
    @Test(expected=javax.validation.ConstraintViolationException.class)
    public void testSaveRegistrationGenderCannotBeNull() {
        registration.setGender(null);
        repository.save(registration);
    }
    @Test(expected=javax.validation.ConstraintViolationException.class)
    public void testSaveRegistrationFirstNameCannotBeBlank() {
        registration.setFirstName("   ");
        repository.save(registration);
    }
    
    private static Date dateFromString(String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.parse(date);
    }

}
