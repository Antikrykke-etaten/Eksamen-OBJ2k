package droodle;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import droodle.file.Sketch;

public class FileTreeParser {

	Configuration conf = new Configuration();
	DocumentBuilderFactory dbf;
	DocumentBuilder db;
	Document xmlFile;
	List<Sketch> sketchNames = new ArrayList<>();

	public FileTreeParser() throws ParserConfigurationException, SAXException, IOException {
		dbf = DocumentBuilderFactory.newInstance();
		db = dbf.newDocumentBuilder();
		xmlFile = db.parse(ClassLoader.getSystemResourceAsStream(conf.assetsFolder + conf.fileTreeXML));
	}

	public String[] getSketchNames() {
		String[] sketchNames = null;
		NodeList nodeList = xmlFile.getDocumentElement().getChildNodes();
		
		if (nodeList.getLength() > 1) {
			return null;
		}
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node node = nodeList.item(i);
		}
		
		return sketchNames;
	}
}
