package lif.majiang.community.dto;

import java.awt.print.PrinterGraphics;
import java.security.PrivateKey;

/**
 * Created by Administrator on 2020/3/16.
 */
public class GithubUser {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    private String name;
    private String bio;

}
