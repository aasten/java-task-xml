package com.github.aasten.xml.task1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.example.candy.Candy;

public class UnMarshall {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Candy.class);
            Unmarshaller u =  context.createUnmarshaller();
            FileReader fr = new FileReader("candy_marsh.xml");
            Candy c = (Candy) u.unmarshal(fr);
            reMarsh(c);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    private static void reMarsh(Candy c) {
        try {
            JAXBContext context = JAXBContext.newInstance(Candy.class);
            Marshaller m =  context.createMarshaller();
            m.marshal(c, new FileOutputStream("candy_remarsh.xml"));
            m.marshal(c, System.out);
        } catch (JAXBException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
