
package application.stub;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for package complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="package">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="destination" type="{http://service/}user" minOccurs="0"/>
 *         &lt;element name="destinationCity" type="{http://service/}city" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="route" type="{http://service/}city" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="sender" type="{http://service/}user" minOccurs="0"/>
 *         &lt;element name="senderCity" type="{http://service/}city" minOccurs="0"/>
 *         &lt;element name="tracking" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "package", propOrder = {
    "description",
    "destination",
    "destinationCity",
    "id",
    "name",
    "route",
    "sender",
    "senderCity",
    "tracking"
})
public class Package {

    protected String description;
    protected User destination;
    protected City destinationCity;
    protected long id;
    protected String name;
    @XmlElement(nillable = true)
    protected List<City> route;
    protected User sender;
    protected City senderCity;
    protected boolean tracking;

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the destination property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getDestination() {
        return destination;
    }

    /**
     * Sets the value of the destination property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setDestination(User value) {
        this.destination = value;
    }

    /**
     * Gets the value of the destinationCity property.
     * 
     * @return
     *     possible object is
     *     {@link City }
     *     
     */
    public City getDestinationCity() {
        return destinationCity;
    }

    /**
     * Sets the value of the destinationCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link City }
     *     
     */
    public void setDestinationCity(City value) {
        this.destinationCity = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the route property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the route property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRoute().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link City }
     * 
     * 
     */
    public List<City> getRoute() {
        if (route == null) {
            route = new ArrayList<City>();
        }
        return this.route;
    }

    /**
     * Gets the value of the sender property.
     * 
     * @return
     *     possible object is
     *     {@link User }
     *     
     */
    public User getSender() {
        return sender;
    }

    /**
     * Sets the value of the sender property.
     * 
     * @param value
     *     allowed object is
     *     {@link User }
     *     
     */
    public void setSender(User value) {
        this.sender = value;
    }

    /**
     * Gets the value of the senderCity property.
     * 
     * @return
     *     possible object is
     *     {@link City }
     *     
     */
    public City getSenderCity() {
        return senderCity;
    }

    /**
     * Sets the value of the senderCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link City }
     *     
     */
    public void setSenderCity(City value) {
        this.senderCity = value;
    }

    /**
     * Gets the value of the tracking property.
     * 
     */
    public boolean isTracking() {
        return tracking;
    }

    /**
     * Sets the value of the tracking property.
     * 
     */
    public void setTracking(boolean value) {
        this.tracking = value;
    }

}
