package com.github.txmy.lunar;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.contrum.abbys.AbyssLoader;
import org.contrum.abbys.AbyssLoaderOptions;
import org.contrum.abbys.event.AbyssLoadEvent;

public class LunarCombatFix extends JavaPlugin {

    @Override
    public void onEnable() {
        AbyssLoader loader = new AbyssLoader(this, AbyssLoaderOptions.builder()
                .downloadIfMissing(true)
                .restartUponLoadingError(true)
                .build());

        this.getServer().getPluginManager().registerEvents(new Listener() {

            @EventHandler
            public void onAbyssLoad(AbyssLoadEvent event) {
                loader.getCombatModule().setDisableHitMissPenalty(true);
            }

        }, this);
    }
}
