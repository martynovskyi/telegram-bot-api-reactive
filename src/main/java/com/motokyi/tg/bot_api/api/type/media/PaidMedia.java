package com.motokyi.tg.bot_api.api.type.media;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.motokyi.tg.bot_api.api.constant.PaidMediaTypes;
import lombok.Data;

/**
 * This object describes paid media.
 *
 * <ul> Currently, it can be one of
 * <li> PaidMediaPreview
 * <li> PaidMediaPhoto
 * <li> PaidMediaVideo
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#paidmedia">PaidMedia</a>
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = PaidMediaPreview.class, name = PaidMediaTypes.PREVIEW),
        @JsonSubTypes.Type(value = PaidMediaPhoto.class, name = PaidMediaTypes.PHOTO),
        @JsonSubTypes.Type(value = PaidMediaVideo.class, name = PaidMediaTypes.VIDEO),
})
public class PaidMedia {
    private String type;
}
