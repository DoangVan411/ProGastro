/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Model.Dish;
import Model.Dishes;
import controller.PMenuController;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.WindowConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
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
        this.interfaceView.lbImageInMenu.setIcon(null);
    }
    
    public void addDish(Dish dish){
        Dishes.dishes.add(dish);
        System.out.println(dish.getImage());
        BtnDish btnNewDish = new BtnDish(dish);
        btnNewDish.addActionListener(pMenuController);
        interfaceView.pOfScp.add(btnNewDish);
        interfaceView.pOfScp.revalidate();
        System.out.println("Added");
    }
    
    
    
    public void resizePOfScp(int width, int height)
    {
        interfaceView.pOfScp.setSize(width, height);
        interfaceView.scpDishes.setSize(width, height);
        interfaceView.pOfScp.revalidate();
        interfaceView.scpDishes.revalidate();
    }
    
    
    public static boolean ifExist(Dish dish)
    {
        for(Dish tmpDish: Dishes.dishes){
            if(dish.getName().equals(tmpDish.getName()) && 
                    dish.getPrice()== tmpDish.getPrice() && 
                    dish.getDiscription().equals(tmpDish.getDiscription()))
            {
                return true;
            }
        }
        return false;
    }
    
    public String addImage(){
        System.out.println("Add Image");
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("hinh anh", "jpg", "png");
        fileChooser.setFileFilter(imageFilter);
        fileChooser.setMultiSelectionEnabled(false);
        
        int choice = fileChooser.showDialog(fileChooser, "Choose");
        if(choice == JFileChooser.APPROVE_OPTION){
           File f = fileChooser.getSelectedFile();
           interfaceView.lbImageInMenu.setIcon(new ImageIcon(f.getAbsolutePath()));
           return f.getAbsolutePath();
        }
        return "";
    }
}
