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
@Table(name = "mis_schedule", catalog = "mis", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MisSchedule.findAll", query = "SELECT m FROM MisSchedule m"),
    @NamedQuery(name = "MisSchedule.findById", query = "SELECT m FROM MisSchedule m WHERE m.id = :id"),
    @NamedQuery(name = "MisSchedule.findByIdTimetable", query = "SELECT m FROM MisSchedule m WHERE m.idTimetable = :idTimetable"),
    @NamedQuery(name = "MisSchedule.findByWorkDate", query = "SELECT m FROM MisSchedule m WHERE m.workDate = :workDate"),
    @NamedQuery(name = "MisSchedule.findByTimebegin", query = "SELECT m FROM MisSchedule m WHERE m.timebegin = :timebegin"),
    @NamedQuery(name = "MisSchedule.findByTimeend", query = "SELECT m FROM MisSchedule m WHERE m.timeend = :timeend")})
public class MisSchedule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "id_timetable")
    private int idTimetable;
    @Column(name = "work_date")
    @Temporal(TemporalType.DATE)
    private Date workDate;
    @Column(name = "timebegin")
    @Temporal(TemporalType.TIME)
    private Date timebegin;
    @Basic(optional = false)
    @Column(name = "timeend")
    @Temporal(TemporalType.TIME)
    private Date timeend;
    @Lob
    @Column(name = "note")
    private byte[] note;
    @JoinColumn(name = "id_physician_in_hospital", referencedColumnName = "id")
    @ManyToOne
    private MisPhysicanInHospital idPhysicianInHospital;
    @JoinColumn(name = "assigned_patient_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MisPatient assignedPatientId;

    public MisSchedule() {
    }

    public MisSchedule(Integer id) {
        this.id = id;
    }

    public MisSchedule(Integer id, int idTimetable, Date timeend) {
        this.id = id;
        this.idTimetable = idTimetable;
        this.timeend = timeend;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdTimetable() {
        return idTimetable;
    }

    public void setIdTimetable(int idTimetable) {
        this.idTimetable = idTimetable;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public Date getTimebegin() {
        return timebegin;
    }

    public void setTimebegin(Date timebegin) {
        this.timebegin = timebegin;
    }

    public Date getTimeend() {
        return timeend;
    }

    public void setTimeend(Date timeend) {
        this.timeend = timeend;
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

    public MisPatient getAssignedPatientId() {
        return assignedPatientId;
    }

    public void setAssignedPatientId(MisPatient assignedPatientId) {
        this.assignedPatientId = assignedPatientId;
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
        if (!(object instanceof MisSchedule)) {
            return false;
        }
        MisSchedule other = (MisSchedule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.MisSchedule[ id=" + id + " ]";
    }
    
}
