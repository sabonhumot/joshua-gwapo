/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import admin.crud.addPatient;
import admin.crud.editPatient;
import java.awt.Color;
import careq.logIn;
import config.connectDB;
import config.session;
import gfx.RoundedPanel;
import gfx.RoundedTextField;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;
import gfx.RoundGradientButton;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Vector;

/**
 *
 * @author Administrator
 */
public class patientMenu extends javax.swing.JFrame {

    Color mainColor = new Color(37, 171, 241);
    Color hoverColor = new Color(31, 128, 179);

    Color logoutColor = new Color(100, 188, 234);
    Color hoverlogoutColor = new Color(250, 249, 246);

    public patientMenu() {
        initComponents();
        loadOpenSans();
        displayData();
        getPatientCount();
        emptyData();

        addPatient addp = new addPatient();
        addp.setVisible(false);

    }

    public void emptyData() {

        if (usersTable.getModel().getRowCount() == 0) {

            jLabel3.setVisible(true);
            jLabel4.setVisible(true);

        } else {
            jLabel3.setVisible(false);
            jLabel4.setVisible(false);
        }

    }

    public void displayData() {
        try {
            connectDB con = new connectDB();
            ResultSet rs = con.getData("SELECT u_id, u_fname, u_lname, u_email, u_pnum, status FROM user WHERE type = 'Patient'");

            String[] column = {"ID", "First Name", "Last Name", "Email", "Phone Number", "Account Status"};

            DefaultTableModel editableModel = (DefaultTableModel) DbUtils.resultSetToTableModel(rs);
            rs.close();

            DefaultTableModel model = new DefaultTableModel(editableModel.getDataVector(), new Vector<>(Arrays.asList(column))) {
                @Override
                public boolean isCellEditable(int row, int column) {
                    return false; // Disable editing for all cells
                }
            };

            usersTable.setModel(model);

            // Header Renderer
            DefaultTableCellRenderer headerRenderer = new DefaultTableCellRenderer() {
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = new JLabel(value.toString());
                    label.setFont(new Font("OpenSans", Font.BOLD, 12));
                    label.setPreferredSize(new Dimension(label.getWidth(), 30));
                    label.setOpaque(true);
                    label.setBackground(new Color(250, 249, 246));
                    label.setForeground(Color.BLACK);
                    label.setHorizontalAlignment(SwingConstants.LEFT);
                    label.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 0));
                    return label;
                }
            };

            // Apply custom header renderer
            for (int i = 0; i < usersTable.getColumnModel().getColumnCount(); i++) {
                usersTable.getColumnModel().getColumn(i).setHeaderRenderer(headerRenderer);
            }

            // Cell Renderer
            DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = new JLabel(value != null ? value.toString() : "");
                    label.setFont(new Font("OpenSans", Font.PLAIN, 12));
                    label.setOpaque(true);
                    if (row % 2 == 0) {
                        label.setBackground(new Color(245, 245, 245));
                    } else {
                        label.setBackground(Color.WHITE);
                    }
                    label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
                    label.setHorizontalAlignment(SwingConstants.LEFT);

                    if (isSelected) {
                        label.setBackground(new Color(220, 240, 255));
                        label.setForeground(Color.BLACK);
                    }

                    return label;
                }
            };

            // Apply renderer to all columns
            for (int i = 0; i < usersTable.getColumnModel().getColumnCount(); i++) {
                usersTable.getColumnModel().getColumn(i).setCellRenderer(cellRenderer);
            }

            // Status Column Renderer
            class StatusRenderer extends DefaultTableCellRenderer {

                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    JLabel label = new JLabel(value.toString());
                    label.setOpaque(true);
                    label.setHorizontalAlignment(SwingConstants.CENTER);
                    label.setFont(new Font("Open Sans", Font.PLAIN, 12));

                    switch (value.toString()) {
                        case "Active":
                            label.setBackground(new Color(144, 238, 144)); // Light Green
                            label.setForeground(Color.BLACK);
                            break;
                        case "Pending":
                            label.setBackground(new Color(255, 223, 128)); // Light Orange
                            label.setForeground(new Color(102, 51, 0));
                            break;
                        default:
                            label.setBackground(Color.GRAY);
                            label.setForeground(Color.BLACK);
                            break;
                    }

                    if (isSelected) {
                        label.setBackground(new Color(220, 240, 255));
                    }

                    return label;
                }
            }

            // Apply custom renderer to "Account Status" column (index 6)
            usersTable.getColumnModel().getColumn(5).setCellRenderer(new StatusRenderer());

        } catch (SQLException ex) {
            System.out.println("Errors: " + ex.getMessage());
        }
    }

    public void getPatientCount() {

        connectDB con = new connectDB();

        try {

            ResultSet rs = con.getData("SELECT COUNT(*) FROM user WHERE type = 'Patient'");
            if (rs.next()) {
                int count = rs.getInt(1);

                P.setText(String.valueOf(count));
            }

        } catch (SQLException ex) {
            System.out.println("" + ex);

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainbg = new javax.swing.JPanel();
        dboard = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dboardBG = new RoundedPanel(15);
        pAccOV = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        searchh = new RoundedTextField(35);
        jLabel8 = new javax.swing.JLabel();
        delete = new gfx.RoundGradientButton ("Delete", new Color(220, 53, 69), new Color(255, 0, 0), 30);
        add = new gfx.RoundGradientButton ("Add Patient", new Color(40, 167, 69), new Color(0, 208, 132), 30);
        edit = new gfx.RoundGradientButton ("Edit", new Color(229, 161, 0), new Color(255, 170, 0), 30);
        refresh = new gfx.RoundGradientButton ("Refresh", new Color(25, 175, 219), new Color(21, 162, 203), 30);
        jPanel4 = new RoundedPanel(15);
        P = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        patient = new javax.swing.JLabel();
        jPanel1 = new RoundedPanel(5);
        doctorPanel = new RoundedPanel(50);
        jLabel9 = new javax.swing.JLabel();
        doctor1 = new javax.swing.JLabel();
        patientPanel = new RoundedPanel(50);
        jLabel15 = new javax.swing.JLabel();
        patient1 = new javax.swing.JLabel();
        dashboardPanel = new RoundedPanel(50);
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        logoutPanel = new RoundedPanel(25);
        jLabel6 = new javax.swing.JLabel();
        logout = new javax.swing.JLabel();
        profilePanel = new RoundedPanel(50);
        jLabel16 = new javax.swing.JLabel();
        profile = new javax.swing.JLabel();
        accMngrPanel = new RoundedPanel(50);
        jLabel17 = new javax.swing.JLabel();
        accM = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        logsPanel = new RoundedPanel(50);
        jLabel19 = new javax.swing.JLabel();
        profile1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new java.awt.CardLayout());

        mainbg.setBackground(new java.awt.Color(245, 245, 245));
        mainbg.setMinimumSize(new java.awt.Dimension(1017, 620));
        mainbg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(250, 249, 246));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setText("Patient Menu");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 300, -1));

        dboard.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 910, 70));

        dboardBG.setBackground(new java.awt.Color(250, 249, 246));
        dboardBG.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pAccOV.setText("Patients Account Overview");
        dboardBG.add(pAccOV, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 340, -1));

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 153, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("No data available");
        dboardBG.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 300, 120, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/no-data.png"))); // NOI18N
        dboardBG.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, -1, -1));

        usersTable.getTableHeader().setOpaque(false);
        usersTable.setBackground(new java.awt.Color(250, 249, 246));
        usersTable.setDragEnabled(true);
        usersTable.setEditingColumn(0);
        usersTable.setEditingRow(0);
        usersTable.setOpaque(false);
        usersTable.setRowHeight(30);
        usersTable.setShowHorizontalLines(false);
        usersTable.setShowVerticalLines(false);
        usersTable.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                usersTableMouseMoved(evt);
            }
        });
        usersTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                usersTableMouseEntered(evt);
            }
        });
        scroll.setViewportView(usersTable);

        dboardBG.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 840, 360));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/clear.png"))); // NOI18N
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        dboardBG.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 50, 20, 30));

        searchh.setBackground(new java.awt.Color(240, 240, 240));
        searchh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchhActionPerformed(evt);
            }
        });
        searchh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                searchhKeyTyped(evt);
            }
        });
        dboardBG.add(searchh, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 50, 190, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        dboardBG.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 50, 20, 30));

        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-delete-15.png"))); // NOI18N
        delete.setText("Delete");
        delete.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        delete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteMouseClicked(evt);
            }
        });
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        dboardBG.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 100, 30));

        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/add.png"))); // NOI18N
        add.setText("Add Patient");
        add.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        dboardBG.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 50, 140, 30));

        edit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editt.png"))); // NOI18N
        edit.setText("Edit");
        edit.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editActionPerformed(evt);
            }
        });
        dboardBG.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 100, 30));

        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/refresh.png"))); // NOI18N
        refresh.setText("Refresh");
        refresh.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        refresh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshMouseExited(evt);
            }
        });
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        dboardBG.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 100, 30));

        dboard.add(dboardBG, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 220, 870, 470));

        jPanel4.setBackground(new java.awt.Color(250, 249, 246));
        jPanel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel4.setLayout(null);
        jPanel4.add(P);
        P.setBounds(80, 50, 30, 40);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/patient.png"))); // NOI18N
        jPanel4.add(jLabel11);
        jLabel11.setBounds(20, 50, 40, 40);

        patient.setText("Patients");
        patient.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel4.add(patient);
        patient.setBounds(20, 20, 90, 14);

        dboard.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 870, 110));

        mainbg.add(dboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 910, 700));

        jPanel1.setBackground(new java.awt.Color(37, 171, 241));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        doctorPanel.setBackground(new java.awt.Color(37, 171, 241));
        doctorPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        doctorPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doctorPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                doctorPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                doctorPanelMouseExited(evt);
            }
        });
        doctorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/doctor_white_filled.png"))); // NOI18N
        doctorPanel.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        doctor1.setForeground(new java.awt.Color(250, 249, 246));
        doctor1.setText("Doctors");
        doctorPanel.add(doctor1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 100, 50));

        jPanel1.add(doctorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 190, 50));

        patientPanel.setBackground(new java.awt.Color(37, 171, 241));
        patientPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        patientPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patientPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patientPanelMouseExited(evt);
            }
        });
        patientPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/patient_white_filled.png"))); // NOI18N
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientPanel.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        patient1.setForeground(new java.awt.Color(250, 249, 246));
        patient1.setText("Patients");
        patient1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        patientPanel.add(patient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 110, 50));

        jPanel1.add(patientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 180, 190, 50));

        dashboardPanel.setBackground(new java.awt.Color(37, 171, 241));
        dashboardPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashboardPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashboardPanelMouseExited(evt);
            }
        });
        dashboardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dashboard_filled.png"))); // NOI18N
        dashboardPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 40, 50));

        jLabel2.setForeground(new java.awt.Color(250, 249, 246));
        jLabel2.setText("Dashboard");
        dashboardPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 110, 30));

        jPanel1.add(dashboardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 190, 50));

        logoutPanel.setBackground(new java.awt.Color(100, 188, 234));
        logoutPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutPanelMouseExited(evt);
            }
        });
        logoutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log-out.png"))); // NOI18N
        logoutPanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 30, 50));

        logout.setBackground(new java.awt.Color(73, 138, 172));
        logout.setForeground(new java.awt.Color(73, 138, 172));
        logout.setText("Logout");
        logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutPanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 30));

        jPanel1.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 600, 170, 70));

        profilePanel.setBackground(new java.awt.Color(37, 171, 241));
        profilePanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profilePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profilePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profilePanelMouseExited(evt);
            }
        });
        profilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/profile-white.png"))); // NOI18N
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel16MouseEntered(evt);
            }
        });
        profilePanel.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        profile.setForeground(new java.awt.Color(250, 249, 246));
        profile.setText("Profile");
        profilePanel.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 100, 50));

        jPanel1.add(profilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 190, -1));

        accMngrPanel.setBackground(new java.awt.Color(37, 171, 241));
        accMngrPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        accMngrPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accMngrPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                accMngrPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                accMngrPanelMouseExited(evt);
            }
        });
        accMngrPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/accounts-white.png"))); // NOI18N
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel17MouseEntered(evt);
            }
        });
        accMngrPanel.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        accM.setForeground(new java.awt.Color(250, 249, 246));
        accM.setText("Accounts \nManager");
        accM.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        accMngrPanel.add(accM, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 160, 50));

        jPanel1.add(accMngrPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 190, -1));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        logsPanel.setBackground(new java.awt.Color(37, 171, 241));
        logsPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logsPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logsPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logsPanelMouseExited(evt);
            }
        });
        logsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logs_icon.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabel19MouseEntered(evt);
            }
        });
        logsPanel.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 50, 50));

        profile1.setForeground(new java.awt.Color(250, 249, 246));
        profile1.setText("Logs");
        logsPanel.add(profile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 0, 100, 50));

        jPanel1.add(logsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 190, -1));

        mainbg.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 700));

        getContentPane().add(mainbg, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        searchh.setText("");
        usersTable.setRowSorter(null);
    }//GEN-LAST:event_jLabel7MouseClicked

    private void searchhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchhActionPerformed

    }//GEN-LAST:event_searchhActionPerformed

    private void searchhKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchhKeyTyped
        searchTable();
    }//GEN-LAST:event_searchhKeyTyped

    private void doctorPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorPanelMouseEntered
        doctorPanel.setBackground(hoverColor);
    }//GEN-LAST:event_doctorPanelMouseEntered

    private void doctorPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorPanelMouseExited
        doctorPanel.setBackground(mainColor);
    }//GEN-LAST:event_doctorPanelMouseExited

    private void patientPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientPanelMouseClicked

        //        patientMenu pMenu = new patientMenu();
    }//GEN-LAST:event_patientPanelMouseClicked

    private void patientPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientPanelMouseEntered
        patientPanel.setBackground(hoverColor);
    }//GEN-LAST:event_patientPanelMouseEntered

    private void patientPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientPanelMouseExited
        patientPanel.setBackground(mainColor);
    }//GEN-LAST:event_patientPanelMouseExited

    private void dashboardPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardPanelMouseClicked

        adminDashB adb = new adminDashB();

        adb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_dashboardPanelMouseClicked

    private void dashboardPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardPanelMouseEntered

        dashboardPanel.setBackground(hoverColor);

    }//GEN-LAST:event_dashboardPanelMouseEntered

    private void dashboardPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardPanelMouseExited

        dashboardPanel.setBackground(mainColor);
    }//GEN-LAST:event_dashboardPanelMouseExited

    private void logoutPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseClicked

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to log out?", "Logout", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            session userSession = session.getInstance();

            userSession.setU_id(null);
            userSession.setFirstName(null);
            userSession.setLastName(null);
            userSession.setEmail(null);
            userSession.setUsername(null);
            userSession.setAcc_type(null);
            userSession.setAcc_status(null);

            logIn lg = new logIn();
            lg.setVisible(true);
            this.dispose();

        }
    }//GEN-LAST:event_logoutPanelMouseClicked

    private void logoutPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseEntered
        logoutPanel.setBackground(hoverlogoutColor);
    }//GEN-LAST:event_logoutPanelMouseEntered

    private void logoutPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseExited
        logoutPanel.setBackground(logoutColor);
    }//GEN-LAST:event_logoutPanelMouseExited

    private void jLabel16MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel16MouseEntered

    private void profilePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseClicked

        profileMenu pm = new profileMenu();
        pm.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_profilePanelMouseClicked

    private void profilePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseEntered

        profilePanel.setBackground(hoverColor);
    }//GEN-LAST:event_profilePanelMouseEntered

    private void profilePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseExited

        profilePanel.setBackground(mainColor);
    }//GEN-LAST:event_profilePanelMouseExited

    private void jLabel17MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel17MouseEntered

    private void accMngrPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMngrPanelMouseEntered

        accMngrPanel.setBackground(hoverColor);
    }//GEN-LAST:event_accMngrPanelMouseEntered

    private void accMngrPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMngrPanelMouseExited
        accMngrPanel.setBackground(mainColor);
    }//GEN-LAST:event_accMngrPanelMouseExited

    private void usersTableMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTableMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_usersTableMouseEntered

    private void usersTableMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersTableMouseMoved


    }//GEN-LAST:event_usersTableMouseMoved

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        displayData();
        getPatientCount();
    }//GEN-LAST:event_refreshActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        addPatient addp = new addPatient();

