
package net.mcreator.modernplanets.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.modernplanets.world.inventory.GuiRocketMenu;
import net.mcreator.modernplanets.network.GuiRocketButtonMessage;
import net.mcreator.modernplanets.ModernPlanetsMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class GuiRocketScreen extends AbstractContainerScreen<GuiRocketMenu> {
	private final static HashMap<String, Object> guistate = GuiRocketMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public GuiRocketScreen(GuiRocketMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 190;
		this.imageHeight = 267;
	}

	private static final ResourceLocation texture = new ResourceLocation("modern_planets:textures/gui_rocket.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Rocket", 3, 7, -12829636);
		this.font.draw(poseStack, "0% Fuel", 27, 42, -12829636);
		this.font.draw(poseStack, "Available Planets", 85, 6, -12829636);
		this.font.draw(poseStack, "BETA - NO FUEL REQUIRED", 32, 224, -39424);
		this.font.draw(poseStack, "Tier 1 - 4 Planets", 45, 213, -12829636);
		this.font.draw(poseStack, "note: space can be dangerous", 17, 236, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 99, this.topPos + 18, 56, 20, new TextComponent("Mars"), e -> {
			if (true) {
				ModernPlanetsMod.PACKET_HANDLER.sendToServer(new GuiRocketButtonMessage(0, x, y, z));
				GuiRocketButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 4, this.topPos + 58, 61, 20, new TextComponent("Deposit"), e -> {
			if (true) {
				ModernPlanetsMod.PACKET_HANDLER.sendToServer(new GuiRocketButtonMessage(1, x, y, z));
				GuiRocketButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 103, this.topPos + 40, 46, 20, new TextComponent("Moon"), e -> {
			if (true) {
				ModernPlanetsMod.PACKET_HANDLER.sendToServer(new GuiRocketButtonMessage(2, x, y, z));
				GuiRocketButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 101, this.topPos + 62, 51, 20, new TextComponent("Earth"), e -> {
			if (true) {
				ModernPlanetsMod.PACKET_HANDLER.sendToServer(new GuiRocketButtonMessage(3, x, y, z));
				GuiRocketButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 81, this.topPos + 83, 93, 20, new TextComponent("Space Station"), e -> {
			if (true) {
				ModernPlanetsMod.PACKET_HANDLER.sendToServer(new GuiRocketButtonMessage(4, x, y, z));
				GuiRocketButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 83, this.topPos + 105, 87, 20, new TextComponent("Uranus Rings"), e -> {
			if (true) {
				ModernPlanetsMod.PACKET_HANDLER.sendToServer(new GuiRocketButtonMessage(5, x, y, z));
				GuiRocketButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
	}
}
