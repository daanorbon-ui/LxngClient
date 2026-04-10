package net.lxngclient.gui;

import net.lxngclient.util.ColorUtils;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import java.io.IOException;

public class LxngMainMenu extends GuiScreen {

    // De "Electric Midnight" achtergrondkleur
    private final int backgroundColor = 0xFF0F0F12;

    @Override
    public void initGui() {
        int x = this.width / 2;
        int y = this.height / 2;

        // Knoppen toevoegen met de Lxng-stijl
        this.buttonList.add(new GuiButton(1, x - 100, y, 200, 20, "SINGLEPLAYER"));
        this.buttonList.add(new GuiButton(2, x - 100, y + 24, 200, 20, "MULTIPLAYER"));
        this.buttonList.add(new GuiButton(3, x - 100, y + 48, 200, 20, "LXNG SETTINGS"));
        this.buttonList.add(new GuiButton(0, x - 100, y + 72, 200, 20, "QUIT GAME"));
        
        super.initGui();
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        // 1. Teken de Midnight achtergrond
        drawRect(0, 0, this.width, this.height, backgroundColor);

        // 2. Ling Glow Titel berekenen
        // We laten de kleuren vloeiend in elkaar overgaan voor de tekst
        String title = "LXNGCLIENT";
        float scale = 4.0f;
        
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.width / 2f, this.height / 4f, 0);
        GlStateManager.scale(scale, scale, scale);

        // Teken de titel letter voor letter voor een "Wave" effect in de gradient
        float xOffset = - (this.fontRendererObj.getStringWidth(title) / 2f);
        for (int i = 0; i < title.length(); i++) {
            char c = title.charAt(i);
            // Index 'i * 100' zorgt dat de letters een andere fase van de gradient hebben
            int color = ColorUtils.getLingGlow(i * 100);
            this.fontRendererObj.drawStringWithShadow(String.valueOf(c), xOffset, 0, color);
            xOffset += this.fontRendererObj.getCharWidth(c);
        }
        
        GlStateManager.popMatrix();

        // 3. Subtiele versie-informatie (Ling Edition)
        String footer = "LxngClient v1.0 | Developed for Ling";
        this.fontRendererObj.drawStringWithShadow(footer, 2, this.height - 10, 0x80FFFFFF);

        // 4. Teken de knoppen
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        switch (button.id) {
            case 1:
                this.mc.displayGuiScreen(new GuiSelectWorld(this));
                break;
            case 2:
                this.mc.displayGuiScreen(new GuiMultiplayer(this));
                break;
            case 3:
                // Hier komt later je custom Lxng Settings menu
                break;
            case 0:
                this.mc.shutdown();
                break;
        }
    }
}
