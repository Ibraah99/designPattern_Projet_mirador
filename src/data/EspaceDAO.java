package data;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import modele.Espace;

public class EspaceDAO {
	public String URL_NOUVELLESESPACE="https://www.space.com/feeds.xml";
	String xml = "";
	List<Espace> nouvelles = new ArrayList<Espace>();
	public List<Espace>  listerNouvelles(){
		
		//System.out.println("EspaceDAO.listerNouvelles");
		
		try {
			URL url = new URL(URL_NOUVELLESESPACE);
			InputStream flux = url.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter("\\A");
			xml = lecteur.next();
			//System.out.println(xml);
			lecteur.close();
		} catch (Exception e) {
			
			e.printStackTrace();
			return null;
		}
		DocumentBuilder parseur;
		try {
			parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			Document document = parseur.parse(new ByteArrayInputStream(xml.getBytes()));
			NodeList listeNoeudsNouvelles = document.getElementsByTagName("item");
			for(int position = 0; position < listeNoeudsNouvelles.getLength(); position++)
			{
				
				Node noeudNouvelle  = listeNoeudsNouvelles.item(position);
				Element xmlNouvelle = (Element)noeudNouvelle;
				String title = xmlNouvelle.getElementsByTagName("title").item(0).getTextContent();
				//System.out.println(title);
				String description = xmlNouvelle.getElementsByTagName("description").item(0).getTextContent();
				//System.out.println(description);
				String pubDate = xmlNouvelle.getElementsByTagName("pubDate").item(0).getTextContent();
				//System.out.println(pubDate);
				String link = xmlNouvelle.getElementsByTagName("link").item(0).getTextContent();
				//System.out.println(link);
				String author = xmlNouvelle.getElementsByTagName("dc:creator").item(0).getTextContent();
				//System.out.println(author);
				
				Espace nouvelle = new Espace(title);
				nouvelle.setDescription(description);
				nouvelle.setPubDate(pubDate);
				nouvelle.setLink(link);
				nouvelle.setAuthor(author);
				nouvelles.add(nouvelle);
						
			}

			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;	
		}



}
