import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.geocoder.Results;
import com.google.geocoder.ResultsItem;
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

        ObjectMapper mapper = new ObjectMapper();
        Results results = mapper.readValue(response, Results.class);
        ResultsItem resultsItem = results.getResults().get(0);
        assertEquals(37.4216548, resultsItem.getGeometry().getLocation().getLat(),0);

        //assertEquals("???", response);
    }
}