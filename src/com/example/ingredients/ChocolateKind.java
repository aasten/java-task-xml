//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.12.05 at 02:28:36 AM MSK 
//


package com.example.ingredients;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ChocolateKind.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ChocolateKind">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="dark"/>
 *     &lt;enumeration value="white"/>
 *     &lt;enumeration value="milk"/>
 *     &lt;enumeration value="green"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ChocolateKind")
@XmlEnum
public enum ChocolateKind {

    @XmlEnumValue("dark")
    DARK("dark"),
    @XmlEnumValue("white")
    WHITE("white"),
    @XmlEnumValue("milk")
    MILK("milk"),
    @XmlEnumValue("green")
    GREEN("green");
    private final String value;

    ChocolateKind(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ChocolateKind fromValue(String v) {
        for (ChocolateKind c: ChocolateKind.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}