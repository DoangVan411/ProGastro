/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Dish;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;
import javax.swing.table.DefaultTableModel;
import model.BtnTable;
import model.ManipulationWithTable;
import view.InterfaceView;
import view.TableInfo;

/**
 *
 * @author dell
 */
public class PTableController implements ActionListener{
    InterfaceView interfaceView;
    public static BtnTable btnOnStage;
    ManipulationWithTable manipulationWithTable;
    
    public PTableController(InterfaceView interfaceView){
        this.interfaceView = interfaceView;
        manipulationWithTable = new ManipulationWithTable();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if(command.equals("btnTable")){
            btnOnStage = (BtnTable) e.getSource();
            TableInfo tableInfo = new TableInfo();
            manipulationWithTable.showTableInfo(tableInfo);
            tableInfo.setVisible(true);
        }
    }
    
    
}
