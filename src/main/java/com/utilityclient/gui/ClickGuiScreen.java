package com.utilityclient.gui;

import com.utilityclient.module.Module;
import com.utilityclient.module.ModuleManager;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import java.util.List;

/**
 * Menu utama Utility Client. Buka dengan tombol keybinding (default: Right Shift).
 * Tiap tombol menampilkan nama fitur + status ON/OFF, tinggal tap untuk toggle.
 */
public class ClickGuiScreen extends Screen {
    private static final int BUTTON_WIDTH = 200;
    private static final int BUTTON_HEIGHT = 20;
    private static final int PADDING = 4;

    public ClickGuiScreen() {
        super(Text.literal("Utility Client"));
    }

    @Override
    protected void init() {
        List<Module> modules = ModuleManager.getInstance().getModules();
        int startX = this.width / 2 - BUTTON_WIDTH / 2;
        int startY = 30;

        for (int i = 0; i < modules.size(); i++) {
            Module module = modules.get(i);
            int y = startY + i * (BUTTON_HEIGHT + PADDING);

            ButtonWidget button = ButtonWidget.builder(
                    buttonLabel(module),
                    btn -> {
                        module.toggle();
                        btn.setMessage(buttonLabel(module));
                    }
            ).dimensions(startX, y, BUTTON_WIDTH, BUTTON_HEIGHT).build();

            this.addDrawableChild(button);
        }
    }

    private Text buttonLabel(Module module) {
        String state = module.isEnabled() ? "ON" : "OFF";
        return Text.literal(module.getName() + " [" + state + "]");
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        this.renderBackground(context);
        super.render(context, mouseX, mouseY, delta);
        context.drawCenteredTextWithShadow(this.textRenderer, this.title, this.width / 2, 10, 0xFFFFFF);
    }

    @Override
    public boolean shouldPause() {
        return false;
    }
}
