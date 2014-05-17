<%@taglib prefix="zk" uri="http://www.zkoss.org/jsp/zul"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.zkoss.zkplus.databind.AnnotateDataBinderInit"%>
<%-- 
    Document   : 03hospital_specialities
    Created on : 03.01.2012, 17:30:03
    Author     : marceniuk
--%>
<jsp:useBean id="MisBean" class="session.MisSessionBean" scope="session"/>
<sql:query var="selectedhospital" dataSource="jdbc/mis">
    select title from mis.mis_hospital where id=?
    <sql:param value="${MisBean.selhospital}"/>    
</sql:query>
<sql:query var="hospitalspecialities" dataSource="jdbc/mis">   
    select distinct spec_name, id_speciality from mis.mis_guide_speciality, mis.mis_physican_in_hospital
    where (mis.mis_guide_speciality.id=mis.mis_physican_in_hospital.id_speciality)and(mis.mis_physican_in_hospital.id_hospital=?)
    <sql:param value="${MisBean.selhospital}"/>
</sql:query>
<div id="content">
    <zk:page  id="pg3" style="height:600px;width=1000px">
        <zk:init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"/>
        <zk:window sclass="mainwnd" id="specWin" title="Лікарня: ${selectedhospital.rows[0].title}" border="normal">
            <zk:style src="../../css/zkstyle.css"/>
            <zk:grid sclass="maingrid" id="myzkid3" mold="paging" pageSize="10">
                <zk:auxhead>
                    <zk:auxheader label="Виберіть необхідну спеціальність натиснувши на неї:" colspan="3"/>
                </zk:auxhead>
                <zk:rows>
                    <c:forEach var="row" begin="0" end="1">
                        <zk:row>
                            <c:forEach var="colmn" begin="0" end="2">
                                <zk:a href="/hospital_physicians_speciality?specid=${hospitalspecialities.rows[row*3+colmn].id_speciality}" label="${hospitalspecialities.rows[row*3+colmn].spec_name}"/>
                            </c:forEach>
                        </zk:row>
                    </c:forEach>
                </zk:rows>
            </zk:grid>
        </zk:window>
    </zk:page>
</div>
