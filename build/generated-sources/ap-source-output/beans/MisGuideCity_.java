package beans;

import beans.MisHospital;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-18T14:54:43")
@StaticMetamodel(MisGuideCity.class)
public class MisGuideCity_ { 

    public static volatile SingularAttribute<MisGuideCity, Integer> id;
    public static volatile SingularAttribute<MisGuideCity, String> cityName;
    public static volatile CollectionAttribute<MisGuideCity, MisHospital> misHospitalCollection;
    public static volatile SingularAttribute<MisGuideCity, byte[]> note;

}