package hu.kalee.diplomacy.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import hu.kalee.diplomacy.dto.UnitViewDTO;
import hu.kalee.diplomacy.domain.Unit;

/**
 * UnitEntityToViewDTOConverter.
 *
 * @author mkalinovits
 * @since 2017. 12. 03.
 */
@Component
public class UnitEntityToViewDTOConverter implements Converter<Unit, UnitViewDTO> {
    @Autowired
    private CommandEntityToViewDTOConverter converter;

    @Override
    public UnitViewDTO convert(final Unit source) {
        UnitViewDTO result = null;
        if (source != null) {
            result = new UnitViewDTO();
            result.setId(source.getId());
            result.setName(source.getName());
            result.setType(source.getType());
            result.setLocation(source.getLocation().getId());
            result.setOwner(source.getOwner().getId());
            result.setCommand(converter.convert(source.getCommand()));
        }
        return result;
    }
}