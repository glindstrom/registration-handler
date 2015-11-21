package gabriel.domain;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Calendar;
import static java.util.Calendar.YEAR;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author gabriel
 */
public class BirthdateValidatorTest {

    private Validator validator;
    private Registration registration;
    private Errors errors;

    @Before
    public void setUp() {
        this.validator = new BirthdateValidator(); 
        this.registration = new Registration();
        this.registration.setFirstName("John");
        this.registration.setLastName("Doe");
        this.registration.setGender(Gender.MALE);
        this.registration.setRequest("request");
        this.errors = new BeanPropertyBindingResult(registration, "registration");

    }

    @Test
    public void testValidationWithValidAge() {
        this.registration.setDateOfBirth(getDate(52));
        this.validator.validate(registration, errors);
        assertFalse(this.errors.hasErrors());
    }
    
    @Test
    public void testValidationWithTooYoung() {
        this.registration.setDateOfBirth(getDate(17));
        this.validator.validate(registration, errors);
        assertTrue(this.errors.hasErrors());
    }
    
    @Test
    public void testValidationWithTooOld() {
        this.registration.setDateOfBirth(getDate(101));
        this.validator.validate(registration, errors);
        assertTrue(this.errors.hasErrors());
    }
    
    @Test
    public void testValidationWithMinAge() {
        this.registration.setDateOfBirth(getDate(18));
        this.validator.validate(registration, errors);
        assertFalse(this.errors.hasErrors());
    }
    
    @Test
    public void testValidationWithMaxAge() {
        this.registration.setDateOfBirth(getDate(100));
        this.validator.validate(registration, errors);
        assertFalse(this.errors.hasErrors());
    }
    
    @Test
    public void testValidationWithNegativeAge() {
        this.registration.setDateOfBirth(getDate(-50));
        this.validator.validate(registration, errors);
        assertTrue(this.errors.hasErrors());
    }        

    private static Date getDate(int years) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(YEAR, calendar.get(YEAR)-years);
        return calendar.getTime();
    }

}
