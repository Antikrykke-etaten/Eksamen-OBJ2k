package droodle;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import droodle.file.Sketch;

public class FileTreeParser {

	private Configuration conf = new Configuration();
	private DocumentBuilderFactory dbf;
	private DocumentBuilder db;
	private Document xmlFile;
	private List<Sketch> sketchNames = new ArrayList<>();

	public FileTreeParser() throws ParserConfigurationException, SAXException, IOException, Exception {
		dbf = DocumentBuilderFactory.newInstance();
		db = dbf.newDocumentBuilder();
		xmlFile = db.parse(new FileInputStream(conf.fileTreeXML));
		
		initSketchNames();
	}

	private void initSketchNames() throws Exception {
		NodeList nodeList = xmlFile.getDocumentElement().getChildNodes();
		
//		if (nodeList.getLength() > 1) {
//			throw new Exception();
//		}
		
		for (int i = 0; i < nodeList.getLength(); i++) {
			Sketch sketch = new Sketch();
			Node node = nodeList.item(i);
			if (node instanceof Element) {
				sketch.setSketchName(node.getAttributes().getNamedItem("name").getNodeValue());
				sketchNames.add(sketch);
			}
		}
	}
	
	public List<Sketch> getSketchNames() {
		return this.sketchNames;
	}
}
