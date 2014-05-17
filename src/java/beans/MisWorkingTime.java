/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 1
 */
@Entity
@Table(name = "mis_working_time", catalog = "mis", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MisWorkingTime.findAll", query = "SELECT m FROM MisWorkingTime m"),
    @NamedQuery(name = "MisWorkingTime.findById", query = "SELECT m FROM MisWorkingTime m WHERE m.id = :id"),
    @NamedQuery(name = "MisWorkingTime.findByWorkDate", query = "SELECT m FROM MisWorkingTime m WHERE m.workDate = :workDate"),
    @NamedQuery(name = "MisWorkingTime.findByWorkTimeStart", query = "SELECT m FROM MisWorkingTime m WHERE m.workTimeStart = :workTimeStart"),
    @NamedQuery(name = "MisWorkingTime.findByWorkTimeEnd", query = "SELECT m FROM MisWorkingTime m WHERE m.workTimeEnd = :workTimeEnd"),
    @NamedQuery(name = "MisWorkingTime.findByPatientAmount", query = "SELECT m FROM MisWorkingTime m WHERE m.patientAmount = :patientAmount")})
public class MisWorkingTime implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "work_date")
    @Temporal(TemporalType.DATE)
    private Date workDate;
    @Basic(optional = false)
    @Column(name = "work_time_start")
    @Temporal(TemporalType.TIME)
    private Date workTimeStart;
    @Basic(optional = false)
    @Column(name = "work_time_end")
    @Temporal(TemporalType.TIME)
    private Date workTimeEnd;
    @Basic(optional = false)
    @Column(name = "patient_amount")
    private int patientAmount;
    @Lob
    @Column(name = "note")
    private byte[] note;
    @JoinColumn(name = "id_physician_in_hospital", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MisPhysicanInHospital idPhysicianInHospital;

    public MisWorkingTime() {
    }

    public MisWorkingTime(Integer id) {
        this.id = id;
    }

    public MisWorkingTime(Integer id, Date workDate, Date workTimeStart, Date workTimeEnd, int patientAmount) {
        this.id = id;
        this.workDate = workDate;
        this.workTimeStart = workTimeStart;
        this.workTimeEnd = workTimeEnd;
        this.patientAmount = patientAmount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Date getWorkTimeStart() {
        return workTimeStart;
    }

    public void setWorkTimeStart(Date workTimeStart) {
        this.workTimeStart = workTimeStart;
    }

    public Date getWorkTimeEnd() {
        return workTimeEnd;
    }

    public void setWorkTimeEnd(Date workTimeEnd) {
        this.workTimeEnd = workTimeEnd;
    }

    public int getPatientAmount() {
        return patientAmount;
    }

    public void setPatientAmount(int patientAmount) {
        this.patientAmount = patientAmount;
    }

    public byte[] getNote() {
        return note;
    }

    public void setNote(byte[] note) {
        this.note = note;
    }

    public MisPhysicanInHospital getIdPhysicianInHospital() {
        return idPhysicianInHospital;
    }

    public void setIdPhysicianInHospital(MisPhysicanInHospital idPhysicianInHospital) {
        this.idPhysicianInHospital = idPhysicianInHospital;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MisWorkingTime)) {
            return false;
        }
        MisWorkingTime other = (MisWorkingTime) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.MisWorkingTime[ id=" + id + " ]";
    }
    
}
