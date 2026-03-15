package com.family.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.family.model.Member;
import com.family.repository.MemberRepository;

@Service
public class MemberService {

 @Autowired
 MemberRepository repo;

 public List<Member> getMembers(){
  return repo.findAll();
 }

 public Member getMember(Long id){
  return repo.findById(id).orElse(null);
 }

 public Member saveMember(Member m){
  return repo.save(m);
 }
}