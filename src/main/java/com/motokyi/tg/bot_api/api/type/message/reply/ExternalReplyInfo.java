package com.motokyi.tg.bot_api.api.type.message.reply;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.*;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.game.Game;
import com.motokyi.tg.bot_api.api.type.media.*;
import com.motokyi.tg.bot_api.api.type.message.origin.MessageOrigin;
import com.motokyi.tg.bot_api.api.type.payment.Invoice;
import com.motokyi.tg.bot_api.api.type.poll.Poll;
import com.motokyi.tg.bot_api.api.type.sticker.Sticker;
import lombok.Data;

import java.util.List;

/**
 * This object contains information about a message that is being replied to, which may come from another chat or forum topic.
 * See <a href="ExternalReplyInfo">https://core.telegram.org/bots/api#externalreplyinfo</a>
 * <p>
 *
 * @version Bot API 7.0
 */
@Data
public class ExternalReplyInfo {

    private MessageOrigin origin;

    private Chat chat;

    @JsonProperty(ApiProperties.MESSAGE_ID)
    private Long messageId;

    //todo: private LinkPreviewOptions link_preview_options;

    private Animation animation;

    private Audio audio;

    private Document document;

    @JsonProperty(ApiProperties.PHOTO)
    private List<PhotoSize> photo;

    private Sticker sticker;

    private Story story;

    private Video video;

    @JsonProperty(ApiProperties.VIDEO_NOTE)
    private VideoNote videoNote;

    private Voice voice;

    @JsonProperty(ApiProperties.HAS_MEDIA_SPOILER)
    private Boolean hasMediaSpoiler;

    private Contact contact;

    private Dice dice;

    private Game game;

    //todo: private Giveaway giveaway;
    //todo: private GiveawayWinners giveaway_winners;

    private Invoice invoice;

    private Location location;

    private Poll poll;

    private Venue venue;

}
