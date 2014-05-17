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
import javax.persistence.Lob;
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
@Table(name = "mis_patient", catalog = "mis", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MisPatient.findAll", query = "SELECT m FROM MisPatient m"),
    @NamedQuery(name = "MisPatient.findById", query = "SELECT m FROM MisPatient m WHERE m.id = :id"),
    @NamedQuery(name = "MisPatient.findByIdCity", query = "SELECT m FROM MisPatient m WHERE m.idCity = :idCity"),
    @NamedQuery(name = "MisPatient.findByBirthday", query = "SELECT m FROM MisPatient m WHERE m.birthday = :birthday")})
public class MisPatient implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Lob
    @Column(name = "family")
    private String family;
    @Basic(optional = false)
    @Lob
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Lob
    @Column(name = "third_name")
    private String thirdName;
    @Basic(optional = false)
    @Column(name = "id_city")
    private int idCity;
    @Basic(optional = false)
    @Lob
    @Column(name = "adress")
    private String adress;
    @Basic(optional = false)
    @Lob
    @Column(name = "phone1")
    private String phone1;
    @Basic(optional = false)
    @Lob
    @Column(name = "phone2")
    private String phone2;
    @Basic(optional = false)
    @Lob
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Lob
    @Column(name = "icq")
    private String icq;
    @Basic(optional = false)
    @Lob
    @Column(name = "skype")
    private String skype;
    @Lob
    @Column(name = "photo")
    private byte[] photo;
    @Basic(optional = false)
    @Lob
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @Lob
    @Column(name = "password")
    private String password;
    @Column(name = "birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assignedPatientId")
    private Collection<MisSchedule> misScheduleCollection;

    public MisPatient() {
    }

    public MisPatient(Integer id) {
        this.id = id;
    }

    public MisPatient(Integer id, String family, String name, String thirdName, int idCity, String adress, String phone1, String phone2, String email, String icq, String skype, String username, String password) {
        this.id = id;
        this.family = family;
        this.name = name;
        this.thirdName = thirdName;
        this.idCity = idCity;
        this.adress = adress;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.email = email;
        this.icq = icq;
        this.skype = skype;
        this.username = username;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIcq() {
        return icq;
    }

    public void setIcq(String icq) {
        this.icq = icq;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @XmlTransient
    public Collection<MisSchedule> getMisScheduleCollection() {
        return misScheduleCollection;
    }

    public void setMisScheduleCollection(Collection<MisSchedule> misScheduleCollection) {
        this.misScheduleCollection = misScheduleCollection;
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
        if (!(object instanceof MisPatient)) {
            return false;
        }
        MisPatient other = (MisPatient) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "beans.MisPatient[ id=" + id + " ]";
    }
    
}
