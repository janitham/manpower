package inc.manpower.domain;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Immutable
@Table(name = "`hunters_summary`")
@Subselect("select uuid() as id, hs.* from hunters_summary hs")
public class HuntersSummary implements Serializable {

    @Id
    private String id;
    private Long empId;
    private String empFname;
    private String empLastName;
    private String empSsnId;
    private Date empRecruitedDate;
    private String emType;
    private Double emValue;
    private String hhId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

    public String getEmpFname() {
        return empFname;
    }

    public void setEmpFname(String empFname) {
        this.empFname = empFname;
    }

    public String getEmpLastName() {
        return empLastName;
    }

    public void setEmpLastName(String empLastName) {
        this.empLastName = empLastName;
    }

    public String getEmpSsnId() {
        return empSsnId;
    }

    public void setEmpSsnId(String empSsnId) {
        this.empSsnId = empSsnId;
    }

    public Date getEmpRecruitedDate() {
        return empRecruitedDate;
    }

    public void setEmpRecruitedDate(Date empRecruitedDate) {
        this.empRecruitedDate = empRecruitedDate;
    }

    public String getEmType() {
        return emType;
    }

    public void setEmType(String emType) {
        this.emType = emType;
    }

    public Double getEmValue() {
        return emValue;
    }

    public void setEmValue(Double emValue) {
        this.emValue = emValue;
    }

    public String getHhId() {
        return hhId;
    }

    public void setHhId(String hhId) {
        this.hhId = hhId;
    }
}
