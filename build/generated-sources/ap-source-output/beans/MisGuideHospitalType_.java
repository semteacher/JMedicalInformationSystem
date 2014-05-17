package beans;

import beans.MisHospital;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-01-31T17:55:06")
@StaticMetamodel(MisGuideHospitalType.class)
public class MisGuideHospitalType_ { 

    public static volatile SingularAttribute<MisGuideHospitalType, Integer> id;
    public static volatile SingularAttribute<MisGuideHospitalType, String> typeName;
    public static volatile CollectionAttribute<MisGuideHospitalType, MisHospital> misHospitalCollection;
    public static volatile SingularAttribute<MisGuideHospitalType, String> note;

}