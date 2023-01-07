package commands.qol;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.channel.middleman.MessageChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.interactions.commands.OptionMapping;

import java.awt.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Purge {
    public Purge(SlashCommandInteractionEvent event) {
        OptionMapping amountMapping = event.getOption("amount");
        AtomicInteger iter = new AtomicInteger(1);
        int amount;
        if (amountMapping != null) { amount = amountMapping.getAsInt(); }
        else { amount = 10; }

        MessageChannel channel = event.getMessageChannel();

        channel.getIterableHistory().forEach(message -> {
            if (iter.get() <= amount) {
                message.delete().queue();
            } iter.getAndIncrement();
        });

        MessageEmbed userEmbed = new EmbedBuilder().setTitle("Done!").setDescription("Purged " + amount + " messages!").setColor(Color.RED).build();

        event.replyEmbeds(userEmbed).queue(msg -> msg.deleteOriginal().queueAfter(3, TimeUnit.SECONDS));
    }
}
