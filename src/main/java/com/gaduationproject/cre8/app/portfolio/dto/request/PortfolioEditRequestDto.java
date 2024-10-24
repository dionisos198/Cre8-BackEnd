package com.gaduationproject.cre8.app.portfolio.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PortfolioEditRequestDto {

    @NotNull(message = "포트폴리오 아이디는 공백이 될 수 없습니다")
    @Schema(description = "포트폴리오 아이디를 입력합니다",example = "1")
    private Long portfolioId;


    @Schema(description = "포트폴리오 상위 태그 번호를 입력합니다",example = "2")
    private Long workFieldId;

    @Schema(description = "포트폴리오 하위 태그 리스트 번호를 입력합니다")
    private List<Long> workFieldChildTagId = new ArrayList<>();

    @Schema(description = "포트폴리오 용 이미지를 새로 등록합니다-신규등록")
    private List<MultipartFile> multipartFileList = new ArrayList<>();

    @Schema(description = "포트폴리오 용 이미지 중 삭제할 ID 를 입력해주세요")
    private List<Long> deletePortfolioImageList = new ArrayList<>();

    @Schema(description = "작품에 대한 설명을 입력합니다")
    private String description;

    @Builder
    public PortfolioEditRequestDto(final Long portfolioId,
            final Long workFieldId, final List<Long> workFieldChildTagId, final List<MultipartFile> multipartFileList,
            final List<Long> deletePortfolioImageList, String description) {
        this.portfolioId = portfolioId;
        this.workFieldId = workFieldId;
        this.workFieldChildTagId = workFieldChildTagId;
        this.multipartFileList = multipartFileList;
        this.deletePortfolioImageList = deletePortfolioImageList;
        this.description = description;
    }
}
