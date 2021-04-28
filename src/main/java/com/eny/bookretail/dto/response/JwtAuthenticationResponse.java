package com.eny.bookretail.dto.response;

import com.eny.bookretail.constants.*;
import lombok.Data;

@Data
public class JwtAuthenticationResponse {
    private String accessToken;
    private String tokenType = AuthenticationConstants.BEARER_TOKEN_TYPE;

    public JwtAuthenticationResponse(String accessToken) {
        this.accessToken = accessToken;
    }
}
