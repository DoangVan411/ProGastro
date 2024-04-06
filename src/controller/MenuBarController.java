package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.InterfaceView;


public class MenuBarController implements MouseListener{
    
    InterfaceView interfaceView;
    
    public MenuBarController(InterfaceView interfaceView) {
        this.interfaceView = interfaceView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent().equals(interfaceView.menu)){
            interfaceView.pMenu.setVisible(true);
            interfaceView.pTables.setVisible(false);
        }else if(e.getComponent().equals(interfaceView.menuTables)){
            interfaceView.pMenu.setVisible(false);
            interfaceView.pTables.setVisible(true);
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
