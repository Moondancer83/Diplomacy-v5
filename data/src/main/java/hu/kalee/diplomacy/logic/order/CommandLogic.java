package hu.kalee.diplomacy.logic.order;

import hu.kalee.diplomacy.data.domain.Command;

/**
 * CommandLogic.
 *
 * @author mkalinovits
 */
public interface CommandLogic {
    boolean check(Command command);
}
