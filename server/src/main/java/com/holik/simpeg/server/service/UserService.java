package com.holik.simpeg.server.service;

import com.holik.simpeg.shared.model.User;
import java.util.List;

//import com.nuvola.myproject.shared.model.User;

public interface UserService {
    User getUserByUsername(String username);

    List<String> getPermissions(String username);

    User getCurrentUser();

    Boolean isCurrentUserLoggedIn();
}
