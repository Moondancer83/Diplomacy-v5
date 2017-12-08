package hu.kalee.diplomacy.data.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Nation.
 *
 * @author mkalinovits
 * @since 12/22/16
 */
@Entity
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    @OneToMany(mappedBy = "core")
    private List<Region> cores;

    @OneToMany(mappedBy = "owner")
    private List<Region> regions;

    @OneToMany(mappedBy = "owner")
    private List<Unit> units;

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

    public List<Region> getCores() {
        return cores;
    }

    public void setCores(final List<Region> cores) {
        this.cores = cores;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(final List<Region> regions) {
        this.regions = regions;
    }

    public List<Unit> getUnits() {
        return units;
    }

    public void setUnits(final List<Unit> units) {
        this.units = units;
    }
}
