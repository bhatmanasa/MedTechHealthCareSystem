/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.VaccineScientistRole;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Organization.Organization;
import Business.Organization.VaccineCompanyOrganization;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;
import Business.WorkQueue.VaccineWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import static java.lang.Boolean.FALSE;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Manasa
 */
public class DrugDevelopmentJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DrugDevelopmentJPanel
     */
    private JPanel userProcessContainer;
    private UserAccount account;
    private VaccineCompanyOrganization organization;
    private Enterprise enterprise;
    private EcoSystem business;     
    private Vaccine vaccine;
    public DrugDevelopmentJPanel(JPanel userProcessContainer, UserAccount account, VaccineCompanyOrganization Organization, Enterprise enterprise,EcoSystem business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.account = account;
        this.organization  =Organization;
        this.business = business;
        this.enterprise = enterprise;
        this.vaccine = null;
        populateDrugProjectTable();
        this.setSize(1466, 902);
        introPanel.setBounds(171, 33, 1293, 101);
        jLabel3.setBounds(1, 1, 160, 113);
        btnProceed.setBounds(1207, 135, 258, 73);
        jTabbedPane3.setBounds(2, 150, 1206, 623);
        jLabel1.setBounds(1,135,230,33);
        btnRemove.setBounds(164, 542, 590, 66);
        reasonText.setBounds(164, 387, 590, 95);
        jPanel1.setSize(1190,600);
                        DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer();
        headerRenderer.setBackground(java.awt.Color.BLACK);
         headerRenderer.setForeground(java.awt.Color.WHITE);

        for (int i = 0; i < drugProjectTable.getModel().getColumnCount(); i++) {
            drugProjectTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
        }
        
        drugProjectTable.setShowGrid(true);
       drugProjectTable.getTableHeader().setFont(new Font("SansSerif 14 Plain",Font.BOLD,16));
    }
        public void populateDrugProjectTable(){
          DefaultTableModel model = (DefaultTableModel)drugProjectTable.getModel();
        model.setRowCount(0);
        List<VaccineWorkRequest> requestList = account.getVaccineWorkQueue().getVaccineRequestList();
        for(VaccineWorkRequest req: requestList){
                    Map<String,Date> map = req.getStatusMap();
            String latestKey = "";
            for (Map.Entry<String,Date> mapEntry : req.getStatusMap().entrySet()) {  
                if(latestKey.equals("")){
            latestKey = mapEntry.getKey();
                }
                if((map.get(latestKey).compareTo(map.get(mapEntry.getKey()))) < 0){
                    latestKey = mapEntry.getKey();
                }
               }
            if(latestKey.equals("Formulation Phase")){
            Object row[] = new Object[8];
                 row[0] = req;
                 row[1] = req.getVaccine().getName();
                 row[2] = req.getVaccine().getCondition();
                 row[3] = req.getRequestDate();
            
            if(req.getSender() == null){
                 row[4] = "";
            }else{
                 row[4] = req.getSender();
            }

   
                 row[5] = latestKey;
            

            
            model.addRow(row); 
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane3 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        drugProjectTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnProceed = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnRemove = new javax.swing.JButton();
        reasonText = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        introPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        lblEnterprise = new javax.swing.JLabel();
        lblAccount = new javax.swing.JLabel();
        backJButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane3.setBackground(new java.awt.Color(204, 204, 204));
        jTabbedPane3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTabbedPane3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane3StateChanged(evt);
            }
        });
        jTabbedPane3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTabbedPane3FocusGained(evt);
            }
        });
        jTabbedPane3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPane3MouseClicked(evt);
            }
        });
        jTabbedPane3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTabbedPane3KeyPressed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        drugProjectTable.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        drugProjectTable.setForeground(new java.awt.Color(0, 0, 51));
        drugProjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "VaccineID", "DrugName", "Type", "CreateDate", "Sender", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(drugProjectTable);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 51));
        jLabel1.setText("Drug Project List");

        btnProceed.setBackground(new java.awt.Color(0, 0, 51));
        btnProceed.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnProceed.setForeground(new java.awt.Color(102, 102, 102));
        btnProceed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/proceedReq.png"))); // NOI18N
        btnProceed.setText("Proceed Drug Request");
        btnProceed.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        btnProceed.setContentAreaFilled(false);
        btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProceedActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(257, 257, 257)
                        .addComponent(btnProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnProceed, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 436, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("DrugProjects", jPanel2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1187, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 595, Short.MAX_VALUE)
        );

        jTabbedPane3.addTab("DevelopVaccine", jPanel1);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        btnRemove.setBackground(new java.awt.Color(204, 204, 204));
        btnRemove.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        btnRemove.setForeground(new java.awt.Color(51, 0, 0));
        btnRemove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/clear.png"))); // NOI18N
        btnRemove.setText("Remove Project");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        reasonText.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel2.setText("Provide detailed reason for closure of the Drug Project:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 51));
        jLabel7.setText("Remove Vaccine ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(266, 266, 266)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(reasonText, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(511, 511, 511)
                        .addComponent(jLabel7)))
                .addContainerGap(349, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel7)
                .addGap(79, 79, 79)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(reasonText, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(btnRemove, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(173, Short.MAX_VALUE))
        );

        jTabbedPane3.addTab("RemoveVaccine", jPanel3);

        introPanel.setBackground(new java.awt.Color(0, 51, 153));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Drug Development Portal");

        lblEnterprise.setBackground(new java.awt.Color(51, 51, 51));
        lblEnterprise.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblEnterprise.setForeground(new java.awt.Color(255, 255, 255));
        lblEnterprise.setText("Enterprise:");
        lblEnterprise.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        lblAccount.setBackground(new java.awt.Color(51, 51, 51));
        lblAccount.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        lblAccount.setForeground(new java.awt.Color(255, 255, 255));
        lblAccount.setText("Enterprise:");
        lblAccount.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        backJButton1.setBackground(new java.awt.Color(0, 0, 102));
        backJButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        backJButton1.setForeground(new java.awt.Color(255, 255, 255));
        backJButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/home2.png"))); // NOI18N
        backJButton1.setText("Home");
        backJButton1.setBorder(null);
        backJButton1.setBorderPainted(false);
        backJButton1.setContentAreaFilled(false);
        backJButton1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        backJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout introPanelLayout = new javax.swing.GroupLayout(introPanel);
        introPanel.setLayout(introPanelLayout);
        introPanelLayout.setHorizontalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introPanelLayout.createSequentialGroup()
                .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(introPanelLayout.createSequentialGroup()
                        .addComponent(lblAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(introPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4)))
                .addGap(227, 227, 227)
                .addComponent(backJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        introPanelLayout.setVerticalGroup(
            introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, introPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(introPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(introPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(lblAccount, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(introPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEnterprise, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, introPanelLayout.createSequentialGroup()
                        .addComponent(backJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Pictures/drugDev.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(introPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(introPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jTabbedPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProceedActionPerformed
        // TODO add your handling code here:
        int selectedRow = drugProjectTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Vaccine row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VaccineWorkRequest vaccineReq= (VaccineWorkRequest)drugProjectTable.getValueAt(selectedRow, 0);
        Map<String,Date> reqMap = vaccineReq.getStatusMap();
        reqMap.put("Vaccine Request Created", new Date());
        vaccineReq.setStatusMap(reqMap);
        vaccineReq.setSuccess("ongoing");
        vaccineReq.setPhase("development");
        business.getVaccineQueue().updateWorkRequest(vaccineReq, business.getVaccineQueue().getVaccineRequestList());
            JOptionPane.showMessageDialog(null, "Vaccine proceeds from Discovery phase!", "Information", JOptionPane.INFORMATION_MESSAGE);
        populateDrugProjectTable();
    }//GEN-LAST:event_btnProceedActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        if(reasonText.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please provide reason for vaccine request removal!!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int selectedRow = drugProjectTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Vaccine row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VaccineWorkRequest vacReq= (VaccineWorkRequest)drugProjectTable.getValueAt(selectedRow, 0);
        Map<String,Date> reqMap = vacReq.getStatusMap();
        reqMap.put("Request Removed: "+reasonText.getText(), new Date());
        vacReq.setStatusMap(reqMap);
        vacReq.setSuccess("drop");
        vacReq.setReceiver(account);
        vacReq.setResolveDate(new Date());
        business.getVaccineQueue().updateWorkRequest(vacReq, business.getVaccineQueue().getVaccineRequestList());

        populateDrugProjectTable();
        reasonText.setText("");
        JOptionPane.showMessageDialog(null, "Request has been removed!", "Information", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void jTabbedPane3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTabbedPane3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane3KeyPressed

    private void jTabbedPane3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPane3MouseClicked
        // TODO add your handling code here:
if(this.jTabbedPane3.getSelectedIndex() == 0){//all new drug requests
    populateDrugProjectTable();
}else if(this.jTabbedPane3.getSelectedIndex() == 1){//view each vaccine details
    if(jPanel1.getComponentCount() > 0){
    jPanel1.remove(0);
    }
           int selectedRow = drugProjectTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Vaccine row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        VaccineWorkRequest vaccineReq= (VaccineWorkRequest)drugProjectTable.getValueAt(selectedRow, 0);

        ViewVaccineJPanel viewVaccineJPanel=new ViewVaccineJPanel(jPanel1,account,business,vaccineReq.getVaccine(),true,true);
   jPanel1.add(viewVaccineJPanel);

        
}else if(this.jTabbedPane3.getSelectedIndex() == 2){//remove vaccine request
            int selectedRow = drugProjectTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Vaccine row!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
}
    }//GEN-LAST:event_jTabbedPane3MouseClicked

    private void backJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButton1ActionPerformed
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        VaccineScientistWorkAreaJPanel sysAdminwjp = (VaccineScientistWorkAreaJPanel) component;

        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButton1ActionPerformed

    private void jTabbedPane3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTabbedPane3FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane3FocusGained

    private void jTabbedPane3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane3StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jTabbedPane3StateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton1;
    private javax.swing.JButton btnProceed;
    private javax.swing.JButton btnRemove;
    private javax.swing.JTable drugProjectTable;
    private javax.swing.JPanel introPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane3;
    private javax.swing.JLabel lblAccount;
    private javax.swing.JLabel lblEnterprise;
    private javax.swing.JTextField reasonText;
    // End of variables declaration//GEN-END:variables
}
