package inc.manpower.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "`Employee`")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String ssnId;

    private String firstName;

    private String lastName;

    private Date recruitedDate;

    @ManyToOne
    @JoinColumn(name = "head_hunter_id", nullable = false)
    private HeadHunter headHunter;

    @ManyToOne
    @JoinColumn(name = "employee_type_id", nullable = false)
    private EmployeeType employeeType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSsnId() {
        return ssnId;
    }

    public void setSsnId(String ssnId) {
        this.ssnId = ssnId;
    }

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

    public Date getRecruitedDate() {
        return recruitedDate;
    }

    public void setRecruitedDate(Date recruitedDate) {
        this.recruitedDate = recruitedDate;
    }

    public HeadHunter getHeadHunter() {
        return headHunter;
    }

    public void setHeadHunter(HeadHunter headHunter) {
        this.headHunter = headHunter;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }
}
