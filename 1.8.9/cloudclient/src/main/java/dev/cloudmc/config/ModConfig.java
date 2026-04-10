/*
 * Copyright (c) 2026 LxngClient (Ling Edition)
 * GNU Lesser General Public License v3.0
 */

package net.lxngclient.config;

import net.lxngclient.feature.setting.Setting;
import java.util.ArrayList;

/**
 * LxngClient ModConfig
 * Beheert de opgeslagen status, positie en instellingen van elke module.
 */
public class ModConfig {

    private String name;
    private boolean toggled;
    private ArrayList<Setting> settings;
    private int[] positions;
    private float size;

    public ModConfig(String name, boolean toggled, ArrayList<Setting> settings, int[] positions, float size) {
        this.name = name;
        this.toggled = toggled;
        this.settings = settings;
        this.positions = positions;
        this.size = size;
    }

    /**
     * Haalt de naam van de module op (bijv. "FPS" of "ToggleSprint")
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Controleert of de module aanstaat in de LxngClient
     */
    public boolean isToggled() {
        return toggled;
    }

    public void setToggled(boolean toggled) {
        this.toggled = toggled;
    }

    /**
     * Haalt de specifieke instellingen (zoals kleuren of bereik) op
     */
    public ArrayList<Setting> getSettings() {
        return settings;
    }

    public void setSettings(ArrayList<Setting> settings) {
        this.settings = settings;
    }

    /**
     * Geeft de X en Y coördinaten terug voor de Pixel-Snap GUI
     */
    public int[] getPositions() {
        return positions;
    }

    public void setPositions(int[] positions) {
        this.positions = positions;
    }

    /**
     * De schaal van de module op de HUD
     */
    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
}
