package beans;

import beans.MisPhysicanInHospital;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-01-30T21:19:42")
@StaticMetamodel(MisGuideSpeciality.class)
public class MisGuideSpeciality_ { 

    public static volatile SingularAttribute<MisGuideSpeciality, Integer> id;
    public static volatile SingularAttribute<MisGuideSpeciality, String> specCode;
    public static volatile SingularAttribute<MisGuideSpeciality, String> specName;
    public static volatile CollectionAttribute<MisGuideSpeciality, MisPhysicanInHospital> misPhysicanInHospitalCollection;
    public static volatile SingularAttribute<MisGuideSpeciality, byte[]> note;

}