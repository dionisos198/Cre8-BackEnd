package com.gaduationproject.cre8.externalApi.redis.repository;

import com.gaduationproject.cre8.externalApi.redis.domain.ChattingRoomConnect;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface ChattingRoomConnectRepository extends CrudRepository<ChattingRoomConnect, String> {

    List<ChattingRoomConnect> findByChattingRoomId(Long chattingRoomId);

    Optional<ChattingRoomConnect> findByChattingRoomIdAndLoginId(final Long chattingRoomId,final String loginId);
}

