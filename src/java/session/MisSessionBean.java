/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package session;

import java.util.*;
import javax.ejb.*;


/**
 *
 * @author Admin
 */

public class MisSessionBean {

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
  
    int selhosptype = 0;
    int selhospital = 0;
    int selspeciality = 0;
    int seldoctorinhosp = 0;
    int selsheduleitem = 0;    
    Boolean newpatient = false;
    String patientname = "defName";
    
    public Boolean getNewpatient() {
        return newpatient;
    }

    public void setNewpatient(Boolean newpatient) {
        this.newpatient = newpatient;
    }
    
    public String getPatientName() {
        return patientname;
    }

    public void setPatientName(String patientname) {
        this.patientname = patientname;
    }

    public int getSelsheduleitem() {
        return selsheduleitem;
    }

    public void setSelsheduleitem(int selsheduleitem) {
        this.selsheduleitem = selsheduleitem;
    }

    public int getSeldoctorinhosp() {
        return seldoctorinhosp;
    }

    public void setSeldoctorinhosp(int seldoctorinhosp) {
        this.seldoctorinhosp = seldoctorinhosp;
    }

    public int getSelspeciality() {
        return selspeciality;
    }

    public void setSelspeciality(int selspeciality) {
        this.selspeciality = selspeciality;
    }

    public int getSelhospital() {
        return selhospital;
    }

    public void setSelhospital(int selhospital) {
        this.selhospital = selhospital;
    }

    /**
     * Get the value of selhosptype
     *
     * @return the value of selhosptype
     */
    public int getSelhosptype() {
        return selhosptype;
    }

    /**
     * Set the value of selhosptype
     *
     * @param selhosptype new value of selhosptype
     */
    public void setSelhosptype(int selhosptype) {
        this.selhosptype = selhosptype;
    }


    

    
    
    
}
