package hu.kalee.diplomacy.order;

import hu.kalee.diplomacy.domain.Command;

public interface CommandLogic {
    boolean check(Command command);
}
