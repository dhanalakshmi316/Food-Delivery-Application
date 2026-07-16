package com.tastego.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtil {

    public static HttpSession getSession(HttpServletRequest request) {

        return request.getSession();

    }

    public static void invalidate(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {

            session.invalidate();

        }

    }

}
