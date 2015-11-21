
package gabriel.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author gabriel
 */
@Controller
public class WebController {
    
    @RequestMapping("/")
    public String startPage(){    
        return "redirect:/registrations/new";
    }
}
