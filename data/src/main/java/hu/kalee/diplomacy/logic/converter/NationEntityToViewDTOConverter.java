package hu.kalee.diplomacy.logic.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import hu.kalee.diplomacy.data.domain.Nation;
import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.data.domain.Unit;
import hu.kalee.diplomacy.logic.dto.NationViewDTO;

/**
 * NationEntityToViewDTOConverter.
 *
 * @author mkalinovits
 * @since 2017. 12. 03.
 */
@Component
public class NationEntityToViewDTOConverter implements Converter<Nation, NationViewDTO> {

    @Override
    public NationViewDTO convert(final Nation source) {
        NationViewDTO result = null;
        if (source != null) {
            result = new NationViewDTO();
            result.setId(source.getId());
            result.setName(source.getName());
            result.setRegions(getRegionIds(source));
            result.setCores(getCoreIds(source));
            result.setUnits(getUnitIds(source));
        }
        return result;
    }

    private List<Long> getRegionIds(final Nation s) {
        final List<Long> ids = new ArrayList<>();
        for (Region reg : s.getRegions()) {
            ids.add(reg.getId());
        }
        return ids;
    }

    private List<Long> getCoreIds(final Nation s) {
        final List<Long> ids = new ArrayList<>();
        for (Region reg : s.getCores()) {
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
