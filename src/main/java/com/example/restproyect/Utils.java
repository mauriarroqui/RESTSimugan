package com.example.restproyect;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.restproyect.dto.Documento;

public class Utils {

	private final static Logger logger = LoggerFactory.getLogger(Utils.class);
	
	public static void LoguearEscenarios(ArrayList<Documento> escenarios) {
		
		for(int i = 0; i < escenarios.size(); i++) {
			try {
				StringWriter sw = new StringWriter();
				TransformerFactory tf = TransformerFactory.newInstance();
				Transformer transformer = tf.newTransformer();
				transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "no");
				transformer.setOutputProperty(OutputKeys.METHOD, "xml");
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
				
				transformer.transform(new DOMSource(escenarios.get(i).getDocumento()), new StreamResult(sw));		
				logger.debug("Doc Indice = ["+i+"]"+sw.toString());
			}catch (Exception e) {
				System.out.println("Exception = "+e.getMessage());
			}			
		}
	}
}
