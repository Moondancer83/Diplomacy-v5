package hu.kalee.diplomacy.logic.dto;

import hu.kalee.diplomacy.data.domain.CommandType;

/**
 * CommandViewDTO.
 *
 * @author mkalinovits
 * @since 2017. 12. 03.
 */
public class CommandViewDTO {
    private long id;
    private long unit;
    private CommandType type;
    private long base;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public long getUnit() {
        return unit;
    }

    public void setUnit(final long unit) {
        this.unit = unit;
    }

    public CommandType getType() {
        return type;
    }

    public void setType(final CommandType type) {
        this.type = type;
    }

    public long getBase() {
        return base;
    }

    public void setBase(final long base) {
        this.base = base;
    }

    public long getTarget() {
        return target;
    }

    public void setTarget(final long target) {
        this.target = target;
    }

    public String getNote() {
        return note;
    }

    public void setNote(final String note) {
        this.note = note;
    }

    private long target;
    private String note;
}
