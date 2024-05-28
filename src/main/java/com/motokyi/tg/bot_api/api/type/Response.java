package com.motokyi.tg.bot_api.api.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The response contains a JSON object, which always has a Boolean field 'ok'
 * and may have an optional String field 'description' with a human-readable description of the result.
 * If 'ok' equals True, the request was successful and the result of the query can be found in the 'result' field.
 * In case of an unsuccessful request, 'ok' equals false and the error is explained in the 'description'.
 * An Integer 'error_code' field is also returned, but its contents are subject to change in the future.
 * Some errors may also have an optional field 'parameters' of the type ResponseParameters,
 * which can help to automatically handle the error.
 *
 * @version Bot API 7.3
 * @see <a href="https://core.telegram.org/bots/api#making-requests">Response</a>
 */

@Data
@NoArgsConstructor
public class Response<T> {

    private boolean ok;

    private T result;

    @JsonProperty("error_code")
    private Integer errorCode;

    private String description;

    private ResponseParameters parameters;
}
