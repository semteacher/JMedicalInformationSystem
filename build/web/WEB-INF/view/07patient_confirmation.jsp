<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%-- 
    Document   : 07patient_confirmation
    Created on : 04.01.2012, 9:28:27
    Author     : semteacher1977
--%>
<jsp:useBean id="MisBean" class="session.MisSessionBean" scope="session"/>
<jsp:useBean id="NewPatient" class="beans.MisPatient" scope="session"/>
<sql:update var="newpatientdata" dataSource="jdbc/mis">
    INSERT INTO mis.mis_patient (family, name, third_name, adress, email, phone1, phone2, birthday, id_city)
    VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
    <sql:param value="${NewPatient.family}"/> 
    <sql:param value="${NewPatient.name}"/> 
    <sql:param value="${NewPatient.thirdName}"/> 
    <sql:param value="${NewPatient.adress}"/> 
    <sql:param value="${NewPatient.email}"/> 
    <sql:param value="${NewPatient.phone1}"/> 
    <sql:param value="${NewPatient.phone2}"/>
    <sql:param value="${NewPatient.birthday}"/>
    <sql:param value="1"/> 
</sql:update>
<sql:query var="selectedpatient" dataSource="jdbc/mis">
    select id from mis.mis_patient where mis.mis_patient.id = (SELECT LAST_INSERT_ID())
</sql:query>
    <sql:update var="updateshedule" dataSource="jdbc/mis">
    UPDATE mis.mis_schedule SET mis.mis_schedule.assigned_patient_id= ? where mis.mis_schedule.id =?    
    <sql:param value="${selectedpatient.rows[0].id}"/>
    <sql:param value="${MisBean.selsheduleitem}"/> 
</sql:update>
<sql:query var="selectedhospital" dataSource="jdbc/mis">
    select title, contacts, city_name from mis.mis_hospital, mis.mis_guide_city
    where (mis.mis_guide_city.id=mis.mis_hospital.city_id)and(mis.mis_hospital.id=1)
    <%--
        where (mis.mis_guide_city.id=mis.mis_hospital.city_id)and(mis.mis_hospital.id=?)
        <sql:param value="${pagecontext.requrest.queryString}"/>
    --%>
</sql:query>
<div id="content">
    <p id="patient">Шановний, ${NewPatient.family} ${NewPatient.name} ${NewPatient.thirdName}
    підтверджуємо, що Ви записані на прийом до:</p>
    <p id="hospitalname">${selectedhospital.rows[0].title}, м.${selectedhospital.rows[0].city_name}, ${selectedhospital.rows[0].contacts} </p>
    <a href="/MedicalInformationSystem/physician_schedule?doctorinhospid=${MisBean.seldoctorinhosp}">Go to shedule again!</a>
    <p>sucessfully was aded ${newpatientdata} records</p>
</div>