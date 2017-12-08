package hu.kalee.diplomacy.logic.dto;

import java.util.List;

import hu.kalee.diplomacy.data.domain.RegionType;

/**
 * RegionViewDTO.
 *
 * @author mkalinovits
 * @since 2017. 12. 03.
 */
public class RegionViewDTO {
    private long id;
    private String name;
    private boolean isSupplyCenter;
    private RegionType type;
    private List<Long> adjacent;
    private Long core;
    private Long owner;
    private Long unit;

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

    public List<Long> getAdjacent() {
        return adjacent;
    }

    public void setAdjacent(final List<Long> adjacent) {
        this.adjacent = adjacent;
    }

    public Long getCore() {
        return core;
    }

    public void setCore(final Long core) {
        this.core = core;
    }

    public Long getOwner() {
        return owner;
    }

    public void setOwner(final Long owner) {
        this.owner = owner;
    }

    public Long getUnit() {
        return unit;
    }

    public void setUnit(final Long unit) {
        this.unit = unit;
    }

}
