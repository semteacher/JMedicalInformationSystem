package beans;

import beans.MisGuidePhysician;
import beans.MisGuideSpeciality;
import beans.MisHospital;
import beans.MisSchedule;
import beans.MisWorkingTime;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-18T14:54:43")
@StaticMetamodel(MisPhysicanInHospital.class)
public class MisPhysicanInHospital_ { 

    public static volatile SingularAttribute<MisPhysicanInHospital, Integer> id;
    public static volatile SingularAttribute<MisPhysicanInHospital, String> position;
    public static volatile SingularAttribute<MisPhysicanInHospital, MisHospital> idHospital;
    public static volatile CollectionAttribute<MisPhysicanInHospital, MisSchedule> misScheduleCollection;
    public static volatile SingularAttribute<MisPhysicanInHospital, Date> rejected;
    public static volatile SingularAttribute<MisPhysicanInHospital, MisGuideSpeciality> idSpeciality;
    public static volatile SingularAttribute<MisPhysicanInHospital, Date> assigned;
    public static volatile SingularAttribute<MisPhysicanInHospital, String> login;
    public static volatile SingularAttribute<MisPhysicanInHospital, String> password;
    public static volatile SingularAttribute<MisPhysicanInHospital, MisGuidePhysician> idPhysician;
    public static volatile CollectionAttribute<MisPhysicanInHospital, MisWorkingTime> misWorkingTimeCollection;

}