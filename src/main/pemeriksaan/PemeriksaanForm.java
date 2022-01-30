/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.pemeriksaan;

import java.awt.Dimension;
import java.awt.HeadlessException;
import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import javax.swing.JOptionPane;
import main.Koneksi;

/**
 *
 * @author User
 */
public class PemeriksaanForm extends javax.swing.JInternalFrame {

    ArrayList idSpesialis = new ArrayList();
    ArrayList idDokter = new ArrayList();
    String tanggal;
    
    private void reset(){
        txtid.setEditable(false);
        txtidpasien.setText(null);
        txtnamapasien.setText(null);
        cbspesialis.setSelectedIndex(0);
        cbdokter.setSelectedIndex(0);
        tadiagnosa.setText(null);
        dttanggal.setDate(null);
        cbtindakan.setSelectedIndex(0);
        
        btnsimpan.setEnabled(true);
        btnupdate.setEnabled(false);
        btndelete.setEnabled(false);
        btncaripasien.setEnabled(true);

        kodePemeriksaan();

    }
    
    private void tampilSpesialis(){
        try{
            String sql = "SELECT * FROM spesialis";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                cbspesialis.addItem(res.getString(2));
                idSpesialis.add(res.getString(1));
            }
            
        }catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    private void tampilDokter(){
        try{
            String id_spesialis = (String) idSpesialis.get((int)cbspesialis.getSelectedIndex());
            String sql = "SELECT * FROM dokter WHERE id_spesialis='"+id_spesialis+"'";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            
            while(res.next()){
                cbdokter.addItem(res.getString(2));
                idDokter.add(res.getString(1));
            }
            
        }catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
    
    private void kodePemeriksaan(){
        try{
            String sql = "SELECT MAX(right(kode_periksa, 1)) AS kode_periksa FROM pemeriksaan";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            if(res.next()){
                int kode = res.getInt(1);
                String AN = "" + (kode + 1);
                String Nol = "";
                
                if(AN.length() == 1){
                    Nol = "00";
                }else if(AN.length() == 2){
                    Nol = "0";
                }else if(AN.length() == 3){
                    Nol = "";
                }
                
                txtid.setText("PRS" + Nol + AN);
                
            } else {
                txtid.setText("PRS001");
            }
        } catch (Exception e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
    }
    
    public PemeriksaanForm() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI)getUI()).setNorthPane(null);
        idSpesialis.add("0");
        idDokter.add("0");
        tampilSpesialis();
        kodePemeriksaan();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFormPemeriksaan = new javax.swing.JPanel();
        btncari = new javax.swing.JButton();
        btncaripasien = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtidpasien = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtnamapasien = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        cbspesialis = new javax.swing.JComboBox<>();
        cbdokter = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tadiagnosa = new javax.swing.JTextArea();
        jLabel26 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        dttanggal = new com.toedter.calendar.JDateChooser();
        jLabel27 = new javax.swing.JLabel();
        cbtindakan = new javax.swing.JComboBox<>();
        btnDataPemeriksaan = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        setPreferredSize(new java.awt.Dimension(780, 480));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelFormPemeriksaan.setBackground(new java.awt.Color(255, 255, 255));
        panelFormPemeriksaan.setMaximumSize(new java.awt.Dimension(900, 900));
        panelFormPemeriksaan.setPreferredSize(new java.awt.Dimension(780, 480));

