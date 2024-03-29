/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.DoctorRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Essentials.Product;
import Business.Patient.Patient;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.ClaimWorkQueue;
import Business.WorkQueue.ClaimWorkRequest;
import Business.WorkQueue.PatientHospitalAppointmentWorkRequest;

import java.awt.CardLayout;
import java.awt.Component;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author raunak
 */
public class RequestLabTestJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Enterprise enterprise;
    private UserAccount userAccount;
    EcoSystem ecosystem;
    /**
     * Creates new form RequestLabTestJPanel
     */
   PatientHospitalAppointmentWorkRequest request;
    RequestLabTestJPanel(JPanel userProcessContainer, UserAccount account,Enterprise enterprise, EcoSystem ecosystem,PatientHospitalAppointmentWorkRequest request) {
        initComponents();
        this.request=request;
        this.userProcessContainer = userProcessContainer;
        this.enterprise=enterprise;
        this.userAccount = account;
        this.ecosystem=ecosystem;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSubmit = new javax.swing.JButton();
        txtResult = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        enterpriseLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSubmit.setBackground(new java.awt.Color(0, 0, 0));
        btnSubmit.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnSubmit.setForeground(new java.awt.Color(255, 255, 255));
        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        add(btnSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 340, 200, 60));
        add(txtResult, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 180, 260, -1));

        backJButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/back_to_501px.png"))); // NOI18N
        backJButton.setToolTipText("");
        backJButton.setBorder(null);
        backJButton.setBorderPainted(false);
        backJButton.setContentAreaFilled(false);
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        enterpriseLabel.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        enterpriseLabel.setText("PATIENT DIAGNOSIS");
        add(enterpriseLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, 260, 30));

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel2.setText("Message");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 190, -1, 20));

        jComboBox1.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "No", "Yes" }));
        add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, -1, -1));

        jLabel4.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel4.setText("Admit Patient:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, -1, -1));

        jComboBox2.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "General Room", "Deluxe Room", "ICU" }));
        add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, 160, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/5fd2e9831848f978715749_1.gif"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 470, -1, 330));
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        Patient patient = null;
        String result = txtResult.getText();
        request.setResult(result);
        request.setStatus("Consultation completed");
        String combo = (String) jComboBox1.getSelectedItem();
        String room = (String) jComboBox2.getSelectedItem();
        if(combo.equals("Yes"))
                {for(Product tester: ecosystem.getProductCatalog().getProductcatalog()){
                    if (tester.getProdName().equalsIgnoreCase("General Room")) {
                        int countR = tester.getAvail()-1;
                        tester.setAvail(countR);
                        request.setCost(300);
                    }
                    if (tester.getProdName().equalsIgnoreCase("Deluxe Room")) {
                        int countR = tester.getAvail()-1;
                        tester.setAvail(countR);
                        request.setCost(450);
                    }
                    if (tester.getProdName().equalsIgnoreCase("ICU")) {
                       int countR = tester.getAvail()-1;
                        tester.setAvail(countR);
                        request.setCost(550);
            }
                    
                }
           Map<String,Date> reqMap = request.getStatusMap();
            reqMap.put("Room Admitted:"+room, new Date());
        request.setStatusMap(reqMap); 
             ecosystem.getHospitalQueue().updateHospitalRequest(request, ecosystem.getHospitalQueue().hospitalRequestList()); 
                }
                   Map<String,Date> reqMap = request.getStatusMap();
            reqMap.put("Consultation Complete:"+txtResult.getText(), new Date());
        request.setStatusMap(reqMap); 
             ecosystem.getHospitalQueue().updateHospitalRequest(request, ecosystem.getHospitalQueue().hospitalRequestList());
        String insuranceCompany = request.getInsurance().getEnterprise();
        for(Patient p:ecosystem.getPatientDirectory().getpatientlist()){
            System.out.println(p.getUserName());
            System.out.println(request.getSender());
            if(p.getUserName().equals(request.getSender().toString()))
            { patient =p;
            
        }}
        ClaimWorkRequest r = new ClaimWorkRequest();
        r.setSender(userAccount);
        r.setPatient(patient);
        r.setRequestDate(new Date());
        r.setCost(request.getCost());
        r.setStatus("Claim Requested");
        r.setInsurancepolicy(request.getInsurance());
        r.setInsuranceEnterprise(insuranceCompany);
        r.setHospital(enterprise.toString());
        r.setInsuranceNo(request.getRequestNo());
         Map<String,Date> reqMap2 = request.getStatusMap();
            reqMap2.put("Claim Requested:"+request.getInsurance(), new Date());
        request.setStatusMap(reqMap2); 
        ecosystem.getHospitalQueue().updateHospitalRequest(request, ecosystem.getHospitalQueue().hospitalRequestList());
        ecosystem.getClaimWorkQueue().getWorkRequestList().add(r);
        userAccount.getClaimWorkQueue().getWorkRequestList().add(r);
        JOptionPane.showMessageDialog(null, "Successfully Submitted");
        
    }//GEN-LAST:event_btnSubmitActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        DoctorWorkAreaJPanel dwjp = (DoctorWorkAreaJPanel) component;
        dwjp.populateTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_backJButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel enterpriseLabel;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtResult;
    // End of variables declaration//GEN-END:variables
}
