/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Dish;
import Model.Dishes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.BtnDish;
import model.ManipulationWithDishInfo;
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
    DishInfo dishInfo = new DishInfo();
    ManipulationWithDishInfo manipulationWithDishInfo = new ManipulationWithDishInfo(dishInfo);
    
    public PMenuController(InterfaceView interfaceView, ManipulationWithMenu manipulationWithMenu)
    {
        this.interfaceView = interfaceView;
        this.manipulationWithMenu = manipulationWithMenu;
    }

    public static BtnDish onStage;
    public static BtnDish dishClicked;
    public static StringBuffer imgPath = new StringBuffer();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        
        if(command.equals("Add")){
            manipulationWithMenu.eraseForm();
        }else if(command.equals("btnNewDish")){
            Object btnDish = e.getSource();
            dishClicked = (BtnDish)btnDish;
            onStage = (BtnDish) btnDish;
            DishInfo dishInfo = new DishInfo();
            manipulationWithDishInfo.showInfo((BtnDish) btnDish, dishInfo);
            dishInfo.setVisible(true);
        }
        else if(command.equals("btnChooseImg")){
            int size = imgPath.length();
            imgPath.replace(0, size, manipulationWithMenu.addImage());
            System.out.println(imgPath);
        }
        else{
            try{
//                JOptionPane.showMessageDialog(interfaceView,"You clicked" + " " + command);
                String name = this.interfaceView.tfNameInMenu.getText();
                int price = Integer.valueOf(this.interfaceView.tfPriceOfMenu.getText());
                String description = this.interfaceView.taDescriptionInMenu.getText();
                Dish dish = new Dish(name, price, description, imgPath.toString());
                if(imgPath.equals("")) System.out.println("null");
                if(command.equals("Save")){
                    if(!manipulationWithMenu.ifExist(dish))
                    {
                        manipulationWithMenu.addDish(dish);
                    }
                    else JOptionPane.showMessageDialog(interfaceView,"Dish is already existed!");
                    System.out.println("You clicked Save");
                }
            }catch(Exception ex){
                ex.printStackTrace();
            }
        }
    }
    
}
