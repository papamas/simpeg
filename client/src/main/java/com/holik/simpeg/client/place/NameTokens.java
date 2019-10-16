package com.holik.simpeg.client.place;

import static com.holik.simpeg.client.place.ParameterTokens.ID;

public class NameTokens {
   
    public static final String LOGIN = "/login";
    public static final String HOME = "/home";
    public static final String PROFILE = "/profile";
    public static final String LIST = "/list";
    public static final String TASK = "/tasks/{" + ID + "}";
    public static final String EDIT = "/edit/{" + ID + "}";
    public static final String ADD = "/add";
}
