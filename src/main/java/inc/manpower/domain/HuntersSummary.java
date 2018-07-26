package inc.manpower.domain;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "`HuntersSummary`")
public class HuntersSummary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name="head_hunter_id", nullable=false)
    private HeadHunter headHunter;

    @ManyToOne
    @JoinColumn(name = "employee_type_id", nullable = false)
    private EmployeeType employeeType;

    private Long groupCount;

    private Long employeeCount;
}
