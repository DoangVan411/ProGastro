package controller;

import view.RestaurantMangagerView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuController implements ActionListener {

    public static int menuEventMode;

    private RestaurantMangagerView restaurantMangagerView;

    public MenuController(RestaurantMangagerView restaurantMangagerView) {
        this.restaurantMangagerView = restaurantMangagerView;
        System.out.println("MenuController: init MenuController");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Menu")) ;
        {

        }

    }


}
