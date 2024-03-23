package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.RestaurantMangagerView;

public class MenuController implements ActionListener{

    public static int menuEventMode;
    
    private RestaurantMangagerView restaurantMangagerView;

    public MenuController(RestaurantMangagerView restaurantMangagerView){
        this.restaurantMangagerView = restaurantMangagerView;
    }
           
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Menu"));
        {
            
        }
        
    }
    
    
}
