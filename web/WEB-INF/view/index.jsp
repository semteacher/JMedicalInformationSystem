<%@taglib prefix="zk" uri="http://www.zkoss.org/jsp/zul"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.zkoss.zkplus.databind.AnnotateDataBinderInit"%>
<%--     Document   : index
    Created on : 03.01.2012, 17:23:14
    Author     : marceniuk
--%>
<sql:query var="hospitaltype" dataSource="jdbc/mis">
    SELECT * FROM mis.mis_guide_hospital_type
</sql:query>
<jsp:useBean id="MisBean" class="session.MisSessionBean" scope="session"/>
<div id="content">
    <zk:page  id="pg1" style="height:600px;width=100%">
        <zk:init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"/>
        <zk:window sclass="mainwnd" id="myWin" title="Виберіть тип лікувального закладу:" border="normal">
            <zk:style src="css/zkstyle.css"/>
            <zk:grid sclass="maingrid" id="myzkid1" mold="paging" pageSize="10">
                <zk:rows>
                    <c:forEach var="myhosptypes" items="${hospitaltype.rows}" varStatus="status">
                        <zk:row>
                            <zk:a href="/hospitals?hosptypeid=${myhosptypes.id}" label="${myhosptypes.type_name}"/>
                        </zk:row>
                    </c:forEach>
                </zk:rows>
            </zk:grid>
        </zk:window>
    </zk:page>   
</div>
