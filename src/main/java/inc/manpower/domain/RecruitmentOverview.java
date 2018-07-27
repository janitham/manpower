package inc.manpower.domain;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Immutable
@Table(name = "`recruitment_overview`")
@Subselect("select uuid() as id, ov.* from recruitment_overview ov")
public class RecruitmentOverview implements Serializable {

    @Id
    private String id;
    private Long hunterId;
    private Long typeId;
    private Long employeesCount;
    private Long groupsCount;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getHunterId() {
        return hunterId;
    }

    public void setHunterId(Long hunterId) {
        this.hunterId = hunterId;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getEmployeesCount() {
        return employeesCount;
    }

    public void setEmployeesCount(Long employeesCount) {
        this.employeesCount = employeesCount;
    }

    public Long getGroupsCount() {
        return groupsCount;
    }

    public void setGroupsCount(Long groupsCount) {
        this.groupsCount = groupsCount;
    }
}
