package com.ying.js.car.velocity;

import java.io.InputStream;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.velocity.context.Context;
import org.apache.velocity.tools.ToolboxFactory;
import org.apache.velocity.tools.config.ToolboxConfiguration;
import org.apache.velocity.tools.config.XmlFactoryConfiguration;
import org.apache.velocity.tools.view.ViewToolContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.view.velocity.VelocityLayoutView;

/**
 * 支持Velocity Layout
 *
 * User: diyan
 * Date: 4/29/16
 */
public class VelocityLayoutToolboxView extends VelocityLayoutView {

    private static final Logger LOGGER = LoggerFactory.getLogger(VelocityLayoutToolboxView.class);

    private static final String MODULE_TOOLS_PATH = "classpath*:/config/velocity-tools-module.xml";

    private static final Lock LOCK = new ReentrantLock(false);

    private static final Map<String, XmlFactoryConfiguration> CONFIG_CACHE_MAP = new ConcurrentHashMap<>();

    private static Resource[] moduleConfigResources = null;

    @Override
    protected Context createVelocityContext(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        ViewToolContext ctx = new ViewToolContext(this.getVelocityEngine(), request, response, this.getServletContext());
        if (this.getToolboxConfigLocation() != null) {
            LOGGER.debug("register global velocity toolbox config file: {}", this.getToolboxConfigLocation());
            this.initToolbox(ctx, this.getToolboxConfigLocation(), () -> ResourceUtils.getURL(this.getToolboxConfigLocation()).openStream());
        }

        if (moduleConfigResources == null) {
            moduleConfigResources = new PathMatchingResourcePatternResolver().getResources(MODULE_TOOLS_PATH);
        }
        if (moduleConfigResources != null && moduleConfigResources.length > 0) {
            for (Resource moduleConfigResource : moduleConfigResources) {
                LOGGER.debug("register classpath velocity toolbox config file: {}", moduleConfigResource.getURL().toString());
                this.initToolbox(ctx, moduleConfigResource.getURL().toString(), () -> moduleConfigResource.getInputStream());
            }
        }

        if (model != null && !model.isEmpty()) {
            ctx.putAll(model);
        }
        return ctx;
    }

    private void initToolbox(final ViewToolContext ctx, final String xmlUrl, final InputStreamCaller caller) throws Exception {
        XmlFactoryConfiguration factory = CONFIG_CACHE_MAP.get(xmlUrl);
        if (factory == null) {
            try {
                LOCK.lock();
                factory = CONFIG_CACHE_MAP.get(xmlUrl);
                if (factory == null) {
                    factory = new XmlFactoryConfiguration(true);
                    factory.read(caller.read());
                    CONFIG_CACHE_MAP.put(xmlUrl, factory);
                }
            } finally {
                LOCK.unlock();
            }
        }
        ToolboxFactory toolboxFactory = factory.createFactory();
        Collection<ToolboxConfiguration> toolboxes = factory.getToolboxes();
        for (ToolboxConfiguration tc : toolboxes) {
            ctx.addToolbox(toolboxFactory.createToolbox(tc.getScope()));
        }

    }

    interface InputStreamCaller {
        InputStream read() throws Exception;
    }

}
