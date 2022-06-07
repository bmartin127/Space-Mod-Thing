
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

import net.mcreator.modernplanets.world.inventory.Cheese2Menu;
import net.mcreator.modernplanets.network.Cheese2ButtonMessage;
import net.mcreator.modernplanets.ModernPlanetsMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class Cheese2Screen extends AbstractContainerScreen<Cheese2Menu> {
	private final static HashMap<String, Object> guistate = Cheese2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public Cheese2Screen(Cheese2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 188;
		this.imageHeight = 188;
	}

	private static final ResourceLocation texture = new ResourceLocation("modern_planets:textures/cheese_2.png");

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
		this.font.draw(poseStack, "Cheese Pasteurizer", 39, 3, -12829636);
		this.font.draw(poseStack, "WARNING:", 62, 70, -65536);
		this.font.draw(poseStack, "Only put in 1 cheese ore at a time.", 4, 82, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 67, this.topPos + 30, 77, 20, new TextComponent("Pasteurize"), e -> {
			if (true) {
				ModernPlanetsMod.PACKET_HANDLER.sendToServer(new Cheese2ButtonMessage(0, x, y, z));
				Cheese2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
	}
}
