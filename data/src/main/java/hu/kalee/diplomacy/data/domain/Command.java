package hu.kalee.diplomacy.data.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Command.
 *
 * @author mkalinovits
 * @since 12/22/16
 */
@Entity
public class Command {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    @JoinColumn(name = "unit_id")
    private Unit unit;
    private CommandType type;
    @OneToOne
    @JoinColumn(name = "base_id")
    private Region base;
    @ManyToOne
    @JoinColumn(name = "target_id")
    private Region target;
    private String note;

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(final Unit unit) {
        this.unit = unit;
    }

    public CommandType getType() {
        return type;
    }

    public void setType(final CommandType type) {
        this.type = type;
    }

    public Region getBase() {
        return base;
    }

    public void setBase(final Region base) {
        this.base = base;
    }

    public Region getTarget() {
        return target;
    }

    public void setTarget(final Region target) {
        this.target = target;
    }

    public String getNote() {
        return note;
    }

    public void setNote(final String note) {
        this.note = note;
    }
}
