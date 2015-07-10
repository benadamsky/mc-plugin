package com.mymcservers.wow;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.Random;

public final class SpawnVillagers implements Listener
{

    @EventHandler
    public void VillagerSpawn(CreatureSpawnEvent e)
    {

        if(e.getEntity().getType() == EntityType.VILLAGER)
        {
            Villager v = (Villager) e.getEntity();

            v.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 99999999, 127));
            v.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 99999999, 127));
            v.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 99999999, 127));

            v.setCustomName(ChatColor.GREEN + "" + ChatColor.BOLD + "Tutorial");
        }
    }

    @EventHandler
    public void VillagerHurt(EntityDamageByEntityEvent e)
    {
        if(e.getEntity().getType() == EntityType.VILLAGER)
        {
            if(e.getDamager().getType() == EntityType.PLAYER)
            {
                Villager v = (Villager) e.getEntity();
                Player p = (Player) e.getDamager();

                e.setCancelled(true);

                //Gets random number between 1-5
                Random rand = new Random();
                int  n = rand.nextInt(5) + 1;

                // Create new ArrayList.
                ArrayList<String> msgs = new ArrayList<>();

                // Add three elements.
                msgs.add("Ouch!");
                msgs.add("Please don't hit me!");
                msgs.add("You dare slap me?");
                msgs.add("Ow!");
                msgs.add("That hurts!");

                p.sendMessage(ChatColor.RED + "" + msgs.get(n));
            }
        }
    }

    @EventHandler
    public void VillagerInventory(PlayerInteractEntityEvent e)
    {
        if(e.getRightClicked().getType() == EntityType.VILLAGER)
        {
            Villager v = (Villager) e.getRightClicked();
            Player p = e.getPlayer();
            e.setCancelled(true);
            if(!v.getCustomName().contains("Tutorial"));

            Inventory inv = Bukkit.createInventory(null, 27, ChatColor.GREEN + "Quest Selector");

            ItemStack quest = new ItemStack(Material.PAPER);
            ItemMeta questlore = quest.getItemMeta();
            questlore.setDisplayName(ChatColor.YELLOW + "Quest Name");
            quest.setItemMeta(questlore);

            inv.setItem(0, quest);
            p.openInventory(inv);
        }

    }


}
