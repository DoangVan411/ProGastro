/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Dish;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.BtnDish;
import model.ManipulationWithMenu;
import view.DishInfo;
import view.InterfaceView;

/**
 *
 * @author dell
 */
public class PMenuController implements ActionListener{

    InterfaceView interfaceView;
    ManipulationWithMenu manipulationWithMenu;
    
    public PMenuController(InterfaceView interfaceView, ManipulationWithMenu manipulationWithMenu)
    {
        this.interfaceView = interfaceView;
        this.manipulationWithMenu = manipulationWithMenu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        JOptionPane.showMessageDialog(interfaceView,"You clicked" + " " + command);
        if(command.equals("Add")){
            manipulationWithMenu.eraseForm();
        }else if(command.equals("btnNewDish")){
            Object btnDish = e.getSource();
            DishInfo dishInfo = new DishInfo();
            manipulationWithMenu.showInfo((BtnDish) btnDish, dishInfo);
            dishInfo.setVisible(true);
        }
        else{
            try{
                String name = this.interfaceView.tfNameInMenu.getText();
                int price = Integer.valueOf(this.interfaceView.tfPriceOfMenu.getText());
                String description = this.interfaceView.taDescriptionInMenu.getText();
                Dish dish = new Dish(name, price, description);
                if(command.equals("Save")){
                    manipulationWithMenu.addDish(dish);
                    System.out.println("You clicked Save");
                }else if(command.equals("Fix")){
                    manipulationWithMenu.fixDish();
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
        
    
    
}
