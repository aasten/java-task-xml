//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.05 at 02:28:36 AM MSK 
//


package com.example.ingredients;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import com.example.mass.MassValue;


/**
 * <p>Java class for ForcedMgMassValue complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ForcedMgMassValue">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.example.com/Mass}MassValue">
 *       &lt;attribute name="unit" use="required" type="{http://www.example.com/Mass}MassUnit" fixed="mg" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForcedMgMassValue")
public class ForcedMgMassValue
    extends MassValue
{


}