package io.github.thebusybiscuit.slimefun4.integrations;

import io.github.thebusybiscuit.slimefun4.implementation.Slimefun;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;

import javax.annotation.Nonnull;

public class VaultIntegration {

    private static Economy econ = null;
    private Slimefun plugin;

    public VaultIntegration(@Nonnull Slimefun plugin) {

        this.plugin = plugin;
    }

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> rsp = this.plugin.getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    public void register() {
        if (!setupEconomy() ) {
            return;
        }
    }
}
