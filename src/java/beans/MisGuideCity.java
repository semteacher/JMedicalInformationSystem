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
@Table(name = "mis_guide_city", catalog = "mis", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MisGuideCity.findAll", query = "SELECT m FROM MisGuideCity m"),
    @NamedQuery(name = "MisGuideCity.findById", query = "SELECT m FROM MisGuideCity m WHERE m.id = :id")})
public class MisGuideCity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "city_name")
    private String cityName;
    @Lob
    @Column(name = "note")
    private byte[] note;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cityId")
    private Collection<MisHospital> misHospitalCollection;

    public MisGuideCity() {
    }

    public MisGuideCity(Integer id) {
        this.id = id;
    }

    public MisGuideCity(Integer id, String cityName) {
        this.id = id;
        this.cityName = cityName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public byte[] getNote() {
        return note;
    }

    public void setNote(byte[] note) {
        this.note = note;
    }

    @XmlTransient
    public Collection<MisHospital> getMisHospitalCollection() {
        return misHospitalCollection;
    }

    public void setMisHospitalCollection(Collection<MisHospital> misHospitalCollection) {
        this.misHospitalCollection = misHospitalCollection;
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
        if (!(object instanceof MisGuideCity)) {
            return false;
        }
        MisGuideCity other = (MisGuideCity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.MisGuideCity[ id=" + id + " ]";
    }
    
}
