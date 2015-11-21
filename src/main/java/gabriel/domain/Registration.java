
package gabriel.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author gabriel
 */

@Entity
@Table(name = "registration")
public class Registration implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    @NotBlank
    @Column(name = "first_name")
    @Length(min = 1, max = 50)
    private String firstName;
    
    @NotBlank
    @Column(name = "last_name")
    @Length(min = 1, max = 50)
    private String lastName;
    
    @Column(name = "date_of_birth")
    @NotNull
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirth;
    
    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;
    
    @Length(min = 0, max = 1000)
    private String request;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }    

    public String getRequest() {
        return request;
    }

    public void setRequest(String reason) {
        this.request = reason;
    }
    
    
}
