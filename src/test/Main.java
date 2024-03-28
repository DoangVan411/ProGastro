package test;


import controller.MenuBarController;
import view.InterfaceView;

public class Main{
    
    
    public static void main(String[] args) {
        InterfaceView interfaceView = new InterfaceView();
//        MenuBarController interfaceController = new MenuBarController(interfaceView);
        interfaceView.setVisible(true);
    }
}