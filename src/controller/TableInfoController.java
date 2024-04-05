
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import Model.Dish;
import Model.Dishes;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.WindowConstants;
import model.Table;
import view.TableInfo;

/**
 *
 * @author dell
 */
public class TableInfoController implements ActionListener{

    TableInfo tableInfo;
    ManipulationWithTable manipulationWithTable;
    public TableInfoController(TableInfo tableInfo) {
        this.tableInfo = tableInfo;
        manipulationWithTable = new ManipulationWithTable(tableInfo);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        String cmd = e.getActionCommand();
        if(cmd.equals("Add")){
            tableInfo.tfFindDish.setText("");
            tableInfo.tfNameShow.setText("");
            tableInfo.tfPriceShow.setText("");
            tableInfo.taDescription.setText("");
            tableInfo.tfQuantityShow.setText("");
            Table.setChoiceString("Add");
        }else if(cmd.equals("Save")){
            if(Table.getChoiceString().equals("Edit"))
            {
                manipulationWithTable.editDishInTable(manipulationWithTable.setRowSelected());
                Table.setChoiceString("Add");
            }
            else{
                manipulationWithTable.addDishToTable(PTableController.btnOnStage);
            }
        }else if(cmd.equals("Find by name")){
            manipulationWithTable.findDish(tableInfo.tfFindDish.getText());
        }else if(cmd.equals("Export")){
            PTableController.btnOnStage.setBackground(Color.WHITE);
            tableInfo.dispose();
        }else if(cmd.equals("Edit")){
            Table.setChoiceString("Edit");
            int row = manipulationWithTable.setRowSelected();
            tableInfo.tfFindDish.setText("");
            Dish tmpDish = manipulationWithTable.findDish((String) tableInfo.table.getValueAt(row, 1));
            manipulationWithTable.setInfo(tmpDish.getName(), tmpDish.getPrice() + "", tmpDish.getDiscription());
            tableInfo.tfQuantityShow.setText("");
            tableInfo.tfFindDish.setText((String) tableInfo.table.getValueAt(row, 1));
        }else if(cmd.equals("Remove")){
            manipulationWithTable.removeDish(manipulationWithTable.setRowSelected());
        }
    }
    
}
