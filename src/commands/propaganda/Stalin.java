package commands.propaganda;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Stalin extends FileUpload {
    public Stalin(SlashCommandInteractionEvent event) throws FileNotFoundException {
        super(new FileInputStream("resources/Stalin.png"), "Stalin.png");
        event.replyFiles(this).queue();
    }
}
