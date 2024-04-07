/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import model.BtnDish;
import view.DishInfo;
import view.InterfaceView;

/**
 *
 * @author dell
 */
public class DishInfoController implements ActionListener{
    DishInfo dishInfo;
    ManipulationWithDishInfo manipulationWithDishInfo;
    
    public DishInfoController(DishInfo dishInfo, ManipulationWithDishInfo manipulationWithDishInfo) {
        this.dishInfo = dishInfo;
        this.manipulationWithDishInfo = manipulationWithDishInfo;
    }

    public static StringBuffer tmpImage = new StringBuffer();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Edit"))
        {
            manipulationWithDishInfo.editDish(PMenuController.onStage, dishInfo, tmpImage.toString());
            tmpImage.replace(0, tmpImage.length(), PMenuController.onStage.dish.getImage());
        }else if(command.equals("btnChoose")){
            tmpImage.replace(0, tmpImage.length(), manipulationWithDishInfo.addImage());
            dishInfo.lbImage.setIcon(new ImageIcon(tmpImage.toString()));
        }else if(command.equals("btnRemove")){
            int choice = JOptionPane.showConfirmDialog(null, "Remove?", "Confirm" ,JOptionPane.YES_NO_OPTION);
            if(choice == JOptionPane.YES_OPTION){
                manipulationWithDishInfo.removeDish(PMenuController.onStage, dishInfo, PMenuController.onStage.dish);
            }
        }
    }
    
}
