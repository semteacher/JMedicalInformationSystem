package beans;

import beans.MisPhysicanInHospital;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-01-31T20:48:17")
@StaticMetamodel(MisGuidePhysician.class)
public class MisGuidePhysician_ { 

    public static volatile SingularAttribute<MisGuidePhysician, String> affibiation;
    public static volatile SingularAttribute<MisGuidePhysician, Date> birthday;
    public static volatile SingularAttribute<MisGuidePhysician, String> phone2;
    public static volatile SingularAttribute<MisGuidePhysician, Integer> idCity;
    public static volatile SingularAttribute<MisGuidePhysician, String> icq;
    public static volatile SingularAttribute<MisGuidePhysician, String> password;
    public static volatile SingularAttribute<MisGuidePhysician, byte[]> photo;
    public static volatile SingularAttribute<MisGuidePhysician, String> phone1;
    public static volatile SingularAttribute<MisGuidePhysician, Integer> id;
    public static volatile SingularAttribute<MisGuidePhysician, String> thirdName;
    public static volatile SingularAttribute<MisGuidePhysician, String> username;
    public static volatile SingularAttribute<MisGuidePhysician, String> adress;
    public static volatile SingularAttribute<MisGuidePhysician, String> email;
    public static volatile SingularAttribute<MisGuidePhysician, String> family;
    public static volatile SingularAttribute<MisGuidePhysician, String> name;
    public static volatile CollectionAttribute<MisGuidePhysician, MisPhysicanInHospital> misPhysicanInHospitalCollection;
    public static volatile SingularAttribute<MisGuidePhysician, byte[]> note;
    public static volatile SingularAttribute<MisGuidePhysician, String> skype;

}