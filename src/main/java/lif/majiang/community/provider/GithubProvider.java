package lif.majiang.community.provider;

import com.alibaba.fastjson.JSON;
import lif.majiang.community.dto.AccesstokenDTO;
import lif.majiang.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static okhttp3.MediaType.get;

/**
 * Created by Administrator on 2020/3/16.
 */
@Component
public class GithubProvider {
    public String getAccessToken(AccesstokenDTO accesstokenDTO) {
        MediaType mediaType = get("application/json; charset=utf-8");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accesstokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            String token = string.split("&")[0].split("=")[1];
            System.out.print(string);
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user？access)token=" + accessToken)
                .build();
        try (Response response = client.newCall(request).execute()) {
            String string = response.body().string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }
}
