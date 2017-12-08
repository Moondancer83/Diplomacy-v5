package hu.kalee.diplomacy.logic.order;

import hu.kalee.diplomacy.data.domain.Command;

/**
 * AbstractCommandLogic.
 *
 * @author mkalinovits
 * @since 2017. 12. 02.
 */
public abstract class AbstractCommandLogic implements CommandLogic{
    @Override
    public final boolean check(final Command command) {

        return command != null && precheck(command) && specificChecks(command);
    }

    protected abstract boolean specificChecks(final Command command);

    private boolean precheck(final Command command) {
        return command.getUnit() != null && command.getBase() != null && command.getTarget() != null;
    }
}
