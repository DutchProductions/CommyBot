package commands;

import commands.propaganda.Propaganda;
import commands.qol.QOL;
import commands.test.Test;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.events.guild.GuildJoinEvent;
import net.dv8tion.jda.api.events.guild.GuildReadyEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.interactions.commands.OptionType;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;
import net.dv8tion.jda.api.interactions.commands.build.Commands;
import net.dv8tion.jda.api.interactions.commands.build.SubcommandData;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings({"DuplicatedCode", "resource"})
public class Manager extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        String slashName = event.getName();

        switch (slashName) {
            case "test" -> {
                try {
                    new Test(event);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            case "propaganda" -> {
                try {
                    new Propaganda(event);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            case "qol" -> new QOL(event);
            case "welcome" -> {
                try {
                    new Welcome(event);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
            default -> System.out.println("Command " + slashName  + " was not found.");
        }
    }


    @Override
    public void onGuildReady(GuildReadyEvent event) {
        Guild guild = event.getGuild();

        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("test", "Testing commands").addSubcommands(
                new SubcommandData("ping", "Is the bot online?"),
                new SubcommandData("welcome", "Welcome someone to the server").addOption(OptionType.USER, "user", "Who do you want to welcome?")
        ));

        commandData.add(Commands.slash("propaganda", "Spread some Communist propaganda").addSubcommands(
                new SubcommandData("stalin", "Embrace the glorious motherland"),
                new SubcommandData("putin", "Salute the future")
        ));

        commandData.add(Commands.slash("qol", "Quality Of Life features").addSubcommands(
                new SubcommandData("purge", "Purge a selected amount of messages. (default 10)").addOption(OptionType.INTEGER, "amount", "Amount to delete. Defaults to 10"),
                new SubcommandData("clear", "Clear a selected amount of messages. (default 10)").addOption(OptionType.INTEGER, "amount", "Amount to delete. Defaults to 10")
        ));

        guild.updateCommands().addCommands(commandData).queue();
    }

    @Override
    public void onGuildJoin(GuildJoinEvent event) {
        Guild guild = event.getGuild();

        List<CommandData> commandData = new ArrayList<>();
        commandData.add(Commands.slash("test", "Testing commands").addSubcommands(
                new SubcommandData("ping", "Is the bot online?"),
                new SubcommandData("welcome", "Welcome someone to the server").addOption(OptionType.USER,
                        "user", "Who do you want to welcome?")
        ));
        commandData.add(Commands.slash("stalin", "glorious"));

        guild.updateCommands().addCommands(commandData).queue();
    }
}