//        addp.setVisible(true);

    }//GEN-LAST:event_addActionPerformed

    private void deleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteMouseClicked


    }//GEN-LAST:event_deleteMouseClicked

    private void editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editActionPerformed

        int selectedRow = usersTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to edit.");
            return;
        }

        // Get row data
        String id = usersTable.getValueAt(selectedRow, 0).toString();
        String firstName = usersTable.getValueAt(selectedRow, 1).toString();
        String lastName = usersTable.getValueAt(selectedRow, 2).toString();
        String email = usersTable.getValueAt(selectedRow, 3).toString();
        String phone = usersTable.getValueAt(selectedRow, 4).toString();
//        String uname = usersTable.getValueAt(selectedRow, 5).toString();
//        String passW = usersTable.getValueAt(selectedRow, 6).toString();

        editPatient edp = new editPatient(id, firstName, lastName, email, phone);

        edp.setVisible(true);


    }//GEN-LAST:event_editActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed

        LocalDate actionDate = LocalDate.now();
        LocalTime atime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        String actionTime = atime.format(formatter);
        
        
        int selectedRow = usersTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a row to delete.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this record?", "Confirm Delete", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String id = usersTable.getValueAt(selectedRow, 0).toString();

            // Run SQL DELETE command here
            connectDB con = new connectDB();
            String query = "DELETE FROM user WHERE u_id = '" + id + "'";
            con.deleteData(query);

            // Refresh table
            displayData();
            
            session sess = session.getInstance();
            
            con.insertData("INSERT INTO logs (u_id, action, action_date, action_time)"
                        + "VALUES ('"+sess.getU_id()+"', 'Deleted an account', '"+actionDate+"', '"+actionTime+"')");
            

            JOptionPane.showMessageDialog(this, "User deleted successfully.");
        }

    }//GEN-LAST:event_deleteActionPerformed

    private void refreshMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseEntered


    }//GEN-LAST:event_refreshMouseEntered

    private void refreshMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshMouseExited


    }//GEN-LAST:event_refreshMouseExited

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked

        addPatient addp = new addPatient();
        addp.setVisible(true);

    }//GEN-LAST:event_addMouseClicked

    private void doctorPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doctorPanelMouseClicked

        doctorMenu dMenu = new doctorMenu();

        dMenu.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_doctorPanelMouseClicked

    private void accMngrPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accMngrPanelMouseClicked

        accountsMenu acctM = new accountsMenu();

        acctM.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_accMngrPanelMouseClicked

    private void jLabel19MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel19MouseEntered

    private void logsPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsPanelMouseClicked
       
        logs lo = new logs();
        lo.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_logsPanelMouseClicked

    private void logsPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsPanelMouseEntered
        
        logsPanel.setBackground(hoverColor);
        
        
    }//GEN-LAST:event_logsPanelMouseEntered

    private void logsPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsPanelMouseExited
        
        logsPanel.setBackground(mainColor);
        
    }//GEN-LAST:event_logsPanelMouseExited

    private void loadOpenSans() {
        try {
            InputStream fontStream = getClass().getResourceAsStream("/font/OpenSans-VariableFont_wdth,wght.ttf");
            if (fontStream != null) {
                Font openSans = Font.createFont(Font.TRUETYPE_FONT, fontStream);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(openSans);
                // Now you can use the font:
                jLabel5.setFont(openSans.deriveFont(Font.BOLD, 24));
                pAccOV.setFont(openSans.deriveFont(Font.BOLD, 18));
                jLabel2.setFont(openSans.deriveFont(Font.BOLD, 12));
                patient1.setFont(openSans.deriveFont(Font.BOLD, 12));
                patient.setFont(openSans.deriveFont(Font.BOLD, 14));
                doctor1.setFont(openSans.deriveFont(Font.BOLD, 12));
                accM.setFont(openSans.deriveFont(Font.BOLD, 12));
                profile.setFont(openSans.deriveFont(Font.BOLD, 12));
                profile1.setFont(openSans.deriveFont(Font.BOLD, 12));
                logout.setFont(openSans.deriveFont(Font.BOLD, 18));
                P.setFont(openSans.deriveFont(Font.BOLD, 18));
                refresh.setFont(openSans.deriveFont(Font.BOLD, 12));
                add.setFont(openSans.deriveFont(Font.BOLD, 12));
                edit.setFont(openSans.deriveFont(Font.BOLD, 12));
                delete.setFont(openSans.deriveFont(Font.BOLD, 12));

            } else {
                System.err.println("Font file not found!");
            }
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
        }
    }

    private void searchTable() {
        DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(model);
        usersTable.setRowSorter(rowSorter);

        searchh.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filter();
            }

            private void filter() {
                String searchText = searchh.getText().trim();
                if (searchText.isEmpty()) {
                    rowSorter.setRowFilter(null); // Show all rows if empty
                } else {
                    rowSorter.setRowFilter(new RowFilter<DefaultTableModel, Integer>() {
                        @Override
                        public boolean include(RowFilter.Entry<? extends DefaultTableModel, ? extends Integer> entry) {
                            String firstName = entry.getStringValue(1).toLowerCase(); // First Name (Column 1)
                            String lastName = entry.getStringValue(2).toLowerCase();  // Last Name (Column 2)

                            return firstName.contains(searchText.toLowerCase()) || lastName.contains(searchText.toLowerCase());
                        }
                    });
                }
            }
        });
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(patientMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patientMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patientMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patientMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patientMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel P;
    private javax.swing.JLabel accM;
    private javax.swing.JPanel accMngrPanel;
    private javax.swing.JButton add;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JPanel dboard;
    private javax.swing.JPanel dboardBG;
    private javax.swing.JButton delete;
    private javax.swing.JLabel doctor1;
    private javax.swing.JPanel doctorPanel;
    private javax.swing.JButton edit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel logout;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JPanel logsPanel;
    private javax.swing.JPanel mainbg;
    private javax.swing.JLabel pAccOV;
    private javax.swing.JLabel patient;
    private javax.swing.JLabel patient1;
    private javax.swing.JPanel patientPanel;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel profile1;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JButton refresh;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTextField searchh;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
