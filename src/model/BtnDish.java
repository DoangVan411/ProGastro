/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import Model.Dish;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author dell
 */
public class BtnDish extends JButton{

    public Dish dish;
    
    public BtnDish(Dish dish) {
        this.dish = dish;
        this.setText(dish.getName());
        this.setActionCommand("btnNewDish");
        this.setIcon(new ImageIcon(dish.getImage()));
        this.setBackground(Color.white);
        this.setFont(new Font("SVN-Amsi Narw Light", Font.BOLD, 14));
    }

    public void setDish(Dish dish) {
        this.setText(dish.getName());
        this.dish = dish;
        this.setIcon(new ImageIcon(dish.getImage()));
    }
}
