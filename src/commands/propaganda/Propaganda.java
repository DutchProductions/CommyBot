package commands.propaganda;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.io.FileNotFoundException;
import java.util.Objects;

@SuppressWarnings("resource")
public class Propaganda {
    public Propaganda(SlashCommandInteractionEvent event) throws FileNotFoundException {
        String subcommand = Objects.requireNonNull(event.getSubcommandName());

        switch (subcommand) {
            case "stalin" -> new Stalin(event);
            case "putin" -> new Putin(event);
            default -> System.out.println("Unhandled sub-command: " + subcommand);
        }
    }
}
