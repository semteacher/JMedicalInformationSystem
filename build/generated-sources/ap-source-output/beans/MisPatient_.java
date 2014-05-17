package beans;

import beans.MisSchedule;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.3.0.v20110604-r9504", date="2012-01-31T20:48:17")
@StaticMetamodel(MisPatient.class)
public class MisPatient_ { 

    public static volatile SingularAttribute<MisPatient, Date> birthday;
    public static volatile SingularAttribute<MisPatient, String> phone2;
    public static volatile SingularAttribute<MisPatient, Integer> idCity;
    public static volatile SingularAttribute<MisPatient, String> icq;
    public static volatile SingularAttribute<MisPatient, String> password;
    public static volatile SingularAttribute<MisPatient, String> phone1;
    public static volatile SingularAttribute<MisPatient, byte[]> photo;
    public static volatile SingularAttribute<MisPatient, Integer> id;
    public static volatile SingularAttribute<MisPatient, String> thirdName;
    public static volatile SingularAttribute<MisPatient, String> username;
    public static volatile SingularAttribute<MisPatient, String> adress;
    public static volatile CollectionAttribute<MisPatient, MisSchedule> misScheduleCollection;
    public static volatile SingularAttribute<MisPatient, String> email;
    public static volatile SingularAttribute<MisPatient, String> family;
    public static volatile SingularAttribute<MisPatient, String> name;
    public static volatile SingularAttribute<MisPatient, String> skype;

}