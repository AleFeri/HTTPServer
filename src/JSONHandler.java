import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class JSONHandler {
    private static List<PuntoVendita> puntiVenditaArray;

    //Getter
    public static List<PuntoVendita> getPuntiVenditaArray() {
        return puntiVenditaArray;
    }

    //costruttore
    public JSONHandler() {
        puntiVenditaArray = getPVList();
        puntiVenditaArray.forEach(System.out::println);
    }

    //metodi
    private static List<PuntoVendita> getPVList() {
        try {
            // create object mapper instance
            ObjectMapper mapper = new ObjectMapper();

            // convert JSON string to Book object
            return Arrays.asList(mapper.readValue(Paths.get("puntiVendita.json").toFile(), PuntoVendita[].class));

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        JSONHandler jsonHandler = new JSONHandler();
    }
}
