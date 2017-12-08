package hu.kalee.diplomacy.logic.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import hu.kalee.diplomacy.logic.dto.NationViewDTO;
import hu.kalee.diplomacy.data.domain.Nation;
import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.data.domain.Unit;

/**
 * NationEntityToViewDTOConverter.
 *
 * @author mkalinovits
 * @since 2017. 12. 03.
 */
@Component
public class NationEntityToViewDTOConverter implements Converter<Nation, NationViewDTO> {
    @Autowired
    private RegionEntityToViewDTOConverter regionConverter;
    @Autowired
    private UnitEntityToViewDTOConverter unitConverter;

    @Override
    public NationViewDTO convert(final Nation s) {
        NationViewDTO r = null;
        if (s != null) {
            r = new NationViewDTO();
            r.setId(s.getId());
            r.setName(s.getName());
            r.setRegions(getRegionIds(s));
            r.setUnits(getUnitIds(s));
        }
        return r;
    }

    private List<Long> getRegionIds(final Nation s) {
        final List<Long> ids = new ArrayList<>();
        for (Region reg : s.getRegions()) {
            ids.add(reg.getId());
        }
        return ids;
    }

    private List<Long> getUnitIds(final Nation s) {
        final List<Long> ids = new ArrayList<>();
        for (Unit unit : s.getUnits()) {
            ids.add(unit.getId());
        }
        return ids;
    }
}
