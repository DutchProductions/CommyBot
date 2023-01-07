package commands.propaganda;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.utils.FileUpload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Putin extends FileUpload {
    public Putin(SlashCommandInteractionEvent event) throws FileNotFoundException {
        super(new FileInputStream("resources/PutinWaving.gif"), "PutinWavingPutin.gif");

        event.replyFiles(this).queue();
    }
}
