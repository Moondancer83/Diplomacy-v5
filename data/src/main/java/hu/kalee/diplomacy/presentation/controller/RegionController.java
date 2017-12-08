package hu.kalee.diplomacy.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import hu.kalee.diplomacy.logic.converter.RegionEntityToViewDTOConverter;
import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.logic.dto.RegionViewDTO;
import hu.kalee.diplomacy.data.repository.RegionRepository;

/**
 * RegionController.
 *
 * @author mkalinovits
 * @since 2017. 12. 04.
 */
@RestController
public class RegionController {
    @Autowired
    private RegionRepository repository;
    @Autowired
    RegionEntityToViewDTOConverter converter;

    @RequestMapping(value = "regions")
    public List<RegionViewDTO> regions() {
        return Lists.transform((List<Region>)repository.findAll(), converter::convert);
    }
}
