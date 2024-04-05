/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Dish;
import Model.Dishes;
import controller.PMenuController;
import controller.PTableController;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.BtnTable;
import model.Tables;
import view.TableInfo;

/**
 *
 * @author dell
 */
public class ManipulationWithTable {
    TableInfo tableInfo;
    DefaultTableModel model;
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    
    public ManipulationWithTable(TableInfo tableInfo){
        this.tableInfo = tableInfo;
        
    }
    
    public ManipulationWithTable(){
        
    }
    
    public static boolean isAdded = true;
    public void addDishToTable(BtnTable btnTable){
        try{
            fos = new FileOutputStream("src//file//Table.DAT");
            oos = new ObjectOutputStream(fos);
            try{
                model = (DefaultTableModel) tableInfo.table.getModel();
                Dish tmpDish = this.findDish(tableInfo.tfFindDish.getText());
                if(btnTable.table.map.containsKey(tmpDish)){
                    JOptionPane.showMessageDialog(tableInfo,"Dish is already existed!");
                    isAdded = false;
                    return;
                }
                btnTable.table.map.put(tmpDish, Integer.valueOf(tableInfo.tfQuantityShow.getText()));
                model = (DefaultTableModel) tableInfo.table.getModel();
                model.addRow(new Object[]{btnTable.table.map.size(), tmpDish.getName(), tmpDish.getPrice(), PTableController.btnOnStage.table.map.get(tmpDish)});
                btnTable.table.setBill(btnTable.table.getBill() + tmpDish.getPrice() * PTableController.btnOnStage.table.map.get(tmpDish));
                tableInfo.lbSumShow.setText(btnTable.table.getBill() + "");
                btnTable.setBackground(new Color(0, 153, 153));
                oos.writeObject(Tables.tables);
            }catch(NumberFormatException e){
                e.getStackTrace();
            }
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
    
    public void showTableInfo(TableInfo tableInfo){
        model = (DefaultTableModel) tableInfo.table.getModel();
        Set<Dish> set = PTableController.btnOnStage.table.map.keySet();
        int cnt = 1;
        for(Dish dish: set)
        {
            System.out.println(dish.getName());
            model.addRow(new Object[]{cnt, dish.getName(), dish.getPrice(), PTableController.btnOnStage.table.map.get(dish)});
            ++cnt;
            tableInfo.lbSumShow.setText(PTableController.btnOnStage.table.getBill() + "");
        }

    }
    
    public void setInfo(String name, String price, String des){
        tableInfo.tfNameShow.setText(name);
        tableInfo.tfPriceShow.setText(price);
        tableInfo.taDescription.setText(des);
    }

    public int setRowSelected(){
        model = (DefaultTableModel) tableInfo.table.getModel();
        return tableInfo.table.getSelectedRow();
    }
    
    public void editDishInTable(int rowSelected){
        try{
            fos = new FileOutputStream("src//file//Table.DAT");
            oos = new ObjectOutputStream(fos);
            try{
                if(rowSelected != -1){
                    System.out.println(rowSelected);    
                    model = (DefaultTableModel) tableInfo.table.getModel();
                    String name = (String) model.getValueAt(rowSelected, 1);
                    int price = (int) model.getValueAt(rowSelected, 2);
                    int num = (int) model.getValueAt(rowSelected, 3);
                    PTableController.btnOnStage.table.setBill(PTableController.btnOnStage.table.getBill() - price * num);
                    int quantity = Integer.parseInt(tableInfo.tfQuantityShow.getText());
                    model.setValueAt(quantity, rowSelected, 3);
                    Set<Dish> set = PTableController.btnOnStage.table.map.keySet();
                    for(Dish dish: set)
                    {
                        if(dish.getName().equals(name)){
                            PTableController.btnOnStage.table.map.put(dish, quantity);
                            PTableController.btnOnStage.table.setBill(PTableController.btnOnStage.table.getBill() + dish.getPrice() * quantity);
                        }
                    }
                    tableInfo.lbSumShow.setText(PTableController.btnOnStage.table.getBill() + "");
                    oos.writeObject(Tables.tables);
                }
            }catch(NumberFormatException e){
                e.getStackTrace();
            }
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
    
    public void removeDish(int rowSelected){
        try{
            fos = new FileOutputStream("src//file//Table.DAT");
            oos = new ObjectOutputStream(fos);
            if(rowSelected != -1){
                model = (DefaultTableModel) tableInfo.table.getModel();
                String name = (String) model.getValueAt(rowSelected, 1);
                Set<Dish> set = PTableController.btnOnStage.table.map.keySet();
                for(Dish dish: set)
                {
                    if(dish.getName().equals(name)){
                        PTableController.btnOnStage.table.setBill(PTableController.btnOnStage.table.getBill() - dish.getPrice() * PTableController.btnOnStage.table.map.get(dish));
                        PTableController.btnOnStage.table.map.remove(dish);
                        tableInfo.lbSumShow.setText(PTableController.btnOnStage.table.getBill() + "");
                        break;
                    }
                }
                model.removeRow(rowSelected);
                model.fireTableDataChanged();
                if(PTableController.btnOnStage.table.map.isEmpty()){
                    PTableController.btnOnStage.setBackground(Color.WHITE);
                }
                oos.writeObject(Tables.tables);
            }
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
    
    public Dish findDish(String name){
        for(Dish dish: Dishes.dishes){
            System.out.println(dish.getName());
            if(dish.getName().contains(name) && 
                    !name.equals("") && 
                    !name.equals(" "))
            {
                setInfo(dish.getName(), dish.getPrice() + "", dish.getDiscription());
                return dish;
            }
        }
        return null;
    }
}
