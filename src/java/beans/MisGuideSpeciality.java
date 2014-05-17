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
import javax.persistence.Lob;
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
@Table(name = "mis_guide_speciality", catalog = "mis", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MisGuideSpeciality.findAll", query = "SELECT m FROM MisGuideSpeciality m"),
    @NamedQuery(name = "MisGuideSpeciality.findById", query = "SELECT m FROM MisGuideSpeciality m WHERE m.id = :id")})
public class MisGuideSpeciality implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "spec_name")
    private String specName;
    @Basic(optional = false)
    @Lob
    @Column(name = "spec_code")
    private String specCode;
    @Lob
    @Column(name = "note")
    private byte[] note;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSpeciality")
    private Collection<MisPhysicanInHospital> misPhysicanInHospitalCollection;

    public MisGuideSpeciality() {
    }

    public MisGuideSpeciality(Integer id) {
        this.id = id;
    }

    public MisGuideSpeciality(Integer id, String specName, String specCode) {
        this.id = id;
        this.specName = specName;
        this.specCode = specCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSpecName() {
        return specName;
    }

    public void setSpecName(String specName) {
        this.specName = specName;
    }

    public String getSpecCode() {
        return specCode;
    }

    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }

    public byte[] getNote() {
        return note;
    }

    public void setNote(byte[] note) {
        this.note = note;
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
        if (!(object instanceof MisGuideSpeciality)) {
            return false;
        }
        MisGuideSpeciality other = (MisGuideSpeciality) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.MisGuideSpeciality[ id=" + id + " ]";
    }
    
}
