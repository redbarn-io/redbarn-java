package io.redbarn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.Reader;

import static io.redbarn.ResourceUtils.getResourceReader;

/**
 * Loads all scripts and prepares the ScriptEngine.
 *
 * @author Mike Atkisson
 * @since 0.1.0
 */
public class RedbarnScriptEngineManager extends ScriptEngineManager {

    public static final String SCRIPT_ENGINE_NAME = "nashorn";
    private static final Logger logger =
            LoggerFactory.getLogger(RedbarnScriptEngineManager.class);

    /**
     * Gets a JavaScript script engine preloaded with scripts needed for
     * template translation.
     *
     * @return A ScriptEngine instance.
     * @throws IOException Thrown if one of the preloaded script resources
     *                     could not be found.
     */
    public ScriptEngine getScriptEngine() throws IOException, ScriptException {
        ScriptEngine engine = getEngineByName(SCRIPT_ENGINE_NAME);
        try (Reader console = getResourceReader("scripts/io/redbarn/console.js")) {
            engine.eval(console);
        }
        return engine;
    }

}
