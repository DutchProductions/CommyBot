package commands.test;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

import java.awt.*;

public class Ping {
    public Ping(SlashCommandInteractionEvent event) {
        MessageEmbed embed = new EmbedBuilder().setTitle("Pong!").setColor(Color.RED).build();

        event.replyEmbeds(embed).queue();
    }
}
