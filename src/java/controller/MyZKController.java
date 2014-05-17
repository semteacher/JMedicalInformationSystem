/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.servlet.http.HttpSession;

import org.zkoss.zk.ui.util.GenericForwardComposer;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zul.Button;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Datebox;

import session.MisSessionBean;
import beans.MisPatient;
/**
 *
 * @author roman
 */
public class MyZKController extends GenericForwardComposer {

    private HttpSession mysession;
    private Button saveBtn;
    private Textbox firstname;
    private Textbox familyname;
    private Textbox thirdname;
    private Datebox birthday;
    private Textbox address;
    private Textbox email;
    private Textbox phone1;
    private Textbox phone2;

    public void onClick$saveBtn() {       
        mysession = (HttpSession) (Executions.getCurrent()).getDesktop().getSession().getNativeSession();
        MisPatient newpatient = (MisPatient) mysession.getAttribute("NewPatient");
        MisSessionBean tmpmisbeen = (MisSessionBean) mysession.getAttribute("MisBean");
        
        newpatient.setName(firstname.getText());
        newpatient.setFamily(familyname.getText());
        newpatient.setThirdName(thirdname.getText());
        newpatient.setAdress(address.getText());
        newpatient.setEmail(email.getText());
        newpatient.setPhone1(phone1.getText());
        newpatient.setPhone2(phone2.getText());
        newpatient.setBirthday(birthday.getValue());
        
        tmpmisbeen.setNewpatient(true);
        
        mysession.setAttribute("NewPatient", newpatient);
        mysession.setAttribute("MisBean", tmpmisbeen);
        
        //String mystr = firstname.getText();
        //MisSessionBean tmpmisbeen = (MisSessionBean) mysession.getAttribute("MisBean");
        //tmpmisbeen.setPatientName(mystr);
        //mysession.setAttribute("MisBean", tmpmisbeen);
        Executions.sendRedirect("/patient_confirmation");
    }
}
