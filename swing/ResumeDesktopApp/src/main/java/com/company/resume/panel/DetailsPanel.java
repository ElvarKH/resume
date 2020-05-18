/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.resume.panel;

import com.company.resume.Config;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import com.company.entity.User;
import com.company.main.Context;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author HP
 */
public class DetailsPanel extends javax.swing.JPanel {

    CountryDaoInter countryDao = Context.instanceCountryDao();

    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form DetailsPanel
     */
    public DetailsPanel() {
        initComponents();
    }

    public void fillUserComponents() {                   // loggedInUser --> text fields
        fillWindow();
        
        User loggedInUser = Config.loggedInUser;

        Date dt = loggedInUser.getBirthDate();
        String dtStr = sdf.format(dt);

        txtPhone.setText(loggedInUser.getPhone());
        txtAddress.setText(loggedInUser.getAddress());
        txtEmail.setText(loggedInUser.getEmail());
        txtBirthdate.setText(dtStr);
        cbBirthplace.setSelectedItem(loggedInUser.getBirthPlace());
        cbNationality.setSelectedItem(loggedInUser.getNationality());
    }

    public void fillUser(User user) {                     // User fieldlere uygun yenilendi
        try {
            String birthDate = txtBirthdate.getText();
            String phone = txtPhone.getText();
            String address = txtAddress.getText();
            String email = txtEmail.getText();
            Country birthplace = (Country) cbBirthplace.getSelectedItem();
            Country nationality = (Country) cbNationality.getSelectedItem();

            java.util.Date dtUtil = sdf.parse(birthDate); // parse String --> util.Date
            long l = dtUtil.getTime();                    // getTime util.Date --> long
            java.sql.Date bd = new java.sql.Date(l);      // new --> sql.Date

            user.setBirthDate(bd);
            user.setPhone(phone);
            user.setAddress(address);
            user.setEmail(email);
            user.setBirthPlace(birthplace);
            user.setNationality(nationality);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void fillWindow() {                           // JComboBox dolduruldu
        List<Country> countries = countryDao.getAll();
        for (Country c : countries) {
            cbBirthplace.addItem(c);
            cbNationality.addItem(c);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        pnlDetails = new javax.swing.JPanel();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        lblPhone = new javax.swing.JLabel();
        txtPhone = new javax.swing.JTextField();
        lblEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lblBirthdate = new javax.swing.JLabel();
        txtBirthdate = new javax.swing.JTextField();
        lblBirthplace = new javax.swing.JLabel();
        lblNationality = new javax.swing.JLabel();
        cbBirthplace = new javax.swing.JComboBox<>();
        cbNationality = new javax.swing.JComboBox<>();

        jScrollPane1.setViewportView(jEditorPane1);

        pnlDetails.setToolTipText("");

        lblAddress.setText("Address");

        lblPhone.setText("Phone");

        lblEmail.setText("Email");

        lblBirthdate.setText("Birthdate");

        lblBirthplace.setText("Birthplace");

        lblNationality.setText("Nationality");

        cbNationality.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNationalityActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDetailsLayout = new javax.swing.GroupLayout(pnlDetails);
        pnlDetails.setLayout(pnlDetailsLayout);
        pnlDetailsLayout.setHorizontalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAddress)
                    .addComponent(lblPhone)
                    .addComponent(lblEmail)
                    .addComponent(lblBirthdate)
                    .addComponent(lblNationality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblBirthplace, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtBirthdate)
                    .addComponent(txtAddress)
                    .addComponent(txtPhone)
                    .addComponent(txtEmail)
                    .addComponent(cbBirthplace, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        pnlDetailsLayout.setVerticalGroup(
            pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDetailsLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAddress)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPhone)
                    .addComponent(txtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmail)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthdate)
                    .addComponent(txtBirthdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBirthplace)
                    .addComponent(cbBirthplace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlDetailsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNationality)
                    .addComponent(cbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlDetails, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cbNationalityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNationalityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNationalityActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<Country> cbBirthplace;
    private javax.swing.JComboBox<Country> cbNationality;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblBirthdate;
    private javax.swing.JLabel lblBirthplace;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblNationality;
    private javax.swing.JLabel lblPhone;
    private javax.swing.JPanel pnlDetails;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtBirthdate;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtPhone;
    // End of variables declaration//GEN-END:variables
}