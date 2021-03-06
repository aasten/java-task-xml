//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.05 at 02:28:36 AM MSK 
//


package com.example.candy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.example.mass.MassValue;


/**
 * <p>Java class for NutritionalValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NutritionalValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;all>
 *         &lt;element name="proteins" type="{http://www.example.com/Mass}MassValue"/>
 *         &lt;element name="fats" type="{http://www.example.com/Mass}MassValue"/>
 *         &lt;element name="carbohydrates" type="{http://www.example.com/Mass}MassValue"/>
 *       &lt;/all>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NutritionalValue", propOrder = {

})
public class NutritionalValue {

    @XmlElement(required = true)
    protected MassValue proteins;
    @XmlElement(required = true)
    protected MassValue fats;
    @XmlElement(required = true)
    protected MassValue carbohydrates;

    /**
     * Gets the value of the proteins property.
     * 
     * @return
     *     possible object is
     *     {@link MassValue }
     *     
     */
    public MassValue getProteins() {
        return proteins;
    }

    /**
     * Sets the value of the proteins property.
     * 
     * @param value
     *     allowed object is
     *     {@link MassValue }
     *     
     */
    public void setProteins(MassValue value) {
        this.proteins = value;
    }

    /**
     * Gets the value of the fats property.
     * 
     * @return
     *     possible object is
     *     {@link MassValue }
     *     
     */
    public MassValue getFats() {
        return fats;
    }

    /**
     * Sets the value of the fats property.
     * 
     * @param value
     *     allowed object is
     *     {@link MassValue }
     *     
     */
    public void setFats(MassValue value) {
        this.fats = value;
    }

    /**
     * Gets the value of the carbohydrates property.
     * 
     * @return
     *     possible object is
     *     {@link MassValue }
     *     
     */
    public MassValue getCarbohydrates() {
        return carbohydrates;
    }

    /**
     * Sets the value of the carbohydrates property.
     * 
     * @param value
     *     allowed object is
     *     {@link MassValue }
     *     
     */
    public void setCarbohydrates(MassValue value) {
        this.carbohydrates = value;
    }

}
