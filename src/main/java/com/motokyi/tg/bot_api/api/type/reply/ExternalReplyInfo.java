package com.motokyi.tg.bot_api.api.type.reply;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.*;
import com.motokyi.tg.bot_api.api.type.chat.Chat;
import com.motokyi.tg.bot_api.api.type.game.Game;
import com.motokyi.tg.bot_api.api.type.giveaway.Giveaway;
import com.motokyi.tg.bot_api.api.type.giveaway.GiveawayWinners;
import com.motokyi.tg.bot_api.api.type.media.*;
import com.motokyi.tg.bot_api.api.type.message.origin.MessageOrigin;
import com.motokyi.tg.bot_api.api.type.payment.Invoice;
import com.motokyi.tg.bot_api.api.type.poll.Poll;
import com.motokyi.tg.bot_api.api.type.sticker.Sticker;
import java.util.List;
import lombok.Data;

/**
 * This object contains information about a message that is being replied to, which may come from
 * another chat or forum topic.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#externalreplyinfo">ExternalReplyInfo</a>
 */
@Data
public class ExternalReplyInfo {

    private MessageOrigin origin;

    private Chat chat;

    @JsonProperty(ApiProperties.MESSAGE_ID)
    private Long messageId;

    @JsonProperty(ApiProperties.LINK_PREVIEW_OPTIONS)
    private LinkPreviewOptions linkPreviewOptions;

    private Animation animation;

    private Audio audio;

    private Document document;

    @JsonProperty(ApiProperties.PAID_MEDIA)
    private PaidMediaInfo paidMedia;

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

    private Giveaway giveaway;

    @JsonProperty(ApiProperties.GIVEAWAY_WINNERS)
    private GiveawayWinners giveawayWinners;

    private Invoice invoice;

    private Location location;

    private Poll poll;

    private Venue venue;
}
