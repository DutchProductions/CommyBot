package commands.test;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.io.FileNotFoundException;
import java.util.Objects;

public class Test {
    public Test(SlashCommandInteractionEvent event) throws FileNotFoundException {
        String subcommand = Objects.requireNonNull(event.getSubcommandName());

        if (subcommand.equals("ping")) {
            new Ping(event);
        } else {
            System.out.println("Unhandled sub-command: " + subcommand);
        }
    }
}
