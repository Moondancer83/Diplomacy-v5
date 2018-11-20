package hu.kalee.diplomacy.logic.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;

import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.data.repository.RegionRepository;
import hu.kalee.diplomacy.logic.converter.RegionEntityToViewDTOConverter;
import hu.kalee.diplomacy.logic.dto.RegionViewDTO;

/**
 * RegionFacade.
 *
 * @author mkalinovits
 * @since 2017. 12. 09.
 */
@Component
public class RegionFacade {
    @Autowired
    private RegionRepository regionRepository;
    @Autowired
    private RegionEntityToViewDTOConverter regionEntityToViewDTOConverter;

    public List<RegionViewDTO> getRegions() {
        return Lists.transform((List<Region>) regionRepository.findAll(), regionEntityToViewDTOConverter::convert);
    }

}
