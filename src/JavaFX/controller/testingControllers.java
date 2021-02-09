package JavaFX.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class testingControllers {
    @FXML
    private Button button;

    public testingControllers() {
        // For now nothing here
    }

    @FXML
    void initialize() {

        /* implementing 3 options to write event handlers to use in right context */

        // 1 one is big but also quite clear and I can manipulate more with it
        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                // content of the handler
            }
        };
        button.addEventHandler(ActionEvent.ACTION, handler);

        // 2 option is by lambda
        EventHandler<ActionEvent> lambdaHandler = e -> {
            // content of the handler
        };
        button.addEventHandler(ActionEvent.ACTION, lambdaHandler);

        // 3rd option is to use direct method on button
        button.setOnAction( e -> {
            // handler content
        });

        /* starting login widnow at the beggining of the lifetime of an application
         * it will finally have to be a callable window
         * by logout or as said
         * */

    }

    /*
    @FXML   // WARNING -- remember about importing right package!
    public void mouseEntered(MouseEvent e) {
        // Args let us take more data from running app
        System.out.println("najechano na przycisk -- " + e.toString() );
    }
     */


}
