package com.denizenscript.clientizen.scripts.commands;

import com.denizenscript.clientizen.scripts.containers.GuiScriptContainer;
import com.denizenscript.denizencore.objects.core.ScriptTag;
import com.denizenscript.denizencore.scripts.ScriptEntry;
import com.denizenscript.denizencore.scripts.commands.AbstractCommand;
import com.denizenscript.denizencore.scripts.commands.Holdable;
import com.denizenscript.denizencore.scripts.commands.generator.ArgName;
import dev.lambdaurora.spruceui.Position;
import dev.lambdaurora.spruceui.screen.SpruceScreen;
import dev.lambdaurora.spruceui.widget.SpruceButtonWidget;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class GuiCommand extends AbstractCommand implements Holdable {

	public GuiCommand() {
		setName("gui");
		setSyntax("gui [<script>]");
		setRequiredArguments(1, 1);
	}

	public static void autoExecute(ScriptEntry scriptEntry, @ArgName("script") ScriptTag script) {
		if (script.getContainer() instanceof GuiScriptContainer gui) {
			SpruceScreen screen = new SpruceScreen(Text.literal("Test GUI screen")) {

				@Override
				protected void init() {
					super.init();
					addDrawableChild(new SpruceButtonWidget(Position.center(width, height), 150, 20, Text.literal(gui.buttonName), btn -> {
						client.player.sendMessage(Text.literal("hello"), false);
					}));
				}
			};
			screen.init(MinecraftClient.getInstance(), 500, 500);
		}
	}
}
