package beans;

import beans.MisPatient;
import beans.MisPhysicanInHospital;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2014-05-18T15:41:22")
@StaticMetamodel(MisSchedule.class)
public class MisSchedule_ { 

    public static volatile SingularAttribute<MisSchedule, Integer> id;
    public static volatile SingularAttribute<MisSchedule, Date> workDate;
    public static volatile SingularAttribute<MisSchedule, MisPatient> assignedPatientId;
    public static volatile SingularAttribute<MisSchedule, Date> timeend;
    public static volatile SingularAttribute<MisSchedule, Date> timebegin;
    public static volatile SingularAttribute<MisSchedule, MisPhysicanInHospital> idPhysicianInHospital;
    public static volatile SingularAttribute<MisSchedule, Integer> idTimetable;
    public static volatile SingularAttribute<MisSchedule, byte[]> note;

}