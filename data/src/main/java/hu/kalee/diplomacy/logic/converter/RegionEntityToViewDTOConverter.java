package hu.kalee.diplomacy.logic.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import hu.kalee.diplomacy.logic.dto.RegionViewDTO;
import hu.kalee.diplomacy.data.domain.Region;

/**
 * RegionEntityToViewDTOConverter.
 *
 * @author mkalinovits
 * @since 2017. 12. 03.
 */
@Component
public class RegionEntityToViewDTOConverter implements Converter<Region, RegionViewDTO> {
    @Override
    public RegionViewDTO convert(final Region s) {
        RegionViewDTO r = null;
        if (s != null) {
            r = new RegionViewDTO();
            r.setId(s.getId());
            r.setName(s.getName());
            r.setType(s.getType());
            r.setSupplyCenter(s.isSupplyCenter());
            r.setAdjacent(getAdjacentIds(s));
            r.setOwner(s.getOwner() == null ? null : s.getOwner().getId());
            r.setCore(s.getCore() == null ? null : s.getCore().getId());
            r.setUnit(s.getUnit() == null ? null : s.getUnit().getId());
        }
        return r;
    }

    private List<Long> getAdjacentIds(final Region s) {
        final List<Long> adjacents = new ArrayList<>();
        for (Region reg : s.getAdjacent()) {
            adjacents.add(reg.getId());
        }
        return adjacents;
    }
}
