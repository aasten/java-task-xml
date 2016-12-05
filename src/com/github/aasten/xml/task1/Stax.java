package com.github.aasten.xml.task1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

public class Stax {

    public static class StaxParser {
        
        private interface Actor {
            void process(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException;
        }
        
        private Actor charactersWriter = new Actor() {
            public void process(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
//                if(reader.getLocalName().equals("name")) {
//                    writer.writeCharacters("Modified candy name");
//                } else {
                    writer.writeCharacters(reader.getText());
//                }
            }
        }; 
        private Actor ordinaryStart = new Actor() {
            public void process(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
                writer.writeStartElement(reader.getLocalName());
                for(int i = 0; i < reader.getAttributeCount(); ++i) {
                    if(reader.getLocalName().equals("water")
                            && reader.getAttributeLocalName(i).equals("value")) {
                        // изменяем количество воды в составе
                            writer.writeAttribute(reader.getAttributeLocalName(i), 
                                    "4200");
                    } else {
                        writer.writeAttribute(reader.getAttributeLocalName(i), 
                                              reader.getAttributeValue(i));
                    }
                }
            }
        };
        private Actor ordinaryEnd = new Actor() {
            public void process(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
                writer.writeEndElement();
            }
        };
        private Actor documentStart = new Actor() {
            public void process(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
                writer.writeStartDocument(reader.getCharacterEncodingScheme(), reader.getVersion());
            }
        };
        private Actor documentEnd = new Actor() {
            public void process(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
                writer.writeEndDocument();
            }
        };
        private Actor noAct = new Actor() {
            public void process(XMLStreamReader reader, XMLStreamWriter writer) throws XMLStreamException {
            }
        };
        
        XMLStreamWriter writer;
        
        public StaxParser(XMLStreamWriter writer) {
            this.writer = writer; 
        }
        
        
        private Actor actorByType(int type) {
            switch(type) {
            case XMLStreamConstants.START_DOCUMENT: return documentStart;
            case XMLStreamConstants.START_ELEMENT: return ordinaryStart;
            case XMLStreamConstants.CHARACTERS: return charactersWriter;
            case XMLStreamConstants.END_ELEMENT: return ordinaryEnd;
            case XMLStreamConstants.END_DOCUMENT: return documentEnd;
            default: return noAct;
            }
        }
        

        public void parse(InputStream input) {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            try {
                XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
                process(reader);
            } catch (XMLStreamException e) {
                e.printStackTrace();
            }
        }
        
        public void process(XMLStreamReader reader) throws XMLStreamException {
            documentStart.process(reader, writer);
            writer.writeCharacters(System.getProperty("line.separator"));
            while(reader.hasNext()) {
                actorByType(reader.next()).process(reader, writer);
            }
            documentEnd.process(reader, writer);
        }
        
        
    }
    
    public static void main(String[] args) {
        final String INFILENAME = "candy_marsh.xml";
        final String OUTFILENAME = "candy_staxed.xml";
        FileOutputStream fo;
        try {
            fo = new FileOutputStream(OUTFILENAME);
            StaxParser parser = new StaxParser(XMLOutputFactory.newInstance().createXMLStreamWriter(fo));
            parser.parse(new FileInputStream(INFILENAME));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("Cannot create output file " + OUTFILENAME);
        } catch (XMLStreamException e) {
            e.printStackTrace();
        } catch (FactoryConfigurationError e) {
            e.printStackTrace();
        }
        
    }

}
