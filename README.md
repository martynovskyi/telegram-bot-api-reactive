Telegram Bot API based on spring reactor

Currently, code/package structure is not finalized. Pretty raw implementations

### Supported methods

- getUpdates
- sendMessage
- sendDocument
- sendAnimation
- sendPhoto
- forwardMessage
- editMessageReplyMarkup
- getMyCommands
- setMyCommands
- deleteMyCommands

Usage

[WebClient](./src/main/java/com/motokyi/tg/bot_api/client/BotWebClient.java)

### Configuration

application.yml

```yaml
telegram:
  bots:
    - name: test_bot
      token: 5151515151:bot-token-check-bot-father
    - name: example_bot
      token: 0101010101:bot-token-check-bot-father
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