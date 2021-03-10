package JavaFX.controller;

import App.Track;
import Interfaces.IMediateControllers;
import com.sun.glass.ui.Application;

public class ApplicationController implements IMediateControllers {

    /*
   This is parent controller class for all controllers working in main window of the application
    */

    private static ApplicationController INSTANCE = new ApplicationController();

    // short names for controllers
    private MainWindowController mainC;
    private TracksListController tracksC;
    private AddTrackMenuController addC;
    private PlaylistsMenuController playlistC;
    private sideMenuExpandedController sideExC;     // stands for Expanded Controller
    private sideMenuHiddenController sideHidC;      // stands for Hidden Controller
    private ArchivizeFromNetController archC;

    @Override
    public void registerMainWindowController(MainWindowController controller) {
        this.mainC = controller;
    }

    @Override
    public void registerTracksListController(TracksListController controller) {
        this.tracksC = controller;
    }

    @Override
    public void registerAddNewTrackController(AddTrackMenuController controller) {
        this.addC = controller;
    }

    @Override
    public void registerPlaylistsController(PlaylistsMenuController controller) {
        this.playlistC = controller;
    }

    @Override
    public void registerSideMenuExpandedController(sideMenuExpandedController controller) {
        this.sideExC = controller;
    }

    @Override
    public void registerSideMenuHiddenController(sideMenuHiddenController controller) {
        this.sideHidC = controller;
    }

    @Override
    public void registerArchivizeFromNetController(ArchivizeFromNetController controller) {
        this.archC = controller;
    }

    @Override
    public void mainWindowSetToDefault() {
        this.mainC.resetScreen();    // calling method of reseting screen
    }

    @Override
    public void wrapSideMenu() {
        this.mainC.hideSideMenu();
    }

    @Override
    public void expandSideMenu() {
        this.mainC.expandSideMenu();
    }

    private ApplicationController() {}

    public static ApplicationController getInstance() {
        return INSTANCE;
    }

}
