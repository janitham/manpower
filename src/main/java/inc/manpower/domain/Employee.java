package inc.manpower.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "`Employee`")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
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

}
