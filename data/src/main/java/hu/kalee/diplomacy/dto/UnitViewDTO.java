package hu.kalee.diplomacy.dto;

import hu.kalee.diplomacy.domain.UnitType;

/**
 * UnitViewDTO.
 *
 * @author mkalinovits
 * @since 2017. 12. 03.
 */
public class UnitViewDTO {
    private long id;
    private String name;
    private UnitType type;
    private long owner;

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

    public long getOwner() {
        return owner;
    }

    public void setOwner(final long owner) {
        this.owner = owner;
    }

    public long getLocation() {
        return location;
    }

    public void setLocation(final long location) {
        this.location = location;
    }

    public CommandViewDTO getCommand() {
        return command;
    }

    public void setCommand(final CommandViewDTO command) {
        this.command = command;
    }

    private long location;
    private CommandViewDTO command;
}
