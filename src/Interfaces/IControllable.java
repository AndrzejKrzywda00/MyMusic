package Interfaces;

import JavaFX.controller.ScreensContainer;

public interface IControllable {

    // this interface forces to have method for setting screen parent
    // this is strictly to just have a controller to synchronize all controllers

    /***
     *
     * @param screensController This is the controller of all controllers
     * Function has to set parent of controlling instance to super controller
     */
    public void setScreenParent(ScreensContainer superController);

}
