package beans;

import beans.MisHospital;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-01-30T21:19:42")
@StaticMetamodel(MisGuideCity.class)
public class MisGuideCity_ { 

    public static volatile SingularAttribute<MisGuideCity, Integer> id;
    public static volatile SingularAttribute<MisGuideCity, String> cityName;
    public static volatile CollectionAttribute<MisGuideCity, MisHospital> misHospitalCollection;
    public static volatile SingularAttribute<MisGuideCity, byte[]> note;

}