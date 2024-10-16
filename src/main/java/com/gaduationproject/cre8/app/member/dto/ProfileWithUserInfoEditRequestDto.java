package com.gaduationproject.cre8.app.member.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ProfileWithUserInfoEditRequestDto {

    @Schema(description = "사용자 닉네임")
    @NotEmpty(message = "사용자 닉네임을 입력해주세요")
    @Size(min = 5, max = 20, message = "최소 5글자에서 최대 20글자를 입력해주세요")
    private String userNickName;

    @Schema(description = "이미지 데이터")
    private MultipartFile multipartFile;

    @Schema(description = "사용자의 유튜브 링크",example = "www.youtube.com")
    private String youtubeLink;

    @Schema(description = "사용자의 트위터 링크",example = "www.twiiter.com")
    private String twitterLink;

    @Schema(description = "사용자의 개인 링크",example = "www.personalLink.com")
    private String personalLink;

    @Schema(description = "사용자의 소개 html 문서 등등 ",example = "<h3> 저는 이런 사람입니다</h3> <li>짱짱한 사람</li>")
    private String personalStatement;




    @Builder
    public ProfileWithUserInfoEditRequestDto(String userNickName,
                                MultipartFile multipartFile,
                                String youtubeLink,
                                String twitterLink,
                                String personalLink,
                                 String personalStatement){
        this.youtubeLink = youtubeLink;
        this.twitterLink = twitterLink;
        this.personalLink = personalLink;
        this.personalStatement = personalStatement;
        this.multipartFile = multipartFile;
        this.userNickName = userNickName;
    }

}
