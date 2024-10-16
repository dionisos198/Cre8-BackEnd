package com.gaduationproject.cre8.app.chat.dto.response;

import com.gaduationproject.cre8.app.chat.dto.request.ChatDto;
import com.gaduationproject.cre8.externalApi.mongodb.domain.ChattingMessage;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class MessageResponseDto implements Serializable {

    private Long senderId;
    private String contents;
    private LocalDateTime createdAt;
    private MessageType messageType;
    private Integer readCount;
    private Long chattingRoomId;

//    public static MessageResponseDto of(Message message){
//        return new MessageResponseDto(message.getSender().getId(),message.getContents());
//    }

    public static MessageResponseDto ofChatMessage(final ChattingMessage chattingMessage){

        return new MessageResponseDto(chattingMessage.getSenderId(),
                                      chattingMessage.getContents(),
                                      chattingMessage.getCreatedAt(),
                                      MessageType.MESSAGE,
                                      chattingMessage.getReadCount(),
                                      chattingMessage.getChattingRoomId());
    }

    public static MessageResponseDto ofPayLoad(final Long memberId,final ChatDto chatDto,final LocalDateTime createdAt,final int readCount,
            final Long chatRoomId){

        return new MessageResponseDto(memberId,chatDto.getMessage(),createdAt,MessageType.MESSAGE,readCount,chatRoomId);
    }

    public static MessageResponseDto ofEnter(final String contents,final Long chattingRoomId){
        return new MessageResponseDto(null,contents,null,MessageType.ENTER,null,chattingRoomId);
    }


}
