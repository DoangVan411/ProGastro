/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Model.Dish;
import Model.Dishes;
import controller.DishInfoController;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import view.DishInfo;

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

    public String getPath(String tmpPath){
        String path = tmpPath;
        return path;
    }
    
    public void fixDish(BtnDish btnDish, DishInfo dishInfo){
        Dishes.dishes.remove(btnDish.getDish());
        String name = this.dishInfo.tfName.getText();
        int price = Integer.valueOf(this.dishInfo.tfPrice.getText());
        String description = this.dishInfo.taDescription.getText();
//        String image = this.addImage();
        Dish tmpDish = new Dish(name, price, description);
        Dishes.dishes.add(tmpDish);
        btnDish.setDish(tmpDish);
//        btnDish.repaint();
//        btnDish.revalidate();
//        btnDish.setText(name);
    }
    
    public void showInfo(BtnDish btnDish, DishInfo dishInfo){
        dishInfo.tfName.setText(btnDish.getDish().getName());
        dishInfo.tfPrice.setText(btnDish.getDish().getPrice() + "");
        dishInfo.taDescription.setText(btnDish.getDish().getDiscription());
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
