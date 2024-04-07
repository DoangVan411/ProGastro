/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Dish;
import Model.Dishes;
import static controller.DishInfoController.tmpImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.BtnDish;
import view.DishInfo;
import view.InterfaceView;

/**
 *
 * @author dell
 */
public class ManipulationWithDishInfo {
    
    DishInfo dishInfo;
    InterfaceView interfaceView;
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    
    public ManipulationWithDishInfo(DishInfo dishInfo, InterfaceView interfaceView) {
        this.dishInfo = dishInfo;
        this.interfaceView = interfaceView;
    }

    
    public void editDish(BtnDish btnDish, DishInfo dishInfo, String image){
        try {
            fos = new FileOutputStream("src//file//Dish.DAT");
            oos = new ObjectOutputStream(fos);
            System.out.println(image);
            Dishes.dishes.remove(btnDish.dish);
            String name = this.dishInfo.tfName.getText();
            int price = Integer.valueOf(this.dishInfo.tfPrice.getText());
            String description = this.dishInfo.taDescription.getText();
            Dish tmpDish = new Dish(name, price, description, image);
            Dishes.dishes.add(tmpDish);
            oos.writeObject(Dishes.dishes);
            btnDish.setDish(tmpDish);
            dishInfo.lbImage.setIcon(new ImageIcon(image));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManipulationWithDishInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManipulationWithDishInfo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ManipulationWithDishInfo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void showInfo(BtnDish btnDish, DishInfo dishInfo){
        dishInfo.tfName.setText(btnDish.dish.getName());
        dishInfo.tfPrice.setText(btnDish.dish.getPrice() + "");
        dishInfo.taDescription.setText(btnDish.dish.getDiscription());
        dishInfo.lbImage.setIcon(new ImageIcon(btnDish.dish.getImage()));
    }
    
    
    public void removeDish(BtnDish btnDish, DishInfo dishInfo, Dish dish){
        try {
            fos = new FileOutputStream("src//file//Dish.DAT");
            oos = new ObjectOutputStream(fos);
            for(Dish tmpDish: Dishes.dishes){
                if(dish.getName().equals(tmpDish.getName()) &&
                        dish.getPrice()== tmpDish.getPrice() &&
                        dish.getDiscription().equals(tmpDish.getDiscription())){
                    Dishes.dishes.remove(tmpDish);
                    oos.writeObject(Dishes.dishes);
                    break;
                }
            }
            interfaceView.pOfScp.remove(btnDish);
            interfaceView.pOfScp.revalidate();
            interfaceView.pOfScp.repaint();
            dishInfo.dispose();
            for(Dish dishh: Dishes.dishes){
                System.out.println(dishh.getName());
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManipulationWithDishInfo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ManipulationWithDishInfo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                oos.close();
                fos.close();
            } catch (IOException ex) {
                Logger.getLogger(ManipulationWithMenu.class.getName()).log(Level.SEVERE, null, ex);
            }
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
