package landmaster.landcraft.jei;

import java.util.*;

import landmaster.landcraft.api.*;
import landmaster.landcraft.util.*;
import mezz.jei.api.ingredients.*;
import net.minecraft.client.*;
import net.minecraft.item.*;
import net.minecraft.util.text.*;
import net.minecraftforge.fluids.*;

public class PotOredictRecipeJEI extends PotRecipeJEI {
	private PotRecipes.RecipePOredict prc;
	
	public PotOredictRecipeJEI(PotRecipes.RecipePOredict prc) {
		super(prc);
		this.prc = prc;
	}
	
	@Override
	public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
		minecraft.fontRenderer.drawString(TextFormatting.DARK_RED.toString()+TextFormatting.BOLD
				+String.format(Locale.US, "%d RF/t", prc.out.energyPerTick),
				100, 58, 0x000000);
	}
	
	@Override
	public void getIngredients(IIngredients ingredients) {
		ingredients.setInputLists(ItemStack.class,
				Arrays.asList(
						Utils.getOres(prc.i1),
						Utils.getOres(prc.i2),
						Utils.getOres(prc.i3)));
		ingredients.setInput(FluidStack.class, prc.fs);
		ingredients.setOutput(ItemStack.class, prc.out.out);
	}
}
