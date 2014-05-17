/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.MisSessionBean;

/**
 *
 * @author marceniuk
 */

public class ControllerServlet extends HttpServlet {

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();
        HttpSession session = request.getSession(true);

        // if welcome page is requested
        if (userPath.equals("/welcome")) {
            // TODO: Implement welcome request

            userPath = "/index";

        } // if hospitals page is requested
        else if (userPath.equals("/hospitals")) {
            // TODO: Implement hospitals request
            int tmphosptype = Integer.parseInt(request.getParameter("hosptypeid"));
            MisSessionBean tmpmisbeen = (MisSessionBean) session.getAttribute("MisBean");
            tmpmisbeen.setSelhosptype(tmphosptype);
            session.setAttribute("MisBean", tmpmisbeen);
            userPath = "/02hospitals";
        } // if hospital_specialities page is requested
        else if (userPath.equals("/hospital_specialities")) {
            // TODO: Implement hospital_specialities request
            int tmphospital = Integer.parseInt(request.getParameter("hospid"));
            MisSessionBean tmpmisbeen = (MisSessionBean) session.getAttribute("MisBean");
            tmpmisbeen.setSelhospital(tmphospital);
            session.setAttribute("MisBean", tmpmisbeen);
            userPath = "/03hospital_specialities";
        } // if hospital_physicians_speciality page is requested
        else if (userPath.equals("/hospital_physicians_speciality")) {
            // TODO: Implement hospital_physicians_specialities request
            int tmpspeciality = Integer.parseInt(request.getParameter("specid"));
            MisSessionBean tmpmisbeen = (MisSessionBean) session.getAttribute("MisBean");
            tmpmisbeen.setSelspeciality(tmpspeciality);
            session.setAttribute("MisBean", tmpmisbeen);
            userPath = "/04hospital_physician_speciality";
        } // if hospital_specialities page is requested
        else if (userPath.equals("/physician_schedule")) {
            // TODO: Implement physician_schedule request
            int tmpdoctorinhosp = Integer.parseInt(request.getParameter("doctorinhospid"));
            MisSessionBean tmpmisbeen = (MisSessionBean) session.getAttribute("MisBean");
            tmpmisbeen.setSeldoctorinhosp(tmpdoctorinhosp);
            session.setAttribute("MisBean", tmpmisbeen);
            userPath = "/05physician_shedule";
        } // if patient_registration page is requested
        else if (userPath.equals("/patient_registration")) {
            // TODO: Implement patient_registration request
            int tmpsheduleid = Integer.parseInt(request.getParameter("sheduleid"));
            MisSessionBean tmpmisbeen = (MisSessionBean) session.getAttribute("MisBean");
            tmpmisbeen.setSelsheduleitem(tmpsheduleid);
            session.setAttribute("MisBean", tmpmisbeen);
            userPath = "/06patient_registration";
        } // if patient_confirmation page is requested
        else if (userPath.equals("/patient_confirmation")) {
            // TODO: Implement patient_confirmation request

            userPath = "/07patient_confirmation";
        } // if hospital_specialities page is requested
        else if (userPath.equals("/patient_records")) {
            // TODO: Implement patient_records request

            userPath = "/08patient_records";
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";
        //String url = userPath + ".jsp";
        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userPath = request.getServletPath();

        // if assignToPhysician action is called
        if (userPath.equals("/assignToPhysician")) {
            // TODO: Implement add to physician action
            // if chooseHospitalofGivenType action is called
        } else if (userPath.equals("/chooseHospitalofGivenType")) {
            // TODO: Implement choose hospital of given type
            userPath = "/03hospital_specialities";

            // if chooseSpeciality action is called
        } else if (userPath.equals("/chooseSpeciality")) {
            // TODO: Implement choose spesiality of physician
            userPath = "/04hospital_physician_speciality";

            // if choosePhysician action is called
        } else if (userPath.equals("/choosePhysician")) {
            // TODO: Implement choose physician action
            userPath = "/physician_shedule";

            // if enterPatientData action is called
        } else if (userPath.equals("/enterPatientData")) {
            // TODO: Implement enter patient data to system
            // if printConfirmationPage action is called
        } else if (userPath.equals("/printConfirmationPage")) {
            // TODO: Implement print confirmation page
            // if finishAssignment action is called
        } else if (userPath.equals("/finishAssignment")) {
            // TODO: Implement finish assignment for patient
            userPath = "/08patient_records";

            // if cancelPatientAssignment action is called
        } else if (userPath.equals("/cancelPatientAssignment")) {
            // TODO: Implement cancel patient assignment for patient 
            userPath = "/05physician_shedule";
            // if finishSession action is called
        } else if (userPath.equals("/finishSession")) {
            // TODO: Implement finish session for patient
            userPath = "/index";
        }

        // use RequestDispatcher to forward request internally
        String url = "/WEB-INF/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}