/*
 * Uses java's built in XML stream functionality. 
 * The parse method is closely base on the tutorial at: https://www.tutorialspoint.com/java_xml/java_stax_parse_document.htm
 * 
 * @Author grbishop
 */


import java.io.FileReader;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLParser {
	
	boolean inCd = false;
	Model m;
	
	public XMLParser(Model m){
		this.m = m;
	}
	
	public void parse(String filename){
		boolean isCatalog = true;
		try{
			XMLInputFactory factory = XMLInputFactory.newInstance();
			XMLEventReader eReader = factory.createXMLEventReader(
					new FileReader(filename));
			
			// Iterate through nodes
			// There are no attributes in the XML file given.
			while(eReader.hasNext()){
				XMLEvent event = eReader.nextEvent();
				// An event can be one of: start(<>), characters(>dfsdf<), 
				// or end element(</>)
				switch(event.getEventType()){
					case XMLStreamConstants.START_ELEMENT:
						StartElement start = event.asStartElement();
						String sName = start.getName().getLocalPart();
						if(sName.equals("catalog")){
							System.out.println("Parsed start of catalog");
							isCatalog = true;
						} else if(sName.equals("wishlist")){
							isCatalog = false;
							System.out.println("Parsed start of wishlist");
						} else if(sName.equals("cd")){
							System.out.println("Parsed start of cd");
							CDModel newCd = parseCD(eReader);
							System.out.println("Found CD: " + newCd.toString());
							if(isCatalog){
								m.add(newCd);
							} else {
								// This is a wishlist, not a catalog
								m.addToWishlist(newCd);
							}
						} else {
							System.out.println("Found start element:" + sName);
						}
						
						// Turn on respective booleans to show where we are.
						
						break;
					case XMLStreamConstants.CHARACTERS:
						Characters chars = event.asCharacters();
						if(chars.getData().trim().equals("")){
							// do nothing
						} else {
							System.out.println("Found chars:" + chars.getData());
						}
						break;
					case XMLStreamConstants.END_ELEMENT:
						EndElement end = event.asEndElement();
						System.out.println("End elt:" + end.getName().getLocalPart());
						break;
						
				}
				
			}
			
		} catch(Exception e){ // Haha exceptions, heh
			e.printStackTrace();
		}
	}
	
	public CDModel parseCD(XMLEventReader eReader){
		CDModel returnCD = new CDModel();
		// Parses the next element a few times until the end of the current CD
		// Assumes static structure of XML representation of CD
		try{
			eReader.nextEvent(); // Just whitespace
			eReader.nextEvent(); // Genre start tag
			
			returnCD.genre = eReader.nextEvent().asCharacters().getData();
			
			eReader.nextEvent(); // Close genre tag
			eReader.nextEvent(); // whitespace
			eReader.nextEvent(); // Open artist tag
			
			returnCD.artist = eReader.nextEvent().asCharacters().getData();
			
			eReader.nextEvent(); // Close artist tag
			eReader.nextEvent(); // whitespace
			eReader.nextEvent(); // Open title tag
			
			returnCD.name = eReader.nextEvent().asCharacters().getData();
			
			eReader.nextEvent(); // Close title tag
			eReader.nextEvent(); // whitespace
			eReader.nextEvent(); // End CD tag
		
		} catch(Exception e){
			e.printStackTrace();
		}
		return returnCD;
	}
}
