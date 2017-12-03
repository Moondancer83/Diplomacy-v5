package hu.kalee.diplomacy.order;

import hu.kalee.diplomacy.domain.Command;

/**
 * AbstractCommandLogic.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
public abstract class AbstractCommandLogic implements CommandLogic{
    @Override
    public final boolean check(final Command command) {

        return command != null && specificChecks(command);
    }

    protected abstract boolean specificChecks(final Command command);
}
