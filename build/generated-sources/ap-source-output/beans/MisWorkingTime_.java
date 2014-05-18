package beans;

import beans.MisPhysicanInHospital;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-18T14:54:43")
@StaticMetamodel(MisWorkingTime.class)
public class MisWorkingTime_ { 

    public static volatile SingularAttribute<MisWorkingTime, Integer> id;
    public static volatile SingularAttribute<MisWorkingTime, Date> workTimeEnd;
    public static volatile SingularAttribute<MisWorkingTime, Date> workDate;
    public static volatile SingularAttribute<MisWorkingTime, Date> workTimeStart;
    public static volatile SingularAttribute<MisWorkingTime, Integer> patientAmount;
    public static volatile SingularAttribute<MisWorkingTime, MisPhysicanInHospital> idPhysicianInHospital;
    public static volatile SingularAttribute<MisWorkingTime, byte[]> note;

}