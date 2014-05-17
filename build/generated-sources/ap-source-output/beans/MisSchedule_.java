package beans;

import beans.MisPatient;
import beans.MisPhysicanInHospital;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-01-31T17:55:06")
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