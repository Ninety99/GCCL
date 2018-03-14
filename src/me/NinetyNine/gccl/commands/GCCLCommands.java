package me.NinetyNine.gccl.commands;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

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

import me.NinetyNine.gccl.GCCL;

public class GCCLCommands implements Listener, CommandExecutor {
	
	//public ArrayList<String> bs = new ArrayList<String>();
	//public HashMap<String, String> bs1 = new HashMap<>();
	
	private static GCCL plugin;

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

		ItemStack binh = new ItemStack(Material.WRITTEN_BOOK);
		BookMeta inh = (BookMeta) binh.getItemMeta();
		//inh.addPage(" ");
		binh.setItemMeta(inh);
		
		BookMeta inhand = (BookMeta) player.getItemInHand().getItemMeta();

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

		//String inb7 = inh.getPage(7);
		//String inb8 = inh.getPage(8);
		//String inb9 = inh.getPage(9);
		
		List<String> pages = inh.getPages();

		if (cmd.getName().equalsIgnoreCase("changelog")) {
			if (player.hasPermission("changelog.open")) {
				
				bm.setPages(pages);
				//bm.setPage(1, inb7 + inb8 + inb9);
				//if (bm.getPageCount() < 10) {
				//bm.setPage(7, "");
				//bm.setPage(8, "");
				//bm.setPage(9, "");
				//bm.setPage(10, "");
				//}
				
				//pages.add(inb7 + inb8 + inb9);

				b.setItemMeta(bm);
				//b.setItemMeta(inh);
				
				playerinv.addItem(b);
			} else {
				player.sendMessage("You do not have permission.");
				return false;
			}
		}

		//if (player.getItemInHand().getType().equals(Material.WRITTEN_BOOK) && player.getItemInHand().hasItemMeta()) {
			if (cmd.getName().equalsIgnoreCase("gcchangelog")) {
				if (player.hasPermission("gcchangelog.admin")) {
					if (args.length == 0) {
						player.sendMessage("Usage: /gcchangelog add <type> <message>");
						return true;
					}

					if (args[0].equalsIgnoreCase("set")) {
						if (args.length == 1) {
							inh.setTitle("GCChangelog");
							//bs.add(commandLabel);
							//bs1.put(message, message1);
							//bs1.put(message1, message2);
							
							//b.setItemMeta(inh);
							//b.setItemMeta(bm);
							b.setItemMeta(inhand);
							playerinv.setItemInHand(b);
							player.sendMessage("Set!");
							return true;
						}
					}
					
					if (args[0].equalsIgnoreCase("reload")) {
						if (args.length == 1) {
							plugin.reloadConfig();
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
							//bs.remove(commandLabel);
							//bs1.remove(message);
							//bs1.remove(message1);
							//bs1.remove(message2);
							return true;
						}
					}

					if (args[1].equalsIgnoreCase("fixed")) {
						if (args.length == 2) {
							player.sendMessage("Usage: /gcchangelog add fixed <message>");
							return true;
						} else {
							//inh.addPage(format.format(now) + "\n" + gcpf + message + "\n");
							//bm.addPage(format.format(now) + "\n" + gcpf + message + "\n");
							//pages.add(format.format(now) + "\n" + gcpf + message + "\n");
							
							inhand.addPage(format.format(now) + "\n" + gcpf + message + "\n");
							
							//bs.add(commandLabel);		
							//bs1.put(message, message1);
							//bs1.put(message1, message2);
							//b.setItemMeta(inh);
							//b.setItemMeta(bm);
							
							b.setItemMeta(inhand);
							
							//playerinv.setItemInHand(b);
							
							player.sendMessage("Added!");
						}
					}

					if (args[1].equalsIgnoreCase("removed")) {
						if (args.length == 2) {
							player.sendMessage("Usage: /gchangelog add removed <message>");
							return true;
						} else {
							//inh.addPage(" " + "\n" + gcpr + message + "\n");
							//bm.addPage(" " + "\n" + gcpr + message + "\n");
							
							//pages.add("" + "\n" + gcpr + message + "\n");
							
							//bs.add(commandLabel);
							//bs1.put(message, message1);
							//bs1.put(message1, message2);
							//b.setItemMeta(bm);
							//b.setItemMeta(inh);
							//playerinv.setItemInHand(b);
							
							inhand.addPage(" " + "\n" + gcpr + message + "\n");
							b.setItemMeta(inhand);
							player.sendMessage("Added!");
						}
					}

					if (args[1].equalsIgnoreCase("changed")) {
						if (args.length == 2) {
							player.sendMessage("Usage: /gcchangelog add changed <message>");
							return true;
						} else {
							//inh.addPage(" " + "\n" + gcpc + message + "\n");
							//bm.addPage(" " + "\n" + gcpc + message + "\n");
							
							//pages.add("" + "\n" + gcpc + message + "\n");
							
							//bs.add(commandLabel);
							//bs1.put(message, message1);
							//bs1.put(message1, message2);
							//b.setItemMeta(bm);
							//b.setItemMeta(inh);
							//playerinv.setItemInHand(b);
							
							inhand.addPage(" " + "\n" + gcpc + message + "\n");
							b.setItemMeta(inhand);
							player.sendMessage("Added!");
						}
					}
					
					if (args[1].equalsIgnoreCase("page")) {
						if (bm.getPageCount() < plugin.getConfig().getInt("maxPages")) { // gives the number from the config file
							bm.addPage("§8[§6Guild§7Craft§8] §2New page!");
							b.setItemMeta(bm);
							player.setItemInHand(b);

							//bs.add(commandLabel);
							//bs1.put(message, message1);
							//bs1.put(message1, message2);
							player.sendMessage("§8[§6Guild§7Craft§8] §7+1 page");
						} else {
							player.sendMessage("§8[§6Guild§7Craft§8] §4Reached the maximum level of pages!");
							return false;
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
				} else {
					player.sendMessage("You don't have permissions.");
					return true;
				}
			}
		//} else {
		//	player.sendMessage("You must hold the changelog!");
		//	return true;
		//}
		return true;
	}
}