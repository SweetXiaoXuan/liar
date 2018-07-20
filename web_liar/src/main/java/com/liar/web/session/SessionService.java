package com.liar.web.session;

import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionService {
    @Transactional
    public static void save(HttpServletRequest req) {
        try {
            HttpSession session = req.getSession(true);
            req.getSession().setAttribute("test", "defrgjnfvnlssvfbbn");
            session.setMaxInactiveInterval(60 * 60 * 24);
//            logger.info("session有效时间：" + session.getMaxInactiveInterval());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
