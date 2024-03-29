/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.BtnDish;
import model.ManipulationWithDishInfo;
import view.DishInfo;

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

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("Fix"))
        {
            manipulationWithDishInfo.fixDish(PMenuController.onState, dishInfo);
        }else if(command.equals("btnChoose")){
            manipulationWithDishInfo.addImage();
        }
    }
    
}
