package com.motokyi.choiceness.telegram.components;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

public interface TGBotFactory {
    Optional<TGBot> get(String botName);

    Set<String> botNames();

    Collection<TGBot> bots();
}
