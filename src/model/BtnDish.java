/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Model.Dish;
import javax.swing.JButton;

/**
 *
 * @author dell
 */
public class BtnDish extends JButton{

    public Dish dish;
    
    public BtnDish(Dish dish) {
        this.dish = dish;
    }

    public Dish getDish() {
        return dish;
    }
    
    
    
}
