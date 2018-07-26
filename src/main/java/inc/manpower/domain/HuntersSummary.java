package inc.manpower.domain;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "`hunters_summary`")
@Subselect("select uuid() as id, hs.* from hunters_summary hs")
public class HuntersSummary {

    @Id
    private String id;
    private Long emp_id;
    private Long hh_id;
    private Long type_id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(Long emp_id) {
        this.emp_id = emp_id;
    }

    public Long getHh_id() {
        return hh_id;
    }

    public void setHh_id(Long hh_id) {
        this.hh_id = hh_id;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }
}
