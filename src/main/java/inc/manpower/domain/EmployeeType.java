package inc.manpower.domain;

import javax.persistence.*;

@Entity
@Table(name = "`EmployeeType`")
public class EmployeeType {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double amount;
}
