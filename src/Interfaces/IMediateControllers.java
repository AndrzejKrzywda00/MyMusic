package Interfaces;

import JavaFX.controller.*;

public interface IMediateControllers {

    /*
    This interface provides with functionality of communicating betweem controllers in application
     */

    void registerMainWindowController(MainWindowController controller);
    void registerTracksListController(TracksListController controller);
    void registerAddNewTrackController(AddTrackMenuController controller);
    void registerPlaylistsController(PlaylistsMenuController controller);
    void registerSideMenuExpandedController(sideMenuExpandedController controller);
    void registerSideMenuHiddenController(sideMenuHiddenController controller);
    void registerArchivizeFromNetController(ArchivizeFromNetController controller);

    void mainWindowSetToDefault();
    void wrapSideMenu();
    void expandSideMenu();
}
