Telegram Bot API based on Spring reactor
Java 21

Currently, code/package structure is not finalized. Pretty raw implementations

### Supported methods

- Bot Commands
    - [getMyCommands](https://core.telegram.org/bots/api#getmycommands)
    - [setMyCommands](https://core.telegram.org/bots/api#setmycommands)
    - [deleteMyCommands](https://core.telegram.org/bots/api#deletemycommands)
- Bot Info
    - [getMe](https://core.telegram.org/bots/api#getme)
    - [getMyName](https://core.telegram.org/bots/api#getmyname)
    - [setMyName](https://core.telegram.org/bots/api#setmyname)
    - [getMyDescription](https://core.telegram.org/bots/api#getmydescription)
    - [setMyDescription](https://core.telegram.org/bots/api#setmydescription)
    - [getMyShortDescription](https://core.telegram.org/bots/api#getmyshortdescription)
    - [setMyShortDescription](https://core.telegram.org/bots/api#setmyshortdescription)
- [getUpdates](https://core.telegram.org/bots/api#getupdates)
- [getChat](https://core.telegram.org/bots/api#getchat)
- sendMessage
- sendDocument
- sendAnimation
- sendPhoto
- forwardMessage
- [setMessageReaction](https://core.telegram.org/bots/api#setmessagereaction)
- editMessageReplyMarkup
- deleteMessage
- Webhook
    - [setWebhook](https://core.telegram.org/bots/api#setwebhook)
    - [getWebhookInfo](https://core.telegram.org/bots/api#getwebhookinfo)
    - [deleteWebhook](https://core.telegram.org/bots/api#deletewebhook)

### Configuration

application.yml

```yaml
telegram:
  bots:
    - name: example_bot # unique | required | 
      token: 5151515151:ask-bot-father # required | bot token from BotFather
    - name: other_bot
      token: 0101010101:ask-bot-father
```

### Usage

```java

@Slf4j
@Component
@RequiredArgsConstructor
public class Example {
    private final BotFactory botFactory;

    public void sayHello(String recipientId) {
        Optional<Bot> testBot = botFactory.get("test_bot");
        testBot.ifPresent(bot ->
                bot.sendMessage(recipientId)
                        .setText("Hello 👋")
                        .subscribe(response ->
                                log.info("Said hello to {}, is Ok {}", recipientId, response.isOk())
                        ));
    }
}
```

### Implementation details

#### Client

[Interface](src/main/java/com/motokyi/tg/bot_api/client/BotApiClient.java)
and [Implementation](src/main/java/com/motokyi/tg/bot_api/client/BotClient.java)

This is implementation of Telegram Bot API. Here build and executes all requests to Telegram.

This layer uses method DTOs from `com.motokyi.tg.bot_api.api.method.payload` package

#### Bot

[Interface](src/main/java/com/motokyi/tg/bot_api/bot/Bot.java)
and [Implementation](src/main/java/com/motokyi/tg/bot_api/bot/TelegramBot.java)

This is abstraction built on top of Client. It allows to use chained construction to setup requests to Bot Api

This layer uses methods from `com.motokyi.tg.bot_api.api.method` package. These methods are DTOs enhanced with the
ability to self-execution and chained setters.



