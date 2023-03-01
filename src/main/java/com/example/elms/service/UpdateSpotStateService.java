package com.example.elms.service;

import javax.security.auth.login.LoginException;

public interface UpdateSpotStateService {
    int update(String id, String state) throws LoginException;
}