        btncari.setBackground(new java.awt.Color(255, 255, 255));
        btncari.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cari.png"))); // NOI18N
        btncari.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btncari.setBorderPainted(false);
        btncari.setContentAreaFilled(false);
        btncari.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncari.setFocusable(false);
        btncari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncariActionPerformed(evt);
            }
        });

        btncaripasien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/cari.png"))); // NOI18N
        btncaripasien.setBorderPainted(false);
        btncaripasien.setContentAreaFilled(false);
        btncaripasien.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btncaripasien.setFocusable(false);
        btncaripasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncaripasienActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(51, 51, 255));
        jLabel15.setText("Kode Pemeriksaan");

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(51, 51, 255));
        jLabel16.setText("ID Pasien");

        txtid.setEditable(false);
        txtid.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtid.setText("Otomatis");
        txtid.setToolTipText("");
        txtid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));

        txtidpasien.setEditable(false);
        txtidpasien.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtidpasien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));

        jLabel67.setBackground(new java.awt.Color(102, 102, 255));
        jLabel67.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(51, 51, 255));
        jLabel67.setText("Input Data Pemeriksaan");

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(51, 51, 255));
        jLabel24.setText("Nama Pasien");

        txtnamapasien.setEditable(false);
        txtnamapasien.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        txtnamapasien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 255, 0)));

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(51, 51, 255));
        jLabel18.setText("Spesialis");

        cbspesialis.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbspesialis.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - Pilih Spesialis - -" }));
        cbspesialis.setBorder(null);
        cbspesialis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbspesialisActionPerformed(evt);
            }
        });

        cbdokter.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbdokter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - Pilih Dokter - -" }));
        cbdokter.setBorder(null);
        cbdokter.setOpaque(false);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(51, 51, 255));
        jLabel21.setText("Dokter");

        jLabel25.setBackground(new java.awt.Color(255, 255, 255));
        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(51, 51, 255));
        jLabel25.setText("Diagnosa");

        tadiagnosa.setColumns(20);
        tadiagnosa.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        tadiagnosa.setRows(5);
        tadiagnosa.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 4, 0, new java.awt.Color(0, 255, 0)));
        jScrollPane1.setViewportView(tadiagnosa);

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(51, 51, 255));
        jLabel26.setText("Tanggal Periksa");

        btnsimpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Vector.png"))); // NOI18N
        btnsimpan.setText(" Simpan");
        btnsimpan.setFocusable(false);
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Vector-1.png"))); // NOI18N
        btnupdate.setText(" Update");
        btnupdate.setEnabled(false);
        btnupdate.setFocusable(false);
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Group 2802.png"))); // NOI18N
        btndelete.setText(" Delete");
        btndelete.setEnabled(false);
        btndelete.setFocusable(false);
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnreset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Group 2803.png"))); // NOI18N
        btnreset.setText(" Reset");
        btnreset.setFocusable(false);
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });

        dttanggal.setDateFormatString("yyy-MM-dd");
        dttanggal.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dttanggal.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                dttanggalPropertyChange(evt);
            }
        });

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(51, 51, 255));
        jLabel27.setText("Tindakan");

        cbtindakan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cbtindakan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "- - Pilih Tindakan - -", "Rawat Inap", "Rawat Jalan" }));
        cbtindakan.setBorder(null);
        cbtindakan.setOpaque(false);

        btnDataPemeriksaan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/clipboard-square-symbol.png"))); // NOI18N
        btnDataPemeriksaan.setText(" Data Pemeriksaan");
        btnDataPemeriksaan.setFocusable(false);
        btnDataPemeriksaan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDataPemeriksaanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFormPemeriksaanLayout = new javax.swing.GroupLayout(panelFormPemeriksaan);
        panelFormPemeriksaan.setLayout(panelFormPemeriksaanLayout);
        panelFormPemeriksaanLayout.setHorizontalGroup(
            panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel67))
                    .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel21)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel27))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtnamapasien, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(cbdokter, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbspesialis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1)
                                    .addComponent(dttanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbtindakan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel16))
                                .addGap(29, 29, 29)
                                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtidpasien, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtid, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btncaripasien, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(82, 82, 82)
                                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFormPemeriksaanLayout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(btnDataPemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        panelFormPemeriksaanLayout.setVerticalGroup(
            panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67)
                .addGap(20, 20, 20)
                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtidpasien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtnamapasien, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbspesialis, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(9, 9, 9))
                    .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnreset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btncari, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnupdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btndelete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDataPemeriksaan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncaripasien, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)))
                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(cbdokter, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelFormPemeriksaanLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel25)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(dttanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26))
                .addGap(18, 18, 18)
                .addGroup(panelFormPemeriksaanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbtindakan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(panelFormPemeriksaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDataPemeriksaanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDataPemeriksaanActionPerformed
        DataPemeriksaanForm dataPemeriksaan = new DataPemeriksaanForm();
        this.getDesktopPane().add(dataPemeriksaan);
        Dimension gs = this.getDesktopPane().getSize();
        Dimension cs = dataPemeriksaan.getSize();

        dataPemeriksaan.setLocation((gs.width - cs.width) / 2, (gs.height - cs.height) / 2);
        
        dataPemeriksaan.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDataPemeriksaanActionPerformed

    private void cbspesialisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbspesialisActionPerformed
        cbdokter.removeAllItems();
        cbdokter.addItem("- - Pilih Dokter - -");
        idDokter.clear();
        idDokter.add("0");
        tampilDokter();
    }//GEN-LAST:event_cbspesialisActionPerformed

    private void btncaripasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncaripasienActionPerformed
        String id = JOptionPane.showInputDialog(null, "Cari Berdasarkan ID Pasien!!!");
        try{
            String sql = "SELECT * FROM pasien WHERE id_pasien='"+id+"'";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            if(res.next()){
                JOptionPane.showMessageDialog(null, "Data ditemukan");
                txtidpasien.setText(res.getString(1));
                txtnamapasien.setText(res.getString(2));
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak ditemukan");
                reset();
            }
        } catch (Exception e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
    }//GEN-LAST:event_btncaripasienActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        if(txtidpasien.getText().equals("") || txtnamapasien.getText().equals("") || cbspesialis.getSelectedIndex() ==  0 || cbdokter.getSelectedIndex() ==  0 || tadiagnosa.getText().equals("") || dttanggal.getDate().equals("") || cbtindakan.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(null, "Form Tidak Boleh Ada Yang Kosong!!!");
        }else{
            try {
                String id_dokter = (String) idDokter.get((int)cbdokter.getSelectedIndex());

                String sql = "INSERT INTO pemeriksaan(kode_periksa, id_pasien, id_dokter, diagnosa, tgl_periksa, tindakan) "
                    + "VALUES('"+txtid.getText()+"', '"+txtidpasien.getText()+"', '"+id_dokter+"','"+tadiagnosa.getText()+"','"+tanggal+"', '"+cbtindakan.getSelectedItem()+"')";
                java.sql.Connection conn = (Connection)Koneksi.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Prosess Simpan Data Pemeriksaan Berhasil..");
                reset();
                kodePemeriksaan();

            }catch (HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }//GEN-LAST:event_btnsimpanActionPerformed

    private void dttanggalPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_dttanggalPropertyChange
        if(dttanggal.getDate() != null){
            SimpleDateFormat tgl = new SimpleDateFormat("yyy-MM-dd");
            tanggal = tgl.format(dttanggal.getDate());
        }
    }//GEN-LAST:event_dttanggalPropertyChange

    private void btncariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncariActionPerformed
        String kode = JOptionPane.showInputDialog(null, "Cari Berdasarkan Kode Pemeriksaan!!!");
        try{
            String sql = "SELECT * FROM pemeriksaan "
                    + "INNER JOIN pasien ON pasien.id_pasien=pemeriksaan.id_pasien "
                    + "INNER JOIN dokter ON dokter.id_dokter=pemeriksaan.id_dokter "
                    + "INNER JOIN spesialis ON spesialis.id_spesialis=dokter.id_spesialis "
                    + "WHERE kode_periksa='"+kode+"'";
            java.sql.Connection conn=(Connection)Koneksi.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            if(res.next()){
                int id_spesialis = idSpesialis.indexOf(res.getString(18)); 
                JOptionPane.showMessageDialog(null, "Data ditemukan");
                txtid.setText(res.getString(1));
                txtidpasien.setText(res.getString(7));
                txtnamapasien.setText(res.getString(8));
                cbspesialis.setSelectedIndex(id_spesialis);
                
                int id_dokter = idDokter.indexOf(res.getString(13));
                cbdokter.setSelectedIndex(id_dokter);
                
                tadiagnosa.setText(res.getString(4));
                
                java.util.Date date = new SimpleDateFormat("yyy-MM-dd").parse((String)res.getString(5));
                dttanggal.setDate(date);
                
                cbtindakan.setSelectedItem(res.getString(6));
                
                btnsimpan.setEnabled(false);
                btnupdate.setEnabled(true);
                btndelete.setEnabled(true);
                btncaripasien.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "Data Tidak ditemukan");
                reset();
            }
        } catch (Exception e){
            System.out.print(e);
            JOptionPane.showMessageDialog(null, "Koneksi Gagal");
        }
    }//GEN-LAST:event_btncariActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        reset();
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        try {
            
            String id_dokter = (String) idDokter.get((int)cbdokter.getSelectedIndex());
            
            String sql = "UPDATE pemeriksaan SET id_pasien='"+txtidpasien.getText()+"', id_dokter='"+id_dokter+"', diagnosa='"+tadiagnosa.getText()+"', tgl_periksa='"+tanggal+"', tindakan='"+cbtindakan.getSelectedItem()+"' WHERE kode_periksa = '"+txtid.getText()+"'";
            java.sql.Connection conn = (Connection)Koneksi.configDB();
            java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Edit Data Pemeriksaan Berhasil...");
            kodePemeriksaan();
        }catch (HeadlessException | SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
        reset();
    }//GEN-LAST:event_btnupdateActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        int tanya = JOptionPane.showConfirmDialog(null, "Yakin untuk menghapus data ini?","Confirmation", JOptionPane.YES_NO_OPTION);
        
        if(tanya==0){
            try{
                String sql = "DELETE FROM pemeriksaan WHERE kode_periksa='"+txtid.getText()+"'";
                java.sql.Connection conn = (Connection)Koneksi.configDB();
                java.sql.PreparedStatement pstm = conn.prepareStatement(sql);
                pstm.execute();
                JOptionPane.showMessageDialog(null, "Hapus Data Pemeriksaaan Berhasil....");
            }catch (HeadlessException | SQLException e){
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
            reset();
            kodePemeriksaan();
        }
    }//GEN-LAST:event_btndeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDataPemeriksaan;
    private javax.swing.JButton btncari;
    private javax.swing.JButton btncaripasien;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btnupdate;
    private javax.swing.JComboBox<String> cbdokter;
    private javax.swing.JComboBox<String> cbspesialis;
    private javax.swing.JComboBox<String> cbtindakan;
    private com.toedter.calendar.JDateChooser dttanggal;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel panelFormPemeriksaan;
    private javax.swing.JTextArea tadiagnosa;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtidpasien;
    private javax.swing.JTextField txtnamapasien;
    // End of variables declaration//GEN-END:variables
}
