package com.github.aasten.xml.task1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.example.candy.Candy;
import com.example.candy.CandyType;
import com.example.candy.NutritionalValue;
import com.example.candy.ObjectFactory;
import com.example.ingredients.ChocolateCandyIngredients;
import com.example.ingredients.ChocolateKind;
import com.example.ingredients.ForcedMgMassValue;
import com.example.mass.MassUnit;
import com.example.mass.MassValue;

public class Marshall {
    
    private static class SampleIngredientsFactory extends com.example.ingredients.ObjectFactory {
        @Override
        public ChocolateCandyIngredients createChocolateCandyIngredients() {
            ChocolateCandyIngredients i = new ChocolateCandyIngredients();
            i.setChocolateKind(ChocolateKind.MILK);
            i.setWater(new ForcedMgMassValue());
            i.getWater().setUnit(MassUnit.MG);
            i.getWater().setValue(new BigDecimal("2200"));
            i.setSugar(new ForcedMgMassValue());
            i.getSugar().setUnit(MassUnit.MG);
            i.getSugar().setValue(new BigDecimal("3000"));
            i.setVanilin(new ForcedMgMassValue());
            i.getVanilin().setUnit(MassUnit.MG);
            i.getVanilin().setValue(new BigDecimal("30"));
            return i;
        }
    }
    
    private static class SampleCandyFactory extends ObjectFactory {
        
        private com.example.ingredients.ObjectFactory ingredientsFactory;
        
        public SampleCandyFactory(com.example.ingredients.ObjectFactory ingredientsFactory) {
            this.ingredientsFactory = ingredientsFactory;
        }
        
        @Override
        public NutritionalValue createNutritionalValue() {
            NutritionalValue n = new NutritionalValue();
            n.setCarbohydrates(new MassValue());
            n.getCarbohydrates().setUnit(MassUnit.GR);
            n.getCarbohydrates().setValue(new BigDecimal("59.4"));
            
            n.setFats(new MassValue());
            n.getFats().setUnit(MassUnit.GR);
            n.getFats().setValue(new BigDecimal("21.9"));
            
            n.setProteins(new MassValue());
            n.getProteins().setUnit(MassUnit.GR);
            n.getProteins().setValue(new BigDecimal("3.3"));
            return n;
        }

        @Override
        public Candy createCandy() {
            Candy candy = new Candy();
            candy.setCalorific(new BigDecimal("447"));
            candy.setIngredientsChocolate(ingredientsFactory.createChocolateCandyIngredients());
            candy.setName("Crasnyy babay XD");
            candy.setNutritionalValue(this.createNutritionalValue());
            candy.setType(CandyType.CHOCOLATE);
            candy.setVendor("Minsk is the capital of Republic of Belarus");
            return candy;
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        System.setProperty("javax.xml.bind.JAXBContext", 
//                "com.sun.xml.internal.bind.v2.ContextFactory");
        ObjectFactory factory = new SampleCandyFactory(new SampleIngredientsFactory()); 
        try {
            JAXBContext context = JAXBContext.newInstance(Candy.class);
            Marshaller m =  context.createMarshaller();
            Candy c = factory.createCandy();
            m.marshal(c, new FileOutputStream("candy_marsh.xml"));
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
