package hu.kalee.diplomacy.dto;

import java.util.List;

/**
 * NationViewModel.
 *
 * @author mkalinovits
 * @since 2017. 12. 03.
 */
public class NationViewDTO {
    private long id;
    private String name;
    private List<Long> regions;
    private List<Long> units;

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

    public List<Long> getRegions() {
        return regions;
    }

    public void setRegions(final List<Long> regions) {
        this.regions = regions;
    }

    public List<Long> getUnits() {
        return units;
    }

    public void setUnits(final List<Long> units) {
        this.units = units;
    }
}
