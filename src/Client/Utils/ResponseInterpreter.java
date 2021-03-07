package Client.Utils;

import Client.Utils.enums.Headers;
import Client.Utils.enums.Status;
import com.sun.javafx.scene.shape.MeshHelper;
import enums.MessageType;

import java.util.Map;

public class ResponseInterpreter {

    /*
    This class interpretes the data from response and is able to tell HTTPCommunitaor what to do with data
     */

    public ResponseInterpreter() {

    }

    /***
     * This method chcecks whether reponse contained all required headers and is in proper format
     * @param response is passed from server side
     * @return true if matches the rules, false if not
     */
    private boolean validateResponse(Response response) {

        if (response.getStatusMessage() == Status.OK_200.message || response.getStatusMessage() == Status.Created_201.message) {
            Map<String, String> headers = response.getHeaders();
            String serverName = "MyMusic Server";
            if (headers.getOrDefault(Headers.ContentType.name, null) != null
                    && headers.getOrDefault(Headers.ContentLength.name, null) != null
                    && headers.getOrDefault(Headers.Date.name, null) != null
                    && headers.getOrDefault(Headers.ServerName.name, serverName) != null
                    && headers.getOrDefault(Headers.ApplicationID.name, null) != null) {
                // this means all required headers are present and have their not-null payload
                if (response.getBody() != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public void interpreteResponse(Response response) {

        if (validateResponse(response)) {   // response fulfills the requirements and should be interpreted
            Map<String, String> headers = response.getHeaders();

            if(headers.get(Headers.ContentType.name) == MessageType.LoginMessage.name) {
                // this means we have logging information inside
            }

            if(headers.get(Headers.ContentType.name) == MessageType.NewPlaylistMessage.name) {
                // new playlist BACK information
                // we know it has been accepted
                // body has at least one line of data inside
                // depends how will i organize this
            }

            if(headers.get(Headers.ContentType.name) == MessageType.NewTrackMessage.name) {
                // new track is accepted
                // data from it goes back to be added to main list
            }

            if(headers.get(Headers.ContentType.name) == MessageType.TracksDataMessage.name) {
                // this one is big
                // here i get many lines of tracks
                // comes from server on normal download process
                // this should be maximum of [DataDownloadConfiguration.DISPLAY_CAPACITY] lines
            }
        }

    }
}
