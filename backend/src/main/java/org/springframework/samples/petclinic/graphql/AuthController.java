package org.springframework.samples.petclinic.graphql;

import graphql.schema.DataFetchingEnvironment;
import graphql.schema.idl.RuntimeWiring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.execution.RuntimeWiringConfigurer;
import org.springframework.samples.petclinic.auth.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * EXAMPLE:
 * --------------------------
 *
 * - Use 'plain' DataFetcher methods with Spring GraphQL (although Annotated Controllers might
 *   be the preferred way to write data fetchers now)
 */
@Controller
public class AuthController {
    private static final Logger log = LoggerFactory.getLogger(AuthController.class);

    @QueryMapping
    public User me(@AuthenticationPrincipal User user) {
        return user;
    }

    @QueryMapping
    public String ping() { return "pong"; }
}
