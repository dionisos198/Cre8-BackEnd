package com.gaduationproject.cre8.domain.community.repository;

import com.gaduationproject.cre8.domain.community.entity.CommunityPost;
import com.gaduationproject.cre8.domain.community.entity.Reply;
import com.gaduationproject.cre8.domain.member.entity.Member;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReplyRepository extends JpaRepository<Reply,Long> {

     void deleteByParentReply(final Reply parentReply);

     void deleteByCommunityPostId(final Long communityPostId);

     @Query("select r from Reply r join fetch r.writer where r.communityPost.id=:communityPostId and r.parentReply is NULL order by r.createdAt")
     List<Reply> findParentReplyByPostIdOrderByCreatedWithFetchWriter(@Param("communityPostId") final Long communityPostId);

    @Query("select r from Reply r join fetch r.writer where r.parentReply.id=:parentId order by r.createdAt")
    List<Reply> findChildByParentIdOrderByCreatedAtWithFetchWriter(@Param("parentId") Long parentId);

    @Query("select count(r) from Reply r where r.communityPost.id=:communityPostId")
    int totalReplyCount(@Param("communityPostId")final Long communityPostId);

    void deleteByWriter(final Member member);

    @Query("select r from Reply r where r.parentReply is NULL and r.writer=:member")
    List<Reply> findParentReplyAndMember(final Member member);



}
