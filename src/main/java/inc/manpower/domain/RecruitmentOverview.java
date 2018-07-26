package inc.manpower.domain;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "`recruitment_overview`")
@Subselect("select uuid() as id, ov.* from recruitment_overview ov")
public class RecruitmentOverview {

    @Id
    private String id;
    private Long hunter_id;
    private Long type_id;
    private Long employees_count;
    private Long groups_count;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getHunter_id() {
        return hunter_id;
    }

    public void setHunter_id(Long hunter_id) {
        this.hunter_id = hunter_id;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public Long getEmployees_count() {
        return employees_count;
    }

    public void setEmployees_count(Long employees_count) {
        this.employees_count = employees_count;
    }

    public Long getGroups_count() {
        return groups_count;
    }

    public void setGroups_count(Long groups_count) {
        this.groups_count = groups_count;
    }
}
