package hu.kalee.diplomacy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import hu.kalee.diplomacy.converter.RegionEntityToViewDTOConverter;
import hu.kalee.diplomacy.domain.Region;
import hu.kalee.diplomacy.dto.RegionViewDTO;
import hu.kalee.diplomacy.repository.RegionRepository;

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