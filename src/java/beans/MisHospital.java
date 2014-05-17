/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;
import java.util.Collection;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 1
 */
@Entity
@Table(name = "mis_hospital", catalog = "mis", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MisHospital.findAll", query = "SELECT m FROM MisHospital m"),
    @NamedQuery(name = "MisHospital.findById", query = "SELECT m FROM MisHospital m WHERE m.id = :id")})
public class MisHospital implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "title")
    private String title;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Lob
    @Column(name = "contacts")
    private byte[] contacts;
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MisGuideCity cityId;
    @JoinColumn(name = "hospital_type_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private MisGuideHospitalType hospitalTypeId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idHospital")
    private Collection<MisPhysicanInHospital> misPhysicanInHospitalCollection;

    public MisHospital() {
    }

    public MisHospital(Integer id) {
        this.id = id;
    }

    public MisHospital(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public byte[] getContacts() {
        return contacts;
    }

    public void setContacts(byte[] contacts) {
        this.contacts = contacts;
    }

    public MisGuideCity getCityId() {
        return cityId;
    }

    public void setCityId(MisGuideCity cityId) {
        this.cityId = cityId;
    }

    public MisGuideHospitalType getHospitalTypeId() {
        return hospitalTypeId;
    }

    public void setHospitalTypeId(MisGuideHospitalType hospitalTypeId) {
        this.hospitalTypeId = hospitalTypeId;
    }

    @XmlTransient
    public Collection<MisPhysicanInHospital> getMisPhysicanInHospitalCollection() {
        return misPhysicanInHospitalCollection;
    }

    public void setMisPhysicanInHospitalCollection(Collection<MisPhysicanInHospital> misPhysicanInHospitalCollection) {
        this.misPhysicanInHospitalCollection = misPhysicanInHospitalCollection;
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
        if (!(object instanceof MisHospital)) {
            return false;
        }
        MisHospital other = (MisHospital) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.MisHospital[ id=" + id + " ]";
    }
    
}
