package com.motokyi.tg.bot_api.api.type.poll;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.tg.bot_api.api.constant.ApiProperties;
import com.motokyi.tg.bot_api.api.type.message.MessageEntity;
import java.util.List;
import lombok.Data;

/**
 * This object contains information about a poll.
 *
 * @version Bot API 8.3
 * @see <a href="https://core.telegram.org/bots/api#poll">Poll</a>
 */
@Data
public class Poll {
    private String id;

    private String question;

    @JsonProperty(ApiProperties.QUESTION_ENTITIES)
    private List<MessageEntity> questionEntities;

    private List<PollOption> options;

    @JsonProperty("total_voter_count")
    private Integer totalVoterCount;

    @JsonProperty("is_closed")
    private Boolean isClosed;

    @JsonProperty(ApiProperties.IS_ANONYMOUS)
    private Boolean isAnonymous;

    private String type;

    @JsonProperty("allows_multiple_answers")
    private Boolean allowsMultipleAnswers;

    @JsonProperty("correct_option_id")
    private Integer correctOptionId;

    private String explanation;

    @JsonProperty("explanation_entities")
    private List<MessageEntity> explanationEntities;

    @JsonProperty("open_period")
    private Integer openPeriod;

    @JsonProperty("close_date")
    private Long closeDate;
}
