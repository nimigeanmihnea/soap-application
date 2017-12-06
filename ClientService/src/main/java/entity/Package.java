package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
public class Package {
    private long id;
    private User sender;
    private User destination;
    private String description;
    private String name;
    private boolean tracking = false;
    private City senderCity;
    private City destinationCity;
    private List<City> route = null;

    public Package() {}

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "tracking", nullable = false)
    public boolean isTracking() {
        return tracking;
    }

    public void setTracking(boolean tracking) {
        this.tracking = tracking;
    }

    @OneToOne
    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    @OneToOne
    public User getDestination() {
        return destination;
    }

    public void setDestination(User destination) {
        this.destination = destination;
    }

    @OneToOne
    public City getSenderCity() {
        return senderCity;
    }

    public void setSenderCity(City senderCity) {
        this.senderCity = senderCity;
    }

    @OneToOne
    public City getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(City destinationCity) {
        this.destinationCity = destinationCity;
    }

    @OneToMany
    public List<City> getRoute() {
        return route;
    }

    public void setRoute(List<City> route) {
        this.route = route;
    }

    @Override
    public String toString() {
        return "Package{" +
                "sender=" + sender +
                ", destination=" + destination +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", tracking=" + tracking +
                ", senderCity=" + senderCity +
                ", destinationCity=" + destinationCity +
                '}';
    }
}
