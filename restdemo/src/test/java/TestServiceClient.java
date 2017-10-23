import org.junit.Test;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import static org.junit.Assert.*;


public class TestServiceClient {

    @Test
    public void testGoogleApiJSON() throws Exception {
        Client client = ClientBuilder.newClient();
        WebTarget target =
                client.target("http://maps.googleapis.com/maps/api/geocode/json?" +
                        "address=1600+Amphitheatre+Parkway,+Mountain+View,+CA&sensor=false");
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        assertEquals("???", response);
    }
}