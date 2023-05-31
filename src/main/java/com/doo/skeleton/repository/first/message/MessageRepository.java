package com.doo.skeleton.repository.first.message;

import org.springframework.data.jpa.repository.JpaRepository;

import com.doo.skeleton.repository.first.message.vo.Message;

public interface MessageRepository extends JpaRepository<Message, String> {

}
