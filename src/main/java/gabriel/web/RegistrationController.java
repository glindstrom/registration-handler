package gabriel.web;

import gabriel.domain.Registration;
import gabriel.domain.BirthdateValidator;
import gabriel.domain.RegistrationRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author gabriel
 */
@Controller
@RequestMapping("/registrations")
public class RegistrationController {
    
    @Autowired
    private RegistrationRepository registrationRepository;    

    @RequestMapping("/new")
    public String newRegistration(@ModelAttribute("registration") Registration application) {
        return "/WEB-INF/views/newRegistration.jsp";
    }

    @RequestMapping(value="/create", method = RequestMethod.POST)
    public String createRegistration(RedirectAttributes redirectAttributes, @Valid @ModelAttribute Registration registration, BindingResult bindingResult) {
        
        new BirthdateValidator().validate(registration, bindingResult);
        
        if (bindingResult.hasErrors()) {
            return "/WEB-INF/views/newRegistration.jsp";
        }
        registration = registrationRepository.save(registration);
        redirectAttributes.addAttribute("id", registration.getId());
        redirectAttributes.addFlashAttribute("message", "Your registration has been successfully submitted");
        return "redirect:registration/{id}";
    }
    
    @RequestMapping(value = "/registration/{registrationId}", method=RequestMethod.GET)
    public String viewApplication(@PathVariable Long registrationId, Model model) {
        Registration registration =  registrationRepository.findOne(registrationId);
        model.addAttribute("registration", registration);
        return "/WEB-INF/views/registration.jsp"; 
    }
}
