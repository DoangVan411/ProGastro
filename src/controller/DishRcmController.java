/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.BtnDish;
import view.TableInfo;

/**
 *
 * @author dell
 */
public class DishRcmController implements ActionListener{
    ManipulationWithTable manipulationWithTable;
    public static BtnDish dishChosen;

    public DishRcmController(ManipulationWithTable manipulationWithTable){
        this.manipulationWithTable = manipulationWithTable;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        if(cmd.equals("Dish")){
            dishChosen = (BtnDish) e.getSource();
            manipulationWithTable.setInfo(dishChosen.dish.getName(), dishChosen.dish.getPrice() + "", dishChosen.dish.getDiscription());
        }
    }
    
}
