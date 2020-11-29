import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;

public class XMLHandler {

    private JAXBContext context;

    public XMLHandler() throws JAXBException {
        this.context = JAXBContext.newInstance(PuntoVendita.class);
    }

    //Metodi
    public void JSONToXML(List<PuntoVendita> puntiVenditaList) {
        File xmlFile = new File("puntiVendita.xml");

        try {
            Marshaller marshaller = context.createMarshaller();

            for(PuntoVendita pv: puntiVenditaList) {
                marshaller.marshal(pv, xmlFile);
            }
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new JSONHandler();
        List<PuntoVendita> pv = JSONHandler.getPuntiVenditaArray();

        try {
            XMLHandler xmlHandler = new XMLHandler();
            xmlHandler.JSONToXML(pv);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
