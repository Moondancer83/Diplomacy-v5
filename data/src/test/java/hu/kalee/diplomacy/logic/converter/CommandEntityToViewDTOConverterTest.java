package hu.kalee.diplomacy.logic.converter;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import hu.kalee.diplomacy.data.domain.Command;
import hu.kalee.diplomacy.data.domain.CommandType;
import hu.kalee.diplomacy.data.domain.Region;
import hu.kalee.diplomacy.data.domain.Unit;
import hu.kalee.diplomacy.logic.dto.CommandViewDTO;

/**
 * CommandEntityToViewDTOConverterTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 08.
 */
public class CommandEntityToViewDTOConverterTest {

    private CommandEntityToViewDTOConverter underTest;

    @Before
    public void setUp() {
        underTest = new CommandEntityToViewDTOConverter();
    }

    @Test
    public void testConvertShouldReturnNullOnNull() {
        CommandViewDTO actual = underTest.convert(null);
        Assertions.assertThat(actual).isNull();
    }

    @Test
    public void testConvertShouldConvertObject() {
        Command source = new Command();
        final Region target = new Region();
        target.setId(2);
        Unit unit = new Unit();
        unit.setId(3);
        source.setId(1);
        source.setType(CommandType.HOLD);
        source.setUnit(unit);
        source.setBase(target);
        source.setTarget(target);
        source.setNote("Notes");
        CommandViewDTO actual = underTest.convert(source);

        final CommandViewDTO expected = new CommandViewDTO();
        expected.setId(1);
        expected.setType(CommandType.HOLD);
        expected.setUnit(3);
        expected.setBase(2);
        expected.setTarget(2);
        expected.setNote("Notes");
        Assertions.assertThat(actual).isEqualToComparingFieldByField(expected);
    }
}
