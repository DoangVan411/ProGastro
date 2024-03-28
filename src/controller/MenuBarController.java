package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.ManipulationWithMenu;
import view.InterfaceView;


public class MenuBarController implements MouseListener{
    
    InterfaceView interfaceView;
    ManipulationWithMenu manipulationWithMenu;
    
    public MenuBarController(InterfaceView interfaceView) {
        this.interfaceView = interfaceView;
        manipulationWithMenu = new ManipulationWithMenu(interfaceView);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent().equals(interfaceView.menu)){
            interfaceView.pMenu.setVisible(true);
            interfaceView.pTables.setVisible(false);
            interfaceView.scpDishesOnTable.setVisible(true);
        }else if(e.getComponent().equals(interfaceView.menuTables)){
            interfaceView.pMenu.setVisible(false);
            interfaceView.pTables.setVisible(true);
            interfaceView.scpDishesOnTable.setVisible(false);
        }else if(e.getComponent().equals(interfaceView.lbArrow)){
//            System.out.println("You clicked Arrow");
            interfaceView.pManipulation.setVisible(true);
            manipulationWithMenu.resizePOfScp(642, 430);
        }else if(e.getComponent().equals(interfaceView.lbArrowDown)){
            interfaceView.pManipulation.setVisible(false);
            manipulationWithMenu.resizePOfScp(642, 485);
        }
    }

    
    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
