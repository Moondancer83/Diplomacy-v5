package hu.kalee.diplomacy.order;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * SupportLogicTest.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
public class SupportLogicTest {
    private CommandLogic underTest;

    @Before
    public void setUp() {
        underTest = new SupportLogic();
    }

    @Test
    public void testCheckShouldFailWhenNoCommandIsGiven() {
        Assert.assertFalse(underTest.check(null));
    }
}