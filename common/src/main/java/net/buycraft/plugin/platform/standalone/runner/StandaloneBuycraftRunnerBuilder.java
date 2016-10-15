package net.buycraft.plugin.platform.standalone.runner;

import lombok.Builder;
import lombok.NonNull;

import java.util.concurrent.ScheduledExecutorService;
import java.util.logging.Logger;

/**
 * This class allows for simple handling and execution of Buycraft commands with a fluent API.
 */
@Builder
public class StandaloneBuycraftRunnerBuilder {
    @NonNull
    private final CommandDispatcher dispatcher;
    @NonNull
    private final PlayerDeterminer determiner;
    @NonNull
    private final String apiKey;
    @NonNull
    private final Logger logger;
    @NonNull
    private final ScheduledExecutorService executorService;
    @NonNull
    private boolean verbose = true;

    private Integer checkInterval = null;

    public StandaloneBuycraftRunner start() {
        StandaloneBuycraftRunner runner = checkInterval == null ? new StandaloneBuycraftRunner(dispatcher, determiner, apiKey, logger, executorService, verbose) :
                new StandaloneBuycraftRunner(dispatcher, determiner, apiKey, logger, executorService, verbose, checkInterval);
        runner.initializeTasks();
        return runner;
    }
}
