package com.motokyi.choiceness.telegram.api.methods;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.motokyi.choiceness.telegram.api.types.TGResponce;
import com.motokyi.choiceness.telegram.api.types.Update;
import com.motokyi.choiceness.telegram.webclient.TGBotWebClient;
import lombok.Getter;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * Use this method to receive incoming updates using long polling (wiki). An Array of Update objects is returned.
 * See <a href="GetUpdates">https://core.telegram.org/bots/api#getupdates</a>
 * <p>
 * Field	        Type	        Required    Description
 * offset	        Integer      	Optional	Identifier of the first update to be returned. Must be greater by one than the highest among the identifiers of previously received updates. By default, updates starting with the earliest unconfirmed update are returned. An update is considered confirmed as soon as getUpdates is called with an offset higher than its update_id. The negative offset can be specified to retrieve updates starting from -offset update from the end of the updates queue. All previous updates will forgotten.
 * limit	        Integer      	Optional	Limits the number of updates to be retrieved. Values between 1—100 are accepted. Defaults to 100.
 * timeout	        Integer      	Optional	Timeout in seconds for long polling. Defaults to 0, i.e. usual short polling. Should be positive, short polling should be used for testing purposes only.
 * allowed_updates	Array of String	Optional	List the types of updates you want your bot to receive. For example, specify [“message”, “edited_channel_post”, “callback_query”] to only receive updates of these types. See Update for a complete list of available update types. Specify an empty list to receive all updates regardless of type (default). If not specified, the previous setting will be used.
 * <p>
 * Please note that this parameter doesn't affect updates created before the call to the getUpdates, so unwanted updates may be received for a short period of time.
 * Notes
 * 1. This method will not work if an outgoing webhook is set up.
 * 2. In order to avoid getting duplicate updates, recalculate offset after each server response.
 */
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetUpdates {
    @JsonIgnore
    private final TGBotWebClient rt;

    private Long offset;

    private Integer limit;

    private Integer timeout;

    @JsonProperty("allowed_updates")
    private List<String> allowedUpdates;

    public GetUpdates(TGBotWebClient rt) {
        this.rt = rt;
    }

    public Mono<TGResponce<List<Update>>> send() {
        return rt.getUpdates(this);
    }

}