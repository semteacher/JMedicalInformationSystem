package beans;

import beans.MisGuideCity;
import beans.MisGuideHospitalType;
import beans.MisPhysicanInHospital;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-18T15:41:22")
@StaticMetamodel(MisHospital.class)
public class MisHospital_ { 

    public static volatile SingularAttribute<MisHospital, Integer> id;
    public static volatile SingularAttribute<MisHospital, String> title;
    public static volatile SingularAttribute<MisHospital, MisGuideCity> cityId;
    public static volatile SingularAttribute<MisHospital, MisGuideHospitalType> hospitalTypeId;
    public static volatile CollectionAttribute<MisHospital, MisPhysicanInHospital> misPhysicanInHospitalCollection;
    public static volatile SingularAttribute<MisHospital, byte[]> photo;
    public static volatile SingularAttribute<MisHospital, byte[]> contacts;

}