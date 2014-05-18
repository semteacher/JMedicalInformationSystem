<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="zk" uri="http://www.zkoss.org/jsp/zul"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.sql.Time"%>
<%@page import="javax.servlet.jsp.jstl.sql.Result"%>
<%@page import="org.zkoss.zkplus.databind.AnnotateDataBinderInit"%>
<%@page import="org.zkoss.calendar.Calendars"%>
<%@page import="org.zkoss.calendar.api.CalendarEvent"%>
<%@page import="org.zkoss.calendar.event.CalendarsEvent"%>
<%@page import="org.zkoss.zk.ui.Executions"%>
<%@page import="org.zkoss.calendar.impl.SimpleCalendarModel"%>
<%@page import="org.zkoss.calendar.impl.SimpleCalendarEvent"%>
<%@page import="org.zkoss.image.AImage"%>
<%-- 
    Document   : 05physician_shedule
    Created on : 04.01.2012, 9:26:15
    Author     : semteacher1977
--%>
<jsp:useBean id="MisBean" class="session.MisSessionBean" scope="session"/>
<sql:query var="selectedhospital" dataSource="jdbc/mis">
    select title from mis.mis_hospital where mis.mis_hospital.id=?
    <sql:param value="${MisBean.selhospital}"/>    
</sql:query>
<sql:query var="selectedspeciality" dataSource="jdbc/mis">   
    select spec_name from mis.mis_guide_speciality where mis.mis_guide_speciality.id=?
    <sql:param value="${MisBean.selspeciality}"/>
</sql:query>
<sql:query var="selectedphysycian" dataSource="jdbc/mis">
    select family, name, third_name, mis.mis_physican_in_hospital.id, position from mis.mis_guide_physician, mis.mis_physican_in_hospital 
    where (mis.mis_physican_in_hospital.id_physician=mis.mis_guide_physician.id)and(mis.mis_physican_in_hospital.id=?)
    <sql:param value="${MisBean.seldoctorinhosp}"/>
</sql:query>
<sql:query var="physicianshedule" dataSource="jdbc/mis" scope="request">
    select work_date, timebegin, timeend, assigned_patient_id, id from mis.mis_schedule 
    where (mis.mis_schedule.id_physician=?)and(mis.mis_schedule.id_speciality=?)and(mis.mis_schedule.id_hospital=?)
    <sql:param value="${MisBean.seldoctorinhosp}"/> 
    <sql:param value="${MisBean.selspeciality}"/>
    <sql:param value="${MisBean.selhospital}"/>    
</sql:query>
<%
    SimpleCalendarModel scm = new SimpleCalendarModel();
    int myrowcount = ((Result) (request.getAttribute("physicianshedule"))).getRowCount();
    java.lang.Object[][] mysheduledata;
    mysheduledata = (((Result) (request.getAttribute("physicianshedule"))).getRowsByIndex());
    Date today = new Date();
    for (int i = 0; i < myrowcount; i++) {
        SimpleCalendarEvent sce = new SimpleCalendarEvent();

        Date eventdate = (java.util.Date) mysheduledata[i][0];
        Time timebegin = (java.sql.Time) mysheduledata[i][1];
        Time timeend = (java.sql.Time) mysheduledata[i][2];

//eventdate.setTime(timebtimeegin);

        Calendar dCal = Calendar.getInstance();
        dCal.setTime(eventdate);
        Calendar tCal = Calendar.getInstance();
        tCal.setTime(timebegin);
        dCal.set(Calendar.HOUR_OF_DAY, tCal.get(Calendar.HOUR_OF_DAY));
        dCal.set(Calendar.MINUTE, tCal.get(Calendar.MINUTE));
        dCal.set(Calendar.SECOND, tCal.get(Calendar.SECOND));
        dCal.set(Calendar.MILLISECOND, tCal.get(Calendar.MILLISECOND));

        sce.setBeginDate(dCal.getTime());

        tCal.setTime(timeend);
        dCal.set(Calendar.HOUR_OF_DAY, tCal.get(Calendar.HOUR_OF_DAY));
        dCal.set(Calendar.MINUTE, tCal.get(Calendar.MINUTE));
        dCal.set(Calendar.SECOND, tCal.get(Calendar.SECOND));
        dCal.set(Calendar.MILLISECOND, tCal.get(Calendar.MILLISECOND));

        sce.setEndDate(dCal.getTime());

        //The color Strings should only be colors
        //that CSS accept
        if (today.compareTo(dCal.getTime()) < 0) {
            sce.setContentColor("green");
            sce.setHeaderColor("green");
            sce.setLocked(false);
        } else {
            sce.setContentColor("red");
            sce.setHeaderColor("red");
            sce.setLocked(true);
        }
        
        Integer occupy = (Integer) mysheduledata[i][3];
        if (occupy > 1) {
            sce.setTitle("0");
            sce.setContent("Зайнято");
            sce.setLocked(true);
        } else {
            sce.setTitle(String.valueOf(mysheduledata[i][4]));
            sce.setContent(timebegin + "-" + timeend);
        }
        scm.add(sce);
    }
    request.setAttribute("myshedulemodel", scm);
%>   
<div id="content">
    <zk:page id="pg5" style="height:100%;width=100%">
        <zk:init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"/>
        <zk:window sclass="mainwnd" height="100%" id="doctWin" title="Лікарня: ${selectedhospital.rows[0].title}, спеціальність: ${selectedspeciality.rows[0].spec_name}" border="normal">
            <zk:style id="st1" src="../../css/zkstyle.css"/>
            <zk:label id="lb1" value="Лікар: ${selectedphysycian.rows[0].family} ${selectedphysycian.rows[0].name} ${selectedphysycian.rows[0].third_name}"/>
            <zk:label id="lb2" value="Посада:${selectedphysycian.rows[0].position}"/>  
            <zk:label id="lb3" value="Виберіть дату і час прийому:"/>  

            <zk:calendars id="misCalendarID" height="100%" firstDayOfWeek="Monday"
                          timeZone="Kiev=GMT+2" readonly="false">
                <zk:attribute name="onEventEdit">
                    CalendarsEvent evnt = (CalendarsEvent) event;
                    CalendarEvent eventdata = (CalendarEvent) evnt.getCalendarEvent();
                    int selsheduleid = Integer.parseInt(eventdata.getTitle());
                    if (eventdata.isLocked()==false) Executions.sendRedirect("/patient_registration?sheduleid="+eventdata.getTitle());
                </zk:attribute>
            </zk:calendars>    
            <zk:zscript>                
                misCalendarID.setMold("month");                   
                misCalendarID.setModel(requestScope.get("myshedulemodel"));                
            </zk:zscript>
        </zk:window>
    </zk:page>          
</div>