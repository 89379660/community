package lif.majiang.community.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import lif.majiang.community.dto.AccesstokenDTO;
import lif.majiang.community.dto.GithubUser;
import lif.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Name;

/**
 * Created by Administrator on 2020/3/16.
 */
@Controller
public class AuthorizeController {
    @Autowired
    GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                            @RequestParam(name="state") String state){
        AccesstokenDTO accesstokenDTO = new AccesstokenDTO();
        accesstokenDTO.setCode(code);
        accesstokenDTO.setClient_id(" Iv1.642004606254e715");
        accesstokenDTO.setRedirect_rui("http://localhost:8081/callback");
        accesstokenDTO.setState(state);
        accesstokenDTO.setClient_secret(" 203bf68d30316845da087341d33c431fae8a9114");
        String token = githubProvider.getAccessToken(accesstokenDTO);
        GithubUser user = githubProvider.getUser(token);
        System.out.print(user.getName());
        return "greeting";
    }

}

