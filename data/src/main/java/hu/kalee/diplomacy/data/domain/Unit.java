package hu.kalee.diplomacy.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Unit.
 *
 * @author mkalinovits
 * @since 12/22/16
 */
@Entity
public class Unit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private UnitType type;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Nation owner;
    @OneToOne
    @JoinColumn(name = "location_id")
    private Region location;
    @OneToOne(mappedBy = "unit")
    private Command command;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public UnitType getType() {
        return type;
    }

    public void setType(final UnitType type) {
        this.type = type;
    }

    public Nation getOwner() {
        return owner;
    }

    public void setOwner(final Nation owner) {
        this.owner = owner;
    }

    public Region getLocation() {
        return location;
    }

    public void setLocation(final Region location) {
        this.location = location;
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(final Command command) {
        this.command = command;
    }
}
