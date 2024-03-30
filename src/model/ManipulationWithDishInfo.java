/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Model.Dish;
import Model.Dishes;
import controller.DishInfoController;
import java.awt.Dimension;
import java.io.File;
import javax.swing.Icon;
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
public class ManipulationWithDishInfo {
    
    DishInfo dishInfo;
    DishInfoController dishInfoController;

    public static boolean isFixed = false;
    
    public ManipulationWithDishInfo(DishInfo dishInfo) {
        this.dishInfo = dishInfo;
    }

    
    public void fixDish(BtnDish btnDish, DishInfo dishInfo, String image){
        System.out.println(image);
//        Dishes.dishes.remove(btnDish.dish);
        String name = this.dishInfo.tfName.getText();
        int price = Integer.valueOf(this.dishInfo.tfPrice.getText());
        String description = this.dishInfo.taDescription.getText();
        Dish tmpDish = new Dish(name, price, description, image);
        Dishes.dishes.add(tmpDish);
        btnDish.setDish(tmpDish);
        dishInfo.lbImage.setIcon(new ImageIcon(image));
    }
    
    public void showInfo(BtnDish btnDish, DishInfo dishInfo){
        dishInfo.tfName.setText(btnDish.dish.getName());
        dishInfo.tfPrice.setText(btnDish.dish.getPrice() + "");
        dishInfo.taDescription.setText(btnDish.dish.getDiscription());
        dishInfo.lbImage.setIcon(new ImageIcon(btnDish.dish.getImage()));
    }
    
    
    public void removeDish(BtnDish btnDish, DishInfo dishInfo, Dish dish){
        for(Dish tmpDish: Dishes.dishes){
            if(dish.getName().equals(tmpDish.getName()) && 
                    dish.getPrice()== tmpDish.getPrice() && 
                    dish.getDiscription().equals(tmpDish.getDiscription())){
                Dishes.dishes.remove(tmpDish);
                break;
            }
        }
        btnDish.setVisible(false);
        btnDish.setPreferredSize(new Dimension(645, 1));
        isFixed = true;
        dishInfo.dispose();
        for(Dish dishh: Dishes.dishes){
            System.out.println(dishh.getName());
        }
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
 
           return f.getAbsolutePath();
        }
        return "";
    }

    
}
