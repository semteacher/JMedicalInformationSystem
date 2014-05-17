<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@taglib prefix="zk" uri="http://www.zkoss.org/jsp/zul" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.zkoss.zkplus.databind.AnnotateDataBinderInit"%>
<%@page import="org.zkoss.image.AImage"%>
<%-- 
    Document   : 02hospitals
    Created on : 03.01.2012, 17:29:24
    Author     : marceniuk
--%>
<jsp:useBean id="MisBean" class="session.MisSessionBean" scope="session"/>
<sql:query var="selectedhospitaltype" dataSource="jdbc/mis">
    SELECT type_name FROM mis.mis_guide_hospital_type where id=?
    <sql:param value="${MisBean.selhosptype}"/>
</sql:query>
<sql:query var="hospitals" dataSource="jdbc/mis">   
    select mis_hospital.id, title, photo, contacts, city_name from mis.mis_hospital, mis.mis_guide_city
    where (mis.mis_guide_city.id=mis.mis_hospital.city_id)and(mis.mis_hospital.hospital_type_id=?)
    <sql:param value="${MisBean.selhosptype}"/>
</sql:query>
<div id="content">
    <zk:page id="pg2" style="height:600px;width=1000px">
        <zk:init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"/>
        <zk:window sclass="mainwnd" id="hospWin" title="${selectedhospitaltype.rows[0].type_name}:" border="normal">
            <zk:style src="../../css/zkstyle.css"/>
            <zk:grid sclass="maingrid" id="myzkid2" mold="paging" pageSize="10">
                <zk:columns>
                    <zk:column label="Назва"/>  
                    <zk:column label="Місто"/>  
                    <zk:column label="Контактна інформація"/>
                    <zk:column label="Фото"/>
                </zk:columns>
                <zk:rows>
                    <c:forEach var="myhospitals" items="${hospitals.rows}" varStatus="status">
                        <zk:row>
                            <zk:a href="/hospital_specialities?hospid=${myhospitals.id}" label="${myhospitals.title}"/>                          
                            <zk:label value="${myhospitals.city_name}"/>
                            <zk:label value="${myhospitals.contacts}"/>
                            
                            <zk:image id="myimage" />
                            <%--
                            <zk:zscript>
                                byte[] bytes =${myhospitals.photo};
                                org.zkoss.image.AImage img = new org.zkoss.image.AImage("",bytes);
            myimage.setContent(img);
            myimage.invalidate();
                            </zk:zscript>
                           --%>
                        </zk:row>
                    </c:forEach>
                </zk:rows>
            </zk:grid>
        </zk:window>
    </zk:page>  
</div>