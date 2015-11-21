

package gabriel.domain;

import gabriel.domain.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author gabriel
 */
public interface RegistrationRepository extends JpaRepository<Registration, Long> {

}
