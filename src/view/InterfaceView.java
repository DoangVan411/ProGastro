/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import Model.Dish;
import Model.Dishes;
import controller.DishInfoController;
import controller.PMenuController;
import controller.MenuBarController;
import controller.PTableController;
import java.awt.event.ActionListener;
import model.BtnTable;
import controller.ManipulationWithDishInfo;
import controller.ManipulationWithMenu;
import controller.ManipulationWithTable;
import java.awt.Color;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import model.BtnDish;

import model.Table;
import model.Tables;

/**
 *
 * @author dell
 */
public class InterfaceView extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceView
     */
    MenuBarController menuBarController = new MenuBarController(this);
    ManipulationWithMenu manipulationWithMenu = new ManipulationWithMenu(this);
    PMenuController pMenuController = new PMenuController(this, manipulationWithMenu);
    PTableController tableController = new PTableController();
    
    public InterfaceView() {
        ImageIcon icon = new ImageIcon("src//ProGastroImage//frameicon.png");
        this.setIconImage(icon.getImage());
        System.out.println("init RestaurantMangagerView");
        initComponents();
        addController();
        this.pTables.setVisible(false);
        setTable();
        setBtnDish();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pMenu = new javax.swing.JPanel();
        pManipulation = new javax.swing.JPanel();
        btnName = new javax.swing.JButton();
        tfNameInMenu = new javax.swing.JTextField();
        btnPriceOfMenu = new javax.swing.JButton();
        tfPriceOfMenu = new javax.swing.JTextField();
        scpOfDescription = new javax.swing.JScrollPane();
        taDescriptionInMenu = new javax.swing.JTextArea();
        btnDescriptionOfMenu = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSave = new javax.swing.JButton();
        btnChooseImg = new javax.swing.JButton();
        lbImageInMenu = new javax.swing.JLabel();
        scpDishes = new javax.swing.JScrollPane();
        pOfScp = new javax.swing.JPanel();
        pTables = new javax.swing.JPanel();
        menuBar = new javax.swing.JMenuBar();
        menu = new javax.swing.JMenu();
        menuTables = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ProGastro");
        setBackground(new java.awt.Color(0, 102, 102));
        setName("frame"); // NOI18N
        setResizable(false);

        pMenu.setBackground(new java.awt.Color(0, 204, 204));

        pManipulation.setBackground(new java.awt.Color(0, 153, 153));
        pManipulation.setPreferredSize(new java.awt.Dimension(650, 210));

        btnName.setBackground(new java.awt.Color(0, 102, 102));
        btnName.setFont(new java.awt.Font("SVN-Amsi Narw Light", 1, 14)); // NOI18N
        btnName.setForeground(new java.awt.Color(255, 255, 255));
        btnName.setText("Name of dish");
        btnName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNameActionPerformed(evt);
            }
        });

        tfNameInMenu.setBackground(new java.awt.Color(255, 255, 255));
        tfNameInMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNameInMenuActionPerformed(evt);
            }
        });

        btnPriceOfMenu.setBackground(new java.awt.Color(0, 102, 102));
        btnPriceOfMenu.setFont(new java.awt.Font("SVN-Amsi Narw Light", 1, 14)); // NOI18N
        btnPriceOfMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnPriceOfMenu.setText("Price of dish");
        btnPriceOfMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPriceOfMenuActionPerformed(evt);
            }
        });

        tfPriceOfMenu.setBackground(new java.awt.Color(255, 255, 255));

        taDescriptionInMenu.setBackground(new java.awt.Color(255, 255, 255));
        taDescriptionInMenu.setColumns(20);
        taDescriptionInMenu.setRows(5);
        scpOfDescription.setViewportView(taDescriptionInMenu);

        btnDescriptionOfMenu.setBackground(new java.awt.Color(0, 102, 102));
        btnDescriptionOfMenu.setFont(new java.awt.Font("SVN-Amsi Narw Light", 1, 14)); // NOI18N
        btnDescriptionOfMenu.setForeground(new java.awt.Color(255, 255, 255));
        btnDescriptionOfMenu.setText("Description");
        btnDescriptionOfMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDescriptionOfMenuActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 102, 102));
        btnAdd.setFont(new java.awt.Font("SVN-Amsi Narw Light", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add");

        btnSave.setBackground(new java.awt.Color(0, 102, 102));
        btnSave.setFont(new java.awt.Font("SVN-Amsi Narw Light", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");

        btnChooseImg.setForeground(new java.awt.Color(255, 255, 255));
        btnChooseImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ProGastroImage/icon ảnh-01.png"))); // NOI18N
        btnChooseImg.setActionCommand("btnChooseImg");

        lbImageInMenu.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        javax.swing.GroupLayout pManipulationLayout = new javax.swing.GroupLayout(pManipulation);
        pManipulation.setLayout(pManipulationLayout);
        pManipulationLayout.setHorizontalGroup(
            pManipulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pManipulationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pManipulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pManipulationLayout.createSequentialGroup()
                        .addComponent(btnChooseImg, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbImageInMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDescriptionOfMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pManipulationLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnPriceOfMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(190, 190, 190))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pManipulationLayout.createSequentialGroup()
                .addContainerGap(215, Short.MAX_VALUE)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(209, 209, 209))
            .addGroup(pManipulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pManipulationLayout.createSequentialGroup()
                    .addGap(7, 7, 7)
                    .addComponent(btnName, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(tfNameInMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pManipulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pManipulationLayout.createSequentialGroup()
                            .addGap(154, 154, 154)
                            .addComponent(tfPriceOfMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pManipulationLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(scpOfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        pManipulationLayout.setVerticalGroup(
            pManipulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pManipulationLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnPriceOfMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pManipulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbImageInMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDescriptionOfMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChooseImg))
                .addGap(29, 29, 29)
                .addGroup(pManipulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
            .addGroup(pManipulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pManipulationLayout.createSequentialGroup()
                    .addGap(10, 10, 10)
                    .addGroup(pManipulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfPriceOfMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(pManipulationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfNameInMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnName, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(scpOfDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(75, 75, 75)))
        );

        scpDishes.setBackground(new java.awt.Color(0, 204, 204));

        pOfScp.setBackground(new java.awt.Color(204, 255, 255));
        pOfScp.setPreferredSize(new java.awt.Dimension(645, 430));
        pOfScp.setLayout(new java.awt.GridLayout(5, 5));
        scpDishes.setViewportView(pOfScp);

        javax.swing.GroupLayout pMenuLayout = new javax.swing.GroupLayout(pMenu);
        pMenu.setLayout(pMenuLayout);
        pMenuLayout.setHorizontalGroup(
            pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
            .addGroup(pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(pManipulation, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pMenuLayout.createSequentialGroup()
                    .addGap(3, 3, 3)
                    .addComponent(scpDishes, javax.swing.GroupLayout.DEFAULT_SIZE, 644, Short.MAX_VALUE)
                    .addGap(3, 3, 3)))
        );
        pMenuLayout.setVerticalGroup(
            pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 485, Short.MAX_VALUE)
            .addGroup(pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pMenuLayout.createSequentialGroup()
                    .addGap(0, 275, Short.MAX_VALUE)
                    .addComponent(pManipulation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
            .addGroup(pMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pMenuLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(scpDishes, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(209, Short.MAX_VALUE)))
        );

        pTables.setLayout(new java.awt.GridLayout(6, 6));

        menuBar.setBackground(new java.awt.Color(204, 255, 255));
        menuBar.setForeground(new java.awt.Color(0, 0, 0));

        menu.setForeground(new java.awt.Color(0, 0, 0));
        menu.setText("Menu");
        menu.setFont(new java.awt.Font("SVN-Amsi Narw Light", 1, 12)); // NOI18N
        menuBar.add(menu);

        menuTables.setForeground(new java.awt.Color(0, 0, 0));
        menuTables.setText("Tables");
        menuTables.setFont(new java.awt.Font("SVN-Amsi Narw Light", 1, 12)); // NOI18N
        menuBar.add(menuTables);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(pTables, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pTables, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pTables.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDescriptionOfMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDescriptionOfMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDescriptionOfMenuActionPerformed

    private void btnPriceOfMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPriceOfMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPriceOfMenuActionPerformed

    private void tfNameInMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNameInMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNameInMenuActionPerformed

    private void btnNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNameActionPerformed

    
        
    
    /**
     * @param args the command line arguments
     */
    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnAdd;
    public javax.swing.JButton btnChooseImg;
    public javax.swing.JButton btnDescriptionOfMenu;
    public javax.swing.JButton btnName;
    public javax.swing.JButton btnPriceOfMenu;
    public javax.swing.JButton btnSave;
    public javax.swing.JLabel lbImageInMenu;
    public javax.swing.JMenu menu;
    public javax.swing.JMenuBar menuBar;
    public javax.swing.JMenu menuTables;
    public javax.swing.JPanel pManipulation;
    public javax.swing.JPanel pMenu;
    public javax.swing.JPanel pOfScp;
    public javax.swing.JPanel pTables;
    public javax.swing.JScrollPane scpDishes;
    public javax.swing.JScrollPane scpOfDescription;
    public javax.swing.JTextArea taDescriptionInMenu;
    public javax.swing.JTextField tfNameInMenu;
    public javax.swing.JTextField tfPriceOfMenu;
    // End of variables declaration//GEN-END:variables

    public void addController(){
        menu.addMouseListener(menuBarController);
        menuTables.addMouseListener(menuBarController);
        btnAdd.addActionListener(pMenuController);
        btnSave.addActionListener(pMenuController);
        btnChooseImg.addActionListener(pMenuController);
    }
    

    public void setTable2(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream("src//file//Table.DAT");
            oos = new ObjectOutputStream(fos);
            for(int i = 1; i <= 36; ++i){
                Table table = new Table();
                BtnTable btnTable = new BtnTable(table);
                btnTable.setActionCommand("btnTable");
                pTables.add(btnTable);
                Tables.tables.add(btnTable);
                btnTable.addActionListener(tableController);
            }
            oos.writeObject(Tables.tables);
        }catch(FileNotFoundException ex){
            Logger.getLogger(ManipulationWithTable.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManipulationWithTable.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                oos.close();
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ManipulationWithTable.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void setTable(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("src//file//Table.DAT");
            ois = new ObjectInputStream(fis);
            Tables.tables = (ArrayList<BtnTable>) ois.readObject();
            for(BtnTable btnTable: Tables.tables){
                this.pTables.add(btnTable);
                btnTable.addActionListener(tableController);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfaceView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InterfaceView.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                ois.close();
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(InterfaceView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void setBtnDish(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("src//file//Dish.DAT");
            ois = new ObjectInputStream(fis);
            Dishes.dishes = (ArrayList<Dish>) ois.readObject();
            for(Dish dish: Dishes.dishes){
                BtnDish btnDish = new BtnDish(dish);
                btnDish.addActionListener(pMenuController);
                this.pOfScp.add(btnDish);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(InterfaceView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(InterfaceView.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(InterfaceView.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                ois.close();
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(InterfaceView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
