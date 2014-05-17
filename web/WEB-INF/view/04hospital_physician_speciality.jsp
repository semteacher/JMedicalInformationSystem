<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="zk" uri="http://www.zkoss.org/jsp/zul" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.zkoss.zkplus.databind.AnnotateDataBinderInit"%>
<%@page import="org.zkoss.image.AImage"%>
<%-- 
    Document   : 04hospital_physician_speciality
    Created on : 04.01.2012, 9:25:03
    Author     : semteacher1977
--%>
<jsp:useBean id="MisBean" class="session.MisSessionBean" scope="session"/>
<sql:query var="selectedhospital" dataSource="jdbc/mis">
    select title from mis.mis_hospital where id=?
    <sql:param value="${MisBean.selhospital}"/>
</sql:query>
<sql:query var="selectedspeciality" dataSource="jdbc/mis">   
    select spec_name from mis.mis_guide_speciality where mis.mis_guide_speciality.id=?
    <sql:param value="${MisBean.selspeciality}"/>
</sql:query>
<sql:query var="hospitalphysycianbyspec" dataSource="jdbc/mis">
    select mis.mis_physican_in_hospital.id, family, name, third_name, position from mis.mis_guide_physician, mis.mis_physican_in_hospital
    where (mis.mis_guide_physician.id = mis.mis_physican_in_hospital.id_physician)and(mis.mis_physican_in_hospital.id_speciality=?)and(mis.mis_physican_in_hospital.id_hospital=?)
    <sql:param value="${MisBean.selspeciality}"/>
    <sql:param value="${MisBean.selhospital}"/>
</sql:query>
<div id="content">
       <zk:page id="pg4" style="height:600px;width=1000px">
        <zk:init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"/>
        <zk:window sclass="mainwnd" id="doctWin" title="Лікарня: ${selectedhospital.rows[0].title}, спеціальність: ${selectedspeciality.rows[0].spec_name}" border="normal">
            <zk:style src="../../css/zkstyle.css"/>
            <zk:grid sclass="maingrid" id="myzkid4" mold="paging" pageSize="10">
                <zk:columns>
                    <%--
                    <zk:column label="Фото"/>  
                    --%>
                    <zk:column label="ПІБ лікаря"/>  
                    <zk:column label="Посада"/>  
                    
                </zk:columns>
                <zk:rows>
                    <c:forEach var="myphysyianbyspec" items="${hospitalphysycianbyspec.rows}" varStatus="status">
                        <zk:row>
                            <%--
                            <zk:image id="image" />
                            
                            <zk:zscript>
                                byte[] bytes =${myhospitals.photo};
                                org.zkoss.image.AImage img = new org.zkoss.image.AImage("tmp.jpg",bytes);
            image.setContent(img);
                            </zk:zscript>
                            --%>
                            <zk:a href="/physician_schedule?doctorinhospid=${myphysyianbyspec.id}" label="${myphysyianbyspec.family} ${myphysyianbyspec.name} ${myphysyianbyspec.third_name}"/>                          
                            <zk:label value="${myphysyianbyspec.position}"/>                
                        </zk:row>
                    </c:forEach>
                </zk:rows>
            </zk:grid>
        </zk:window>
    </zk:page>
</div>