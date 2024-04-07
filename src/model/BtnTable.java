/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author dell
 */
public class BtnTable extends JButton{
    public Table table;
    public BtnTable(Table table){
        this.table = table;
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(new Color(0, 153, 153)));
        this.setPreferredSize(new Dimension(15, 80));
    }

    
}
