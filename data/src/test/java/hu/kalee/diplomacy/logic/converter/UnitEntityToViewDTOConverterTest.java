package hu.kalee.diplomacy.logic.converter;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hu.kalee.diplomacy.data.domain.Command;
import hu.kalee.diplomacy.data.domain.Nation;
import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.data.domain.Unit;
import hu.kalee.diplomacy.data.domain.UnitType;
import hu.kalee.diplomacy.logic.dto.UnitViewDTO;

/**
 * UnitEntityToViewDTOConverterTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 10.
 */
public class UnitEntityToViewDTOConverterTest {
    private UnitEntityToViewDTOConverter underTest;

    @Before
    public void setUp() {
        underTest = new UnitEntityToViewDTOConverter();
    }

    @Test
    public void testConvertShouldReturnNullOnNull() {
        // GIVEN
        // WHEN
        UnitViewDTO actual = underTest.convert(null);
        // THEN
        Assertions.assertThat(actual).isNull();
    }

    @Test
    public void testConvertShouldConvertAllFields() {
        // GIVEN
        final Unit source = new Unit();
        source.setId(1);
        source.setType(UnitType.NAVY);
        source.setName("Unit");
        final Nation nation = new Nation();
        nation.setId(2);
        source.setOwner(nation);
        final Region location = new Region();
        location.setId(3);
        source.setLocation(location);
        final Command command = new Command();
        command.setId(4);
        source.setCommand(command);

        final UnitViewDTO expected = new UnitViewDTO();
        expected.setId(1);
        expected.setName("Unit");
        expected.setOwner(2);
        expected.setLocation(3);
        expected.setCommand(4L);
        expected.setType(UnitType.NAVY);
        // WHEN
        UnitViewDTO actual = underTest.convert(source);
        // THEN
        Assertions.assertThat(actual).isEqualToComparingFieldByField(expected);
    }
}
