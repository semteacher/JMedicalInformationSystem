<%@taglib prefix="zk" uri="http://www.zkoss.org/jsp/zul"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="org.zkoss.zk.ui.Executions"%>
<%-- 
    Document   : 06patient_registration
    Created on : 04.01.2012, 9:27:13
    Author     : semteacher1977
--%>
<jsp:useBean id="MisBean" class="session.MisSessionBean" scope="session"/>
<jsp:useBean id="NewPatient" class="beans.MisPatient" scope="session"/>
<div id="content">
    <zk:page id="pg2" style="height:600px;width=1000px">
        <zk:init class="org.zkoss.zkplus.databind.AnnotateDataBinderInit"/>
        <zk:window sclass="mainwnd" width="600px" id="hospWin" title="Для запису на прийом зареєструйтесь, будь-ласка:" border="normal" apply="controller.MyZKController">
            <zk:style src="../../css/zkstyle.css"/>           
            <zk:grid sclass="maingrid" id="myzkid6" fixedLayout="true">
                <zk:columns>
                    <zk:column width="200px" />            
                    <zk:column width="350px" />
                </zk:columns>
                <zk:rows>
                    <zk:row>
                        <zk:label value="Прізвище *" width="150px" />
                        <zk:hlayout>
                            <zk:textbox id="familyname" value="" width="250px" constraint="no empty, : Введіть прізвище!"/>
                        </zk:hlayout>
                    </zk:row>
                    <zk:row>
                        <zk:label value="Ім'я *" width="150px" />
                        <zk:hlayout>
                            <zk:textbox id="firstname" value="" width="250px" constraint="no empty, : Введіть і'мя!"/>
                        </zk:hlayout>
                    </zk:row>          
                    <zk:row>
                        <zk:label value="По-батькові *" width="150px" />
                        <zk:hlayout>
                            <zk:textbox id="thirdname" value="" width="250px" constraint="no empty, : Введіть по-батькові!"/>
                        </zk:hlayout>
                    </zk:row>          
                    <zk:row>
                        <zk:label value="Дата народження *" width="250px" />
                        <zk:hlayout>
                            <zk:datebox id="birthday" format="dd/MM/yyyy" width="250px" constraint="no empty, : Введіть дату народження!"/>
                        </zk:hlayout>
                    </zk:row>  
                    <zk:row>
                        <zk:label value="Адреса *" width="150px" />
                        <zk:hlayout>
                            <zk:textbox id="address" value="" width="250px" />
                        </zk:hlayout>
                    </zk:row>          
                    <zk:row>
                        <zk:label value="e-mail" width="150px" />
                        <zk:hlayout>
                            <zk:textbox id="email" value="" constraint="/.+@.+\.[a-z]+/: Будь-ласка, введіть адресу електронної пошти" width="250px"/>
                        </zk:hlayout>
                    </zk:row> 
                    <zk:row>
                        <zk:cell colspan="2" style="text-align:center">
                            <zk:label value="Обовязково повинен бути заповнений хоча б один номер телефону:"/>
                        </zk:cell>
                    </zk:row> 
                    <zk:row>
                        <zk:label value="Телефон" width="150px" />
                        <zk:hlayout>
                            <zk:textbox id="phone1" value="" cols="10" width="250px" />
                        </zk:hlayout>
                    </zk:row>          
                    <zk:row>
                        <zk:label value="Телефон (моб)" width="150px" />
                        <zk:hlayout>
                            <zk:textbox id="phone2" value="" cols="10" width="250px"/>
                        </zk:hlayout>
                    </zk:row> 
                    <zk:row>
                        <zk:button id="saveBtn" label="Записатися!" width="100px" height="30px">                  
                            <%--
                            <zk:attribute name="onClick">         
                                import javax.servlet.http.HttpSession; 
                                import session.MisSessionBean;
                                
                                String mystr = firstname.value;                               
                                HttpSession session = (HttpSession)(Executions.getCurrent()).getDesktop().getSession().getNativeSession();
                                MisSessionBean tmpmisbeen = (MisSessionBean) session.getAttribute("MisBean");
                                tmpmisbeen.setPatientName(mystr);
                                session.setAttribute("MisBean", tmpmisbeen);
                                Executions.sendRedirect("/patient_confirmation?name="+mystr);
                            </zk:attribute>
                            --%>
                        </zk:button>
                        <zk:button label="Відмінити!" width="100px" height="30px">                  
                            <zk:attribute name="onClick">
                                Executions.sendRedirect("/physician_schedule?doctorinhospid="+${MisBean.seldoctorinhosp});
                            </zk:attribute>
                        </zk:button>
                    </zk:row> 
                </zk:rows>
            </zk:grid>
            <zk:label value="* - обовязкові поля для заповнення" width="150px" />
        </zk:window>
    </zk:page>
</div>