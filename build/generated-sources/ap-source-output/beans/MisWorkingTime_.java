package beans;

import beans.MisPhysicanInHospital;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-01-30T21:19:42")
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