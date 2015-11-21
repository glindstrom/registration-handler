
package gabriel.domain;

import java.util.Calendar;
import static java.util.Calendar.DATE;
import static java.util.Calendar.MONTH;
import static java.util.Calendar.YEAR;
import java.util.Date;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author gabriel
 */
@Component
public class BirthdateValidator implements Validator {
    
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 100;

    @Override
    public boolean supports(Class<?> type) {
        return Registration.class.equals(type);
    }

    @Override
    public void validate(Object obj, Errors errors) {
         Registration application = (Registration) obj;
         Date birthday = application.getDateOfBirth();
         if (birthday == null) {
             return;
         }
         Date currentDate = new Date();
         int age = yearsBetween(currentDate, birthday);
         if (age < MIN_AGE || age > MAX_AGE) {
             errors.rejectValue("dateOfBirth", "InvalidAge");
         }
    }
    
    private static int yearsBetween(Date firstDate, Date secondDate) {
        Calendar calendar1 = getCalendar(firstDate);
        Calendar calendar2 = getCalendar(secondDate);
        int yearsBetween = calendar1.get(YEAR) - calendar2.get(YEAR);
        if (calendar2.get(MONTH) > calendar1.get(MONTH) || 
                (calendar2.get(MONTH) == calendar1.get(MONTH) && 
                (calendar2.get(DATE) > calendar1.get(DATE)))) {
            yearsBetween--;
        }
        return yearsBetween;
    }
    
    private static Calendar getCalendar(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

}
