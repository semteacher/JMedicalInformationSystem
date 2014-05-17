/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1
 */
@Entity
@Table(name = "mis_physican_in_hospital", catalog = "mis", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MisPhysicanInHospital.findAll", query = "SELECT m FROM MisPhysicanInHospital m"),
    @NamedQuery(name = "MisPhysicanInHospital.findById", query = "SELECT m FROM MisPhysicanInHospital m WHERE m.id = :id"),
    @NamedQuery(name = "MisPhysicanInHospital.findByAssigned", query = "SELECT m FROM MisPhysicanInHospital m WHERE m.assigned = :assigned"),
    @NamedQuery(name = "MisPhysicanInHospital.findByRejected", query = "SELECT m FROM MisPhysicanInHospital m WHERE m.rejected = :rejected")})
public class MisPhysicanInHospital implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "login")
    private String login;
    @Basic(optional = false)
    @Lob
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Lob
    @Column(name = "position")
    private String position;
    @Column(name = "assigned")
    @Temporal(TemporalType.DATE)
    private Date assigned;
    @Column(name = "rejected")
    @Temporal(TemporalType.DATE)
    private Date rejected;
    @OneToMany(mappedBy = "idPhysicianInHospital")
    private Collection<MisSchedule> misScheduleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPhysicianInHospital")
    private Collection<MisWorkingTime> misWorkingTimeCollection;
    @JoinColumn(name = "id_speciality", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MisGuideSpeciality idSpeciality;
    @JoinColumn(name = "id_hospital", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MisHospital idHospital;
    @JoinColumn(name = "id_physician", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MisGuidePhysician idPhysician;

    public MisPhysicanInHospital() {
    }

    public MisPhysicanInHospital(Integer id) {
        this.id = id;
    }

    public MisPhysicanInHospital(Integer id, String login, String password, String position) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.position = position;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Date getAssigned() {
        return assigned;
    }

    public void setAssigned(Date assigned) {
        this.assigned = assigned;
    }

    public Date getRejected() {
        return rejected;
    }

    public void setRejected(Date rejected) {
        this.rejected = rejected;
    }

    @XmlTransient
    public Collection<MisSchedule> getMisScheduleCollection() {
        return misScheduleCollection;
    }

    public void setMisScheduleCollection(Collection<MisSchedule> misScheduleCollection) {
        this.misScheduleCollection = misScheduleCollection;
    }

    @XmlTransient
    public Collection<MisWorkingTime> getMisWorkingTimeCollection() {
        return misWorkingTimeCollection;
    }

    public void setMisWorkingTimeCollection(Collection<MisWorkingTime> misWorkingTimeCollection) {
        this.misWorkingTimeCollection = misWorkingTimeCollection;
    }

    public MisGuideSpeciality getIdSpeciality() {
        return idSpeciality;
    }

    public void setIdSpeciality(MisGuideSpeciality idSpeciality) {
        this.idSpeciality = idSpeciality;
    }

    public MisHospital getIdHospital() {
        return idHospital;
    }

    public void setIdHospital(MisHospital idHospital) {
        this.idHospital = idHospital;
    }

    public MisGuidePhysician getIdPhysician() {
        return idPhysician;
    }

    public void setIdPhysician(MisGuidePhysician idPhysician) {
        this.idPhysician = idPhysician;
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
        if (!(object instanceof MisPhysicanInHospital)) {
            return false;
        }
        MisPhysicanInHospital other = (MisPhysicanInHospital) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.MisPhysicanInHospital[ id=" + id + " ]";
    }
    
}
