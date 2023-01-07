package commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;
import net.dv8tion.jda.api.interactions.commands.SlashCommandInteraction;
import net.dv8tion.jda.api.utils.FileUpload;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Welcome extends FileUpload {
    public Welcome(SlashCommandInteraction event) throws FileNotFoundException {
        super(new FileInputStream("resources/PutinWaving.gif"), "PutinWaving1.gif");
        OptionMapping userMapping = event.getOption("user");
        User user;
        if (userMapping != null) {
            user = userMapping.getAsUser();
        } else {
            user = event.getUser();
        }

        EmbedBuilder eb = new EmbedBuilder();
        eb.setTitle("Welcome, " + user.getName());
        eb.setColor(Color.RED);
        MessageEmbed embed = eb.build();

        event.replyEmbeds(embed).addFiles(this).queue();
    }
}
