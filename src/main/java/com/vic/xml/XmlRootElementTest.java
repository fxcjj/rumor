package com.vic.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Victor
*/
public class XmlRootElementTest {

		public static void main(String[] args) throws Exception {
			JAXBContext jaxbContext = JAXBContext.newInstance(Boy.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			
			Boy boy = new Boy("victor", 1);
			marshaller.marshal(boy, System.out);
			System.out.println();
			
			/*String xml = "<ns2:b xmlns:ns2=\"http://test\"><age>10</age><name>CY</name></ns2:b>";
			Boy boy2 = (Boy)unmarshaller.unmarshal(new StringReader(xml));
			System.out.println(boy2.name);
			System.out.println(boy2.age);*/
			
		}
		
}

@XmlRootElement(name = "b", namespace = "http://test")
@XmlAccessorType(XmlAccessType.PROPERTY)
class Boy {
	
	public Boy() {
	}
	
	public Boy(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
    String name = "CY";

    @XmlElement
    int age = 10;
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}