package diplomacy.order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import hu.kalee.diplomacy.domain.Command;
import hu.kalee.diplomacy.domain.CommandType;
import hu.kalee.diplomacy.order.CommandLogic;
import hu.kalee.diplomacy.order.HoldLogic;

/**
 * HoldLogicTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
public class HoldLogicTest {
    private CommandLogic underTest;

    @Before
    public void setUp() {
        underTest = new HoldLogic();
    }

    @Test
    public void testCheckShouldFailWhenNoCommandIsGiven() {
        Assert.assertFalse(underTest.check(null));
    }

    @Test
    public void testCheckShouldReturnTrue() {
        final Command holdCommand = new Command();
        holdCommand.setType(CommandType.HOLD);
        Assert.assertTrue(underTest.check(holdCommand));
    }
}