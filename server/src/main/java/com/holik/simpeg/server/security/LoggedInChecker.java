package com.holik.simpeg.server.security;

import com.holik.simpeg.shared.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

//import com.nuvola.myproject.shared.model.User;

@Component
public class LoggedInChecker {
    public User getLoggedInUser() {
        User user = null;

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();

            // principal can be "anonymousUser" (String)
            if (principal instanceof SimpegUserDetails) {
                SimpegUserDetails userDetails = (SimpegUserDetails) principal;
                user = userDetails.getUser();
            }
        }

        return user;
    }
}
