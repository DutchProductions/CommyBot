package commands.qol;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class QOL {
    public QOL(SlashCommandInteractionEvent event) {
        String subcommand = event.getSubcommandName();

        assert subcommand != null;
        if (subcommand.equals("purge") || subcommand.equals("clear")) { new Purge(event); }
    }
}
