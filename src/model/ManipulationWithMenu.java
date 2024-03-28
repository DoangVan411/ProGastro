/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Model.Dish;
import Model.Dishes;
import controller.PMenuController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import view.DishInfo;
import view.InterfaceView;

/**
 *
 * @author dell
 */
public class ManipulationWithMenu {
    public InterfaceView interfaceView;
    public PMenuController pMenuController;
    
    public ManipulationWithMenu(InterfaceView interfaceView)
    {
        this.interfaceView = interfaceView;
        pMenuController = new PMenuController(interfaceView, this);
        
    }

    public void eraseForm(){
        this.interfaceView.tfNameInMenu.setText("");
        this.interfaceView.tfPriceOfMenu.setText("");
        this.interfaceView.taDescriptionInMenu.setText("");
    }
    
    public void addDish(Dish dish){
        Dishes.dishes.add(dish);
        BtnDish btnNewDish = new BtnDish(dish);
        btnNewDish.setText(dish.getName());
        btnNewDish.setActionCommand("btnNewDish");
        btnNewDish.addActionListener(pMenuController);
        interfaceView.pOfScp.add(btnNewDish);
        interfaceView.pOfScp.revalidate();
        System.out.println("Added");
    }
    
    public void showInfo(BtnDish btnDish, DishInfo dishInfo){
        dishInfo.tfName.setText(btnDish.getDish().getName());
        dishInfo.tfPrice.setText(btnDish.getDish().getPrice() + "");
        dishInfo.taDescription.setText(btnDish.getDish().getDiscription());
    }
    
    public void resizePOfScp(int width, int height)
    {
        interfaceView.pOfScp.setSize(width, height);
        interfaceView.scpDishes.setSize(width, height);
        interfaceView.pOfScp.revalidate();
        interfaceView.scpDishes.revalidate();
    }
    
    public void fixDish(){
        
    }
}
