package me.NinetyNine.gccl.commands;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.BookMeta;

public class GCCLCommands implements Listener, CommandExecutor {

	//private ArrayList<String> t = new ArrayList<String>();
	
	public ArrayList<String> bs = new ArrayList<String>();

	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

		Player player = (Player) sender;
		PlayerInventory playerinv = player.getInventory();

		ItemStack b = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta bm = (BookMeta) b.getItemMeta();
		bm.setTitle("GuildCraft Changelog");
		bm.setAuthor("aXed");
		bm.addPage(" ");
		bm.addPage(" ");
		bm.addPage(" ");
		bm.addPage(" ");
		bm.addPage(" ");
		bm.addPage(" ");
		b.setItemMeta(bm);

		BookMeta inh = (BookMeta) player.getItemInHand().getItemMeta();

		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");

		String message = "";

		for (int i = 2; i < args.length; i++) {
			message += args[i] + " ";
		}
		message = message.trim();

		String message1 = "";

		for (int i1 = 8; i1 < args.length; i1++) {
			message1 += args[i1] + " ";
		}
		message1 = message1.trim();

		String message2 = "";

		for (int i2 = 9; i2 < args.length; i2++) {
			message2 += args[i2] + " ";
		}
		message2 = message2.trim();

		String gcpf = ChatColor.GREEN + "✔ " + ChatColor.BLACK + "";
		String gcpr = ChatColor.RED + "✘ " + ChatColor.BLACK + "";
		String gcpc = ChatColor.GOLD + "▶ " + ChatColor.BLACK + "";

		String inb1 = bm.getPage(1);
		String inb2 = bm.getPage(2);
		String inb3 = bm.getPage(3);
		String inb4 = bm.getPage(4);
		String inb5 = bm.getPage(5);
		String inb6 = bm.getPage(6);

		if (cmd.getName().equalsIgnoreCase("changelog")) {
			if (player.hasPermission("changelog.open")) {
				
				bm.setPage(1, inb1);
				bm.setPage(2, inb2);
				bm.setPage(3, inb3);
				bm.setPage(4, inb4);
				bm.setPage(5, inb5);
				bm.setPage(6, inb6);

				b.setItemMeta(bm);
				playerinv.addItem(b);
			} else {
				player.sendMessage("You do not have permission.");
				return false;
			}
		}

		if (player.getItemInHand().getType().equals(Material.WRITTEN_BOOK) && player.getItemInHand().hasItemMeta()) {
			if (cmd.getName().equalsIgnoreCase("gcchangelog")) {
				if (player.hasPermission("gcchangelog.admin")) {
					if (args.length == 0) {
						player.sendMessage("Usage: /gcchangelog add <type> <message>");
						return true;
					}

					if (args[0].equalsIgnoreCase("set")) {
						if (args.length == 1) {
							inh.setTitle("GCChangelog");
							bs.add(commandLabel);
							b.setItemMeta(inh);
							playerinv.setItemInHand(b);
							player.sendMessage("Set!");
							return true;
						}
					}

					if (args[0].equalsIgnoreCase("add")) {
						if (args.length == 1) {
							player.sendMessage("Usage: /gcchangelog add <type> <message>");
							return true;
						}
					}
					
					if (args[0].equalsIgnoreCase("undo")) {
						if (args.length == 1) {
							bs.remove(commandLabel);
							return true;
						}
					}

					if (args[1].equalsIgnoreCase("fixed")) {
						if (args.length == 2) {
							player.sendMessage("Usage: /gcchangelog add fixed <message>");
							return true;
						} else {
							inh.addPage(format.format(now) + "\n" + gcpf + message + "\n");
							bs.add(commandLabel);							
							b.setItemMeta(inh);
							playerinv.setItemInHand(b);
							player.sendMessage("Added!");
						}
					}

					if (args[1].equalsIgnoreCase("removed")) {
						if (args.length == 2) {
							player.sendMessage("Usage: /gchangelog add removed <message>");
							return true;
						} else {
							inh.addPage(format.format(now) + "\n" + gcpr + message + "\n");
							bs.add(commandLabel);
							b.setItemMeta(inh);
							playerinv.setItemInHand(b);
							player.sendMessage("Added!");
						}
					}

					if (args[1].equalsIgnoreCase("changed")) {
						if (args.length == 2) {
							player.sendMessage("Usage: /gcchangelog add changed <message>");
							return true;
						} else {
							bm.addPage(format.format(now) + "\n" + gcpc + message + "\n");
							bs.add(commandLabel);
							b.setItemMeta(inh);
							playerinv.setItemInHand(b);
							player.sendMessage("Added!");
						}
					}
					
					/*
					if (args[1].equalsIgnoreCase("all")) {
						if (args.length == 2) {
							player.sendMessage("Usage: /gcchangelog add all <message>");
							return true;
						} else {
							inh.addPage(format.format(now) + "\n" + gcpf + message + "\n" + gcpr + message1 + "\n"
									+ gcpc + message2 + "\n");
							b.setItemMeta(inh);
							playerinv.setItemInHand(b);
							player.sendMessage("Added!");
						}
					}
					*/
				}
			}
		} else {
			player.sendMessage("You must hold the changelog!");
			return true;
		}
		return true;
	}
}
