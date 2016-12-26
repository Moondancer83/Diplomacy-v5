package hu.kalee.diplomacy.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 * Region.
 *
 * @author mkalinovits
 * @since 12/22/16
 */
@Entity
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    @Column(columnDefinition = "boolean default false")
    private boolean isSupplyCenter;
    private RegionType type;
    @ManyToMany
    private List<Region> adjacent;
    @ManyToOne
    @JoinColumn(name = "core_id")
    private Nation core;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Nation owner;
    @OneToOne(mappedBy = "location", cascade = CascadeType.ALL)
    private Unit unit;

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

    public boolean isSupplyCenter() {
        return isSupplyCenter;
    }

    public void setSupplyCenter(final boolean supplyCenter) {
        isSupplyCenter = supplyCenter;
    }

    public RegionType getType() {
        return type;
    }

    public void setType(final RegionType type) {
        this.type = type;
    }

    public Nation getCore() {
        return core;
    }

    public void setCore(final Nation core) {
        this.core = core;
    }

    public Nation getOwner() {
        return owner;
    }

    public void setOwner(final Nation owner) {
        this.owner = owner;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(final Unit unit) {
        this.unit = unit;
    }
}
