import commands.Manager;
import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.sharding.DefaultShardManagerBuilder;
import net.dv8tion.jda.api.sharding.ShardManager;

import javax.security.auth.login.LoginException;

@SuppressWarnings("InstantiationOfUtilityClass")
public class CommyBot {
    public CommyBot() throws LoginException {
        Dotenv config = Dotenv.configure().load();
        String token = config.get("TOKEN");
        DefaultShardManagerBuilder builder = DefaultShardManagerBuilder.createDefault(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setActivity(Activity.watching("Communist Propaganda"));
        ShardManager shardManager = builder.build();

        shardManager.addEventListener(new Manager());
    }
    public static void main(String[] args) {
        try {
            CommyBot bot = new CommyBot();
            System.out.println("Using " + bot);
        } catch (LoginException loginException) {
            System.out.println("LoginException: Is your token correct? " + loginException);
        }
    }
}
