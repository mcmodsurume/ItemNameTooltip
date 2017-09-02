package tk.surume.mcmod.itemnametooltip;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

@Mod(modid = ItemNameTooltip.MODID, version = ItemNameTooltip.VERSION)
public class ItemNameTooltip
{
    public static final String MODID = "itemnametooltip";
    public static final String VERSION = "1.0";
    

    @EventHandler
    public void load(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void addTooltip(ItemTooltipEvent event)
    {
        ItemStack itemStack = event.itemStack;
        
        Item item = itemStack.getItem();
        String tipText = Item.itemRegistry.getNameForObject(item);
        if (item.getDamage(itemStack) != 0) {
            tipText += " "+Integer.toString(item.getDamage(itemStack));
        }
        tipText += "";
        event.toolTip.add(tipText);
    }
}