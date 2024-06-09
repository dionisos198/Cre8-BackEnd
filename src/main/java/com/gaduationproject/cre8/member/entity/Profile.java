package com.gaduationproject.cre8.member.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Profile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profile_id")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String personalStatement;

    private String youtubeLink;

    private String personalLink;

    private String twitterLink;

    @Builder
    public Profile(String personalStatement,String youtubeLink,String personalLink,String twitterLink){
        this.personalStatement = personalStatement;
        this.youtubeLink = youtubeLink;
        this.personalLink = personalLink;
        this.twitterLink = twitterLink;
    }

    public void changeProfile(final String youtubeLink,final String personalLink,final String twitterLink,final String personalStatement){
        this.personalStatement = personalStatement;
        this.youtubeLink = youtubeLink;
        this.personalLink = personalLink;
        this.twitterLink = twitterLink;
    }






}
