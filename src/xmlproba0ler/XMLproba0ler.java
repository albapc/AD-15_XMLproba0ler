
package xmlproba0ler;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

/**
 *
 * @author Alba
 */
public class XMLproba0ler {

    public static void main(String[] args) throws FileNotFoundException, XMLStreamException {
        XMLInputFactory xif = XMLInputFactory.newInstance();
        XMLStreamReader xsr = xif.createXMLStreamReader(new FileInputStream("autores.xml"));
        
        while(xsr.hasNext()) {
            xsr.next();
            
            switch (xsr.getEventType()) {
                case XMLStreamConstants.START_ELEMENT:
                    
                    String nomA = xsr.getAttributeLocalName(0); //devuelve el nombre del atributo
                    String nomAv = xsr.getAttributeValue(0); //devuelve el nombre del valor
                    
                    
                    //CON TAGS
//                    if(nomA != null && nomAv != null) {
//                        System.out.println("<" + xsr.getLocalName() + " " + nomA + "=" + '"' + nomAv + '"' + ">"); //nombres de las etiquetas de apertura, con el atributo
//                    } else {
//                        System.out.println("<" + xsr.getLocalName() + ">"); //nombres de las etiquetas de apertura, sin atributo
//                    }   break;
                    
                    
                    if(nomA != null && nomAv != null) {
                        System.out.println(xsr.getLocalName() + " " + nomAv);
                    } break;
                    
                case XMLStreamConstants.CHARACTERS: //contenido de las etiquetas
                    System.out.println(xsr.getText());
                    break;
                   
                  //CON TAGS  
//                case XMLStreamConstants.END_ELEMENT: //etiquetas de cierre
//                    System.out.println("</" + xsr.getLocalName() + ">");
//                    break;
                    
                default:
                    break;
            }
        }
        
        xsr.close();
        
    }
    
}
