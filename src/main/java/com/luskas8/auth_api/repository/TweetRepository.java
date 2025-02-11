package com.luskas8.auth_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.luskas8.auth_api.entities.Tweet;

@Repository
public interface TweetRepository extends JpaRepository<Tweet, Long> {
}
